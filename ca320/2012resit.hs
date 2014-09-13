area :: (Float, Float, Float) -> Float
area (x,y,z) =  let s = (x + y + z) / 2
                in sqrt(s * ((s - x) * (s - y) * (s - z)))

shortest :: (Ord a, Eq a) => [[a]] -> [a]
shortest [a] = a
shortest (x:y:xs) = if length x < length y
                    then shortest (x:xs)
                    else shortest (y:xs)


evalPoly :: Int -> [Int] -> Int
evalPoly a [x] = a + x
evalPoly a (x:xs)  = a + x * evalPoly a xs

oddSquares = sum [ x^2 | x <- [1..1000], x `mod` 2 == 0 || x `mod` 5 == 0] 
