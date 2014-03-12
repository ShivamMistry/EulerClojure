(defn collatz[n] 
     (if (even? n) (/ n 2) (+ 1 (* 3 n))))


(def collatz-seq (memoize (fn [start] 
    (if (= start 1) 
         1 
         (+ 1 (collatz-seq (collatz start)))))))

(def collatz-memo (memoize collatz-seq))


;(println (apply max-key (cons #(first %) (map #([(collatz-seq %) %]) (range 1 1000000)))))
(println (first (sort-by collatz-memo > (range 1 1000000))))
