(ns clojure-exercises.core-test
  (:require [clojure.test :refer :all]
            [clojure-exercises.core :refer :all]))

(deftest greatest-sum-test []
    (is (= (greatest-sum [1 2 3 4 5]) {"start" 0 "end" 4 "sum" 15}))
    (is (= (greatest-sum [-1 2 3 -4 5]) {"start" 1 "end" 4 "sum" 6}))
    (is (= (greatest-sum [-1 2 3 -4 5 4 -3 7 9 -4]) {"start" 1 "end" 8 "sum" 23})))

