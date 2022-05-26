(ns clojure-exercises.core
  (:gen-class))

(defn get-greatest-of-first-index [arr i]
  (let [sum (arr i)
        greatest-sub-reduced (reduce #(let [sum (first %1)
                                            greatest-j (second %1)
                                            greatest-sum (last %1)
                                            j %2
                                            new-sum (+ sum (arr j))]
                                        (if (> new-sum greatest-sum)
                                          [new-sum j new-sum]
                                          [new-sum greatest-j greatest-sum]))
                                     [sum i sum] (range (inc i) (count arr)))
        greatest-j (second greatest-sub-reduced)
        greatest-sum (last greatest-sub-reduced)]
    {"start" i "end" greatest-j "sum" greatest-sum}))

(defn get-greatest-sub-sum
  ([arr]
   (let [greatest-sub (get-greatest-of-first-index arr 0)]
     (reduce #(let [greatest-sub %1
                    i %2
                    new-sub (get-greatest-of-first-index arr i)]
                (max-key (fn [sub] (sub "sum")) greatest-sub new-sub))
             greatest-sub
             (range 1 (count arr))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;(let [arr [-24 29 19 -26 25]]
  ;  (println
  ;    (for [i (range 1)]
  ;      (str "i=" i " greatest-sub=" (get-greatest-of-first-index arr i) "\n"))))
  (let [arr (into [] (for [i (range 1000) :let [r (* (if (= (rand-int 2) 1) -1 1) (rand-int 50))]] r))
        greatest-obj (get-greatest-sub-sum arr)]
    (println (str "arr=" arr))
    (println greatest-obj)))
