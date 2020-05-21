type Node = Integer
type Edge = (Integer, Integer)
type Graph = [Edge]
type Path = [Node] 
g :: Graph 
g = [ (1, 2), (1, 3), (2, 3), (2, 4), (3, 4), (1, 5), (3, 1) ]
h :: Graph 
h = [ (1, 2), (1, 3),(2, 1), (3, 2), (4, 4) ]

fromFirst :: Graph -> [Integer]
fromFirst gr = [a | (a, b) <- gr] 

fromSecond :: Graph -> [Integer]
fromSecond gr = [b | (a, b) <- gr] 

merge :: [Integer] -> [Integer] -> [Integer]
merge xs     []     = xs
merge []     ys     = ys
merge (x:xs) (y:ys) = x : y : merge xs ys

quicksort :: [Integer] -> [Integer]
quicksort [] = []
quicksort (x:xs) = (quicksort [y| y <- xs, y < x]) ++ [x] ++ (quicksort [y|y <- xs, y > x])

nodes :: Graph -> [Integer]
nodes gr = quicksort(merge (fromFirst gr) (fromSecond gr))

adjacent :: Node -> Graph -> [Integer]
adjacent n gr = [b | (a,b) <- gr , a == n]

detach :: Node -> Graph -> [(Integer, Integer)]
detach n gr = [(a,b) | (a,b) <- gr , a /= n]

allPaths :: Node -> Graph -> [Path]
allPaths start gr = map (start:) (findPaths start gr [start])
  where 
    findPaths current gr visited = 
      case [ snd node | node <- gr, fst node == current ] of 
      [] -> [[]]
      remaining -> [ next : path | next <- remaining, notElem next visited, path <- findPaths next gr (next:visited)]

paths:: Node -> Node -> Graph -> [Path]
paths n1 n2 g = [step | step <- allPaths n1 g, last step == n2]

main::IO()
main = do 
print()



