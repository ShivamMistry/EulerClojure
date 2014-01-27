(println (reduce + (concat (filter (fn[x] (not (= (mod x 5) 0))) (range 0 1000 3)) (range 0 1000 5))))
