(defn exp[n]
    (reduce *' (repeat n x)))

(println (reduce + (map #(Character/getNumericValue %) (flatten (partition 1 (str (exp 2 1000)))))))
