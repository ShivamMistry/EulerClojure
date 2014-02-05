; a^2 + b^2 = c^2
; a + b + c = 1000
; find abc

(println 
    (apply * (set (flatten (filter #(= (+ (Math/pow (first (rest %)) 2) (Math/pow (first %) 2)) (Math/pow (last %) 2))
        (filter #(> (count %) 0)
            (apply concat
                (for [x (range 1 500)]
                    (for [y (range 1 500)]
                       [x y (- 1000 x y)])))))))))
