diff :: Int -> Int -> Int
diff x y = abs (x - y)

triangleArea :: Float -> Float -> Float -> Float
triangleArea x y z = sqrt(s*((s-x)*(s-y)*(s-z)))
	where s = (x + y + z) / 2

isSum :: Int -> Int -> Int -> Bool
isSum x y z = (x + y == z) || (x + z == y) || (z + y == x)

isTriangle :: Float -> Float -> Float -> Float
isTriangle x y z = 
		if (x + y > z) && (x + z > y) && (y + z > x)
			then triangleArea x y z
			else error "Not a triangle"
