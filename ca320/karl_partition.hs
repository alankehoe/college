atIndex :: [Int] -> Int -> Int
atIndex (x:xs) 1 = x
atIndex [] _ = 0
atIndex (x:xs) a = if (a > 1)
		then atIndex (xs) (a-1)
		else x


partition :: [Int] -> [[Int]]
partition [] = []
partition (x:xs) = indexed (x:xs) (adell (rearrange(length(x:xs))1) [1] (tail (rearrange(length(x:xs))1)) [1] (x:xs)) : [ indexed (x:xs)(review (rearrange(length(x:xs)) 1) (adell (rearrange(length(x:xs))1) [1] (tail (rearrange(length(x:xs))1)) [1] (x:xs)))]
		

adell :: [Int] -> [Int] -> [Int] -> [Int] -> [Int] -> [Int]
adell [] _ _ _ _= []
adell (x:xs) (y:ys) (z:zs) (w:ws) (v:vs) = if(last(y:ys) == length (x:xs) && length(z:zs) == 1)
										then (w:ws)
										else 
											if(last(y:ys) == length (x:xs))
												then adell (x:xs) (rearrange(length(y:ys) + 1) 1) (review (x:xs)(rearrange(length(y:ys) + 1) 1) ) (balanced (y:ys) (z:zs) (w:ws) (review (x:xs)(w:ws))(v:vs)) (v:vs)
												else adell (x:xs) (change (y:ys)) (review (x:xs)(change (y:ys)) ) (balanced (y:ys) (z:zs) (w:ws) (review (x:xs)(w:ws)) (v:vs))  (v:vs)

												
--- 2 sets of indexes sum up both and subtract from each other, compare with the current smallest     (change (y:ys)) && (review (x:xs)(change (y:ys)) )   --------    (y:ys) (z:zs)
--(balanced(indexed(v:vs)(y:ys)) (indexed(v:vs)(z:zs)))
												
change :: [Int] -> [Int]
change [] = []
change (x:xs) = if(length (x:xs) == 1)
				then (x + 1) : change xs
				else x : change xs
									
									
balanced :: [Int] -> [Int] -> [Int] -> [Int] -> [Int] -> [Int]
balanced (x:xs) (y:ys) (z:zs) (w:ws) (v:vs) = if( smallest (indexed(v:vs)(x:xs)) (indexed(v:vs)(y:ys)) (indexed(v:vs)(z:zs)) (indexed(v:vs)(w:ws)))
							then (x:xs)
							else (z:zs)
							
smallest :: [Int] -> [Int] -> [Int] -> [Int] -> Bool
smallest (x:xs) (y:ys) (z:zs) (w:ws) = if(abs(sumOf(x:xs) - sumOf(y:ys)) < abs(sumOf(z:zs) - sumOf(w:ws)))
							then True
							else False
							
sumOf :: [Int] -> Int
sumOf [] = 0
sumOf (x:xs) = x + sumOf(xs)

rearrange :: Int-> Int -> [Int]
rearrange 0 _= []
rearrange x  y = y : rearrange (x-1)(y+1)

indexed :: [Int] -> [Int] -> [Int]
indexed [] _ = []
indexed _ [] = []
indexed (x:xs) (y:ys) = (atIndex (x:xs) y) : indexed (x:xs) ys

review :: [Int] -> [Int] -> [Int]
review [] _ = []
review x [] = x
review (x:xs) (y:ys) =  review (remove (x:xs) y) ys

remove :: [Int] -> Int -> [Int]
remove [] _ = []
remove (x:xs) y = if(y == x)
					   then
						   remove xs y
					   else 
							x : remove xs y
