package cz.cvut.fel.esw.matrixmultiplication;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class MatrixMultiplicationBenchmark {
    // Highest value
    public static final int UPPER_BOUND = 1000; // value upper bound of the randomly generated matrices

    // Matrix dimensions
    public static final int COLS = 600;
    public static final int ROWS = 400;
    public static final int P = 500;

    // Matrix objects
    public double[][] a;
    public double[][] b;
    public  double[] a1D;
    public  double[] b1D;

    // Result

    public double[][] c;
    public  double[] c1D;


    public static void main(String... args) throws Exception {
        ChainedOptionsBuilder opts = new OptionsBuilder()
                // regex which benchmarks to be included
                // this includes all @Benchmark annotated methods in this class
                // e.g. "*" will include all @Benchmark annotated methods found in the classpath
                .include(MatrixMultiplicationBenchmark.class.getSimpleName())
                // number of warm-up iterations
                // set to 0 for the initial run where we want to select the warm-up for each implementation
                // if we want to set different warm-up for each implementation (and we most likely do),
                // the annotations (@Warmup(iterations = ...)) has to be used on each benchmark method and this function cannot be used (it overrides the annotations)
                .warmupIterations(2)
                // min duration of warm-up iteration
                // 1ms because we want to work with just one invocation per iteration in this benchmark
                .warmupTime(TimeValue.milliseconds(1))
                // number of measured iterations
                .measurementIterations(30)
                // min duration of measured iteration
                // 1ms because we want to work with just one invocation per iteration in this benchmark
                .measurementTime(TimeValue.milliseconds(1))
                //number of executions
                .forks(10)
                // what we want to measure
                .mode(Mode.AverageTime)
                // set JVM args used for the measurements
                // if not set (at least to emtpy args), all JVM args used to run the parent will be used also for the forks
                .jvmArgs()
                // time units at which the results are stored
                .timeUnit(TimeUnit.MILLISECONDS)
                // where to store the results
                .result("matrix_multiplication_benchmark_" + getCurrentTimeString() + ".json")
                // format used to store the results
                .resultFormat(ResultFormatType.JSON);
        new Runner(opts.build()).run();
    }

    @Setup(Level.Iteration)
    public void setup(){
        Random rnd = ThreadLocalRandom.current();

        a = MatrixUtils.generateMatrix(rnd, COLS, ROWS, UPPER_BOUND);
        b = MatrixUtils.generateMatrix(rnd, ROWS, P, UPPER_BOUND);
        a1D = MatrixUtils.to1D(a);
        b1D = MatrixUtils.to1D(b);

        c = new double[0][];
        c1D = new double[0];
    }

    @Benchmark
    public void measureMultiply() {
        c = MatrixUtils.multiply(a, b);
    }

    @Benchmark
    public void measureMultiply1D() {
        c1D = MatrixUtils.multiply1D(a1D, b1D, COLS, ROWS, P);
    }

    @Benchmark
    public void measureMultiplyTrans() {
        c = MatrixUtils.multiplyTrans(a, b);
    }

    public static String getCurrentTimeString() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYYMMdd_HHmmss"));
    }

}
