(def fibn (lazy-seq (map + (cons 0 (cons 0 fibn)) (cons 1 fibn))))
(println (reduce + (take-while (partial >= 4000000) (filter even? fibn))))
