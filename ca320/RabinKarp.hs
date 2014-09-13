-- Alan Kehoe
-- 10735389

-- Assignment 2 RabinKarp String Search

import Data.Char (ord)

-- take in 2 Strings and return a bool if there is a match of the
-- pattern in the string.. if there are two empty string return false
-- hash the pattern then hash the chunk of text found using the next
-- function declared below if i found it return true else keep going and
-- drop the head of (x:xs) and do the rabinkarp function on xs (y:ys)
-- because you dont want to drop anything of of the pattern.. that would
-- render this function useless

rabinKarp :: String -> String -> Bool
rabinKarp "" "" = False
rabinKarp (x:xs) (y:ys) =
        if hash (next (x:xs) (length (y:ys))) 256 == hash (y:ys) 256
        then True
        else rabinKarp xs (y:ys)


-- Given a String and an int we will hash the string to some value

hash :: String -> Int -> Int
hash [] _ = 0
hash (x:xs) i = (ord x) * 256 + hash xs (i -1)


-- Return a chunk of text the same size of the pattern
-- if length of pattern == 0 then we dont care about the
-- text cause there is nothing to look for
-- else recursively return chars untill we have a chunk
-- the same size of the pattern

next :: String -> Int -> String
next _ 0 = []
next (x:xs) i = x : next xs (i -1)

