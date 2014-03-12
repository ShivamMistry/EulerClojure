(println (subs (str (reduce + (map #(read-string (apply str %)) (partition 50 (filter #(Character/isDigit %) (slurp "data.txt")))))) 0 10))
