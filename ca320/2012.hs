-- 2012
import qualified Data.List as List


--
-- Question one
triangle :: (Int,Int,Int) -> String
triangle (a,b,c) = 
	if (a + b < c) || (a + c < b) || (b + c < a)
	then "Not valid triangle"
	else equalateral (a,b,c)

equalateral :: (Int,Int,Int) -> String
equalateral (a,b,c) = 
	if a == b && a == c && b == c
	then "Equaleteral"
	else isosceles (a,b,c)

isosceles :: (Int,Int,Int) -> String
isosceles (a,b,c) = 
	if (a == b || a == c || b == c)
	then "Isosceles"
	else "Scalene" 

-- Question two
union' :: [Int] -> [Int] -> [Int]
union' [x] _ = []
union' _ [y] = []
union' xs ys = duplicates $ xs ++ ys

duplicates :: [Int] -> [Int]
duplicates [] = []
duplicates [x] = [x]
duplicates (x:xs) = 
	if x `elem` xs
	then duplicates xs
	else x : duplicates xs

-- Question 2 B
data BinTree t = Empty | Root Int (BinTree t) (BinTree t)
		deriving Show
					
myTree = Root 5 (Root 1 (Empty) (Root 3 Empty Empty)) (Root 7 Empty Empty)








