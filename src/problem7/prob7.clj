(defn prime [n]
    (if (zero? (mod n 2)) 
        0 
    (if (zero? (count (filter #(nil? %) 
        (for [x (range 3 n 2)] 
             (if (zero? (mod n x)) nil x ))))) n 0))

)
(println (nth (filter #(not (zero? %)) (map prime (range))) (dec 10001)))

