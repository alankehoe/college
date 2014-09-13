import qualified Data.List as List
import qualified Data.Map as Map
import qualified Data.Maybe as Maybe

-- Given a list, return a list with every other element removed.
everyOther :: [a] -> [a]
everyOther (x:[]) = [x]
everyOther (x:xs) = x:everyOther (tail xs)
everyOther [] = []

-- Split a single list into a tuple of two lists of roughly equal length.
splitList :: [a] -> ([a], [a])
splitList xs = (everyOther xs, everyOther (tail xs))

-- After splitting the list into two and adding all sums of the first
-- half into a Map, for each entry in the second half, check if the
-- difference between its sum and the desired value is already in the
-- map.  If so, concatenate the value list store in the map with the
-- current value list, as we've found a match.
checkMap :: Map.Map Int [Int] -> Int -> [(Int, [Int])] -> [Int]
checkMap h a (x:xs) =
  let (s, ys) = x
      d = a - s
      j = Map.lookup d h
  in case j of
     Just zs -> zs ++ ys
     Nothing -> checkMap h a xs
checkMap h _ [] = []

-- Given value and list of values, find the subset which sums up to the given value
-- This will give me one side of my balanced partition
subsetSumMap :: Int -> [Int] -> [Int]
subsetSumMap 0 _ = []
subsetSumMap a xs =
  let (x1, x2) = splitList xs
      withSum ys = (foldr (+) 0 ys, ys)
      h = Map.fromList (map withSum (List.subsequences x1))
  in checkMap h a (map withSum (List.subsequences x2))

-- Find the sum of a list
sum' :: [Int] -> Int
sum' [] = 0
sum' (x:xs) = x + sum' xs

-- Simple `div` 2 function
halfSum :: Int -> Int
halfSum x = x `div` 2

-- Get the diff of the lists xs and ys
getRemainder :: [Int] -> [Int] -> [Int]
getRemainder xs ys = (xs List.\\ ys)

-- Main function
partition :: [Int] -> ([Int], [Int])
partition xs = (subsetSumMap (halfSum(sum' xs)) xs, getRemainder xs (subsetSumMap (halfSum(sum' xs)) xs))




























