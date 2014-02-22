(use '[clojure.string :only (join split)])

(defn vertical[n, numbers] 
    ; returns the number vertically below this one
    ; n is index, returns the actual number
    (nth (nth numbers (inc (quot n 20)) nil) (mod n 20) nil))

(defn vertical-four[n, numbers]
    ; returns [n, n+20, n+40, n+60] as numbers 
    ; returns nil if index out of bounds
    (def a [(vertical (- n 20) numbers) (vertical n numbers) (vertical (+ 20 n) numbers) (vertical (+ 40 n) numbers)])
    (if (some nil? a) nil a))

(defn gather[start, n, coll]
    ; returns [start, start + 1, ..., start + n] on coll
    ; doesn't perform bounds checking so might throw outofbounds exception
    (reverse (nthnext (reverse (nthrest coll start)) (- (count coll) n start))))

(defn horizontal[n, numbers]
    ; returns the next three horizontal numbers to n and n itself
    ; returns nil otherwise
    (if (< (mod n 20) 17) (gather (mod n 20) 4 (nth numbers (quot n 20))) nil))

(defn diagonal-right [n, numbers]
    (def b [(nth (nth numbers (quot n 20) nil) (mod n 20) nil) 
            (nth (nth numbers (inc (quot n 20)) nil) (inc (mod n 20)) nil) 
            (nth (nth numbers (+ (quot n 20) 2) nil) (+ (mod n 20) 2) nil)
            (nth (nth numbers (+ (quot n 20) 3) nil) (+ (mod n 20) 3) nil) 
            ])
    (if (some nil? b) nil b))

(defn diagonal-left [n, numbers] 
    (def b [(nth (nth numbers (quot n 20) nil) (mod n 20) nil) 
            (nth (nth numbers (dec (quot n 20)) nil) (inc (mod n 20)) nil) 
            (nth (nth numbers (- (quot n 20) 2) nil) (+ (mod n 20) 2) nil)
            (nth (nth numbers (- (quot n 20) 3) nil) (+ (mod n 20) 3) nil) 
            ])
    (if (some nil? b) nil b))

(def numbers (partition 20 (map #(Integer. %) (split (slurp "grid.txt") #"\s"))))

(defn run [x] (apply max (map #(apply * %) (filter identity (map x (range 0 399) (repeat 399 numbers))))))

(time (max (run vertical-four) (run horizontal) (run diagonal-left) (run diagonal-right)))
