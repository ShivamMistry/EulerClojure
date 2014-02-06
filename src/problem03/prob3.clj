(def is_factor (fn[x,n] (zero? (mod x n))))

(defn prime-factor [n, x]
	(if (= n x) n
		(if (is_factor n  x)
			(prime-factor (/ n x) x)
			(prime-factor n (inc x)))))

(println (prime-factor 600851475143 3))
