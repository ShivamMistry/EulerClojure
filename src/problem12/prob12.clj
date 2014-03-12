(defn is_factor[x,n] (zero? (mod x n)))

(defn factors[n]
     (filter #(is_factor n %) (range 1 (Math/sqrt n))))

(defn triangle[n]
     (int (/ (* n (inc n)) 2.0)))

(println (triangle (first (drop-while #(<= (* 2 (count (factors (triangle %)))) 500) (iterate inc 1)))))
