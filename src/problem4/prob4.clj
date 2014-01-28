(defn is-palindrome[x]
    (. (. (. (new StringBuilder (. Integer toString x)) reverse) toString) equals (. Integer toString x)))

(println (apply max (apply concat (for [x (vec (range 100 999))] (filter #(is-palindrome %) (map * (range 100 999) (repeat x)))))))
