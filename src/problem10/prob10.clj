(defn prime? [n]
    (if (and (not (= n 2)) (even? n)) false (if (= n 2) true
        (not-any? #(zero? (mod n %)) (range 3 (inc (Math/ceil (Math/sqrt n))) 2))
)))

(println (reduce + (filter prime? (range 2 2000000))))
