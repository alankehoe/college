-- Q1
isPalindrome :: (Eq a) => [a] -> Bool
isPalindrome a = a == reverse a

-- Q2
shortest :: [[a]] -> [a]
shortest [] = []
shortest [x] = x
shortest (x:xs) = 
		if length x < length (shortest xs)
		then x
		else shortest xs

-- Q3
type Poly = [Int]

sumPoly :: Poly -> Poly -> Poly
sumPoly (x:xs) [] = (x:xs)
sumPoly [] (y:ys) = (y:ys)
sumpoly (x:xs) (y:ys) = (x + y) : sumPoly xs ys
 
