(ns clojure-exercises.core
  (:gen-class))

(defn greatest-sum
  ([arr]
   (greatest-sum arr {"start" 0 "end" (dec (count arr)) "sum" (apply + arr)} 0 (dec (count arr))))
  ([arr greatest-obj start end]
   (if (= (count arr) 1)
     (apply max-key #(% "sum") [{"start" start "end" end "sum" (first arr)} greatest-obj])
     (let [new-greatest-obj (max-key #(% "sum") {"start" start "end" end "sum" (apply + arr)} greatest-obj)]
           (apply max-key #(% "sum") [(greatest-sum (rest arr) new-greatest-obj (inc start) end)
                                      (greatest-sum (drop-last arr) new-greatest-obj start (dec end))])))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
