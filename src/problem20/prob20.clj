(defn fact[n]
    (reduce *' (range 1 (inc n)))
)

(defn digits[n]
    (if (zero? n)
        []
        (let [r (quot n 10) d (mod n 10)]
            (conj (digits r) d))
    )
)

(println (reduce +' (digits (fact 100))))
