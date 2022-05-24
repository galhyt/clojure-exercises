(ns clojure-exercises.core
  (:gen-class))

(defn greatest-sum
  ([arr]
   (greatest-sum arr nil (apply + arr) 0 (dec (count arr))))
  ([arr greatest-obj arr-sum start end]
   (let [arr-obj {"start" start "end" end "sum" arr-sum}
         new-greatest-obj (if (nil? greatest-obj)
                            arr-obj
                            (max-key #(% "sum") arr-obj greatest-obj))]
    (if (= (count arr) 1)
      new-greatest-obj
      (apply max-key #(% "sum") [(greatest-sum (rest arr) new-greatest-obj (- arr-sum (first arr)) (inc start) end)
                                 (greatest-sum (drop-last arr) new-greatest-obj (- arr-sum (last arr)) start (dec end))])))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
