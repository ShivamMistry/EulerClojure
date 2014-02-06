(println (- (* (reduce + (range 1 101)) (reduce + (range 1 101))) (reduce + (map * (range 1 101) (range 1 101)))))
