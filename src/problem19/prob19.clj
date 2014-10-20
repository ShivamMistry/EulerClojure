; Find the number of 1st of months starting on Sunday since 1st Jan 1901 to 31st Dec 1999
; 1st Jan 1900 was a Monday

(defn is-leap? [year]
    (if (zero? (mod year 4))
        (if (zero? (mod year 100)) ; check for century
            (zero? (mod year 400)) ; check century divisible by 400
            true
        )
    )
)

; The date vector is formatted as [day month year]
; If [1 1 1900] is a monday, [7 1 1900] is a sunday
(def first-sunday [7 1 1900])

(def start [1 1 1901])

(defn year [v] (nth v 2))

(defn day [v] (nth v 0))

(defn month-length [mon year]
    (case mon
        1 31    2 (if (is-leap? year) 29 28)
        3 31    4 30
        5 31    6 30
        7 31    8 31
        9 30    10 31
        11 30   12 31
    )
)

(defn next-month [month]
    (inc (mod  month 12))
)

(defn next-day [day month year]
    (def ans (vec (repeat 3 nil)))
    (let [length (month-length month year)]
        (if (> (+ day 1) length)
            (def ans (assoc ans 0 1))   
            (def ans (assoc ans 0 (+ day 1)))     
        )
    )
    (def ans (assoc ans 1 (if (= (nth ans 0) 1) (next-month month) month))) ; increment month if necessary
    (def ans (assoc ans 2 (if (and (= month 12) (= (nth ans 1) 1)) (inc year) year))) ; increment year if necessary
    (identity ans)
)

(defn nextday
    ([day month year] (next-day day month year))
    ([v] (apply next-day v))
)

(defn day-seq
    ([] (day-seq start))
    ([v] (cons v (lazy-seq (day-seq (nextday v)))))
)

(defn next-sunday [sunday]
    ; sunday should be a date in a vec
    (last (take 8 (day-seq  sunday)))
)

(defn sunday-seq
    ([] (sunday-seq first-sunday))
    ([v] (cons v (lazy-seq (sunday-seq (next-sunday v)))))
)



(let [last-of-year (last (take-while #(< (year %) 1901) (sunday-seq)))]
    (println (count (filter #(= (day %) 1) (take-while #(< (year %) 2001) (sunday-seq (next-sunday last-of-year))))))
)
