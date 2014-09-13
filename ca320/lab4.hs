-- Q1
myAppend :: [a] -> [a] -> [a]
myAppend x y = x ++ y

-- Q2
myHead :: [a] -> a
myHead [] = error "Empty List"
myHead (x:xs) = x

-- Q3
myLast :: [a] -> [a]
myLast [] = error "Empty List"
myLast (x:xs) = xs

-- Q4
myTail :: [a] -> a
myTail [] = error "Empty List"
myTail [x] = x
myTail (x:xs) = myTail xs

-- Q5
myInit :: [a] -> [a]
myInit [] = error "Empty List"
myInit [x] = [x]
myInit (x:xs) = x : myInit xs

-- Q6
myLength :: [a] -> Int
myLength [] = 0
myLength [x] = 1
myLength (x:xs) = 1 + myLength xs

-- Q7
myReverse :: [a] -> [a]
myReverse [] = []
myReverse [x] = [x]
myReverse xs = last xs : reverse (init xs)

-- Q8
myConcat :: [[a]] -> [a]
myConcat [a] = a
myConcat (x:xs) = x ++ myConcat xs

-- Q9
mySum :: Num a => [a] -> a
mySum [] = 0
mySum [x] = x
mySum (x:xs) = x + mySum xs

-- Q10
myProduct :: Num a => [a] -> a
myProduct [] = 0
myProduct [x] = x
myProduct (x:xs) = x * myProduct xs

-- Q11
myMaximum :: Ord a => [a] -> a
myMaximum [x] = x
myMaximum (x:xs) =
	if x > myMaximum xs
		then x
		else myMaximum xs

-- Q12
myMinimum :: Ord a => [a] -> a
myminimum [x] = x
myMinimum (x:xs) = 
	if x < myMinimum xs
		then x
		else myMinimum xs

-- Q13
myElem :: Eq a => a -> [a] -> Bool
myElem a [x] = a == x
myElem a (x:xs) = 
	if a == x
		then True
		else myElem a xs

-- Q14
myDelete :: Eq a => a -> [a] -> [a]
myDelete _ [] = []
myDelete y (x:xs) = 
	if y == x
		then myDelete y xs
		else y : myDelete xs



















