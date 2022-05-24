(ns clojure-exercises.core-test
  (:require [clojure.test :refer :all]
            [clojure-exercises.core :refer :all]))

(deftest greatest-sum-test []
    (is (= (greatest-sum [1 2 3 4 5]) {"start" 0 "end" 4 "sum" 15})))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))
