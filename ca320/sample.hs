-- Let a triangle be represented by a tuple where each entry in the tuple represents
-- the length of a side. Write a Haskel function that determines if the tuple represents
-- a right-angle triangle.

triangle :: (Int,Int,Int) -> Bool
triangle (a,b,c) = 
    if (a^2 + b^2 == c^2) || (a^2 + c^2 == b^2) || (b^2 + c^2 == a^2)
        then True
        else False


-- Write a Haskell function that calculates the mean of a list of odd numbers that
-- are not divisible by 3 or 5 and whose sum is less than 2000

list = 
mean xs = sum xs `div` length xs
