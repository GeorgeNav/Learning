-- 'ghci test.hs'
-- For latest changes ':reload'
double x = x * 2
quadruple x = double (double x)
factorial n = product [1..n]
-- sum ns / length ns
average ns = sum ns `div` length ns
-- lists have s at the end of the name

zeroto n = [0...n]
(add' x) y = x + y
mult x y z = x*y*z