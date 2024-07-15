import math

firstMean = 96.71852066666666 #measureMultiplyTrans
secondMean = 250.16421696999998 #measureMultiply1D

firstH = 2.7391007857863583 #measureMultiplyTrans
secondH = 7.646409704453135 #measureMultiply1D

meanMultiply = firstMean * secondMean
sqrtResult = math.sqrt(pow(meanMultiply,2) - (pow(firstMean,2) - pow(firstH,2)) * (pow(secondMean,2) - pow(secondH,2)))
dividerResult = pow(firstMean,2) - pow(firstH,2)

ratio = meanMultiply / dividerResult
upperBound = (meanMultiply + sqrtResult) / dividerResult
lowerBound = (meanMultiply - sqrtResult) / dividerResult

print("Ratio ", ratio)
print("Lower bound ", lowerBound)
print("Upper bound ", upperBound)