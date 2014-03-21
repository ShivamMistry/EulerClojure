(defn fact[n] (reduce *' (range 1 (inc n))))

(println (/ (fact (+ 20 20)) (*' (fact 20) (fact 20))))
