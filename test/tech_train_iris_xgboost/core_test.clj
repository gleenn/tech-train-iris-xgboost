(ns tech-train-iris-xgboost.core-test
  (:require [clojure.test :refer :all]
            [tech-train-iris-xgboost.core :refer :all]
            [tech.v3.dataset :as ds]
            [tech.v3.dataset.column-filters :as cf]
            [tech.v3.dataset.modelling :as ds-mod]))


(def ds (ds/->dataset "https://raw.githubusercontent.com/techascent/tech.ml/master/test/data/iris.csv"))

(deftest a-test
  (is (= 5 (count (ds/head ds)))))

;;; print only the numerical fields in the data set
(prn :numeric (ds/head (cf/numeric ds)))

;;; print only the categorical fields in the data set
(prn :categorical (ds/head (cf/categorical ds)))

;;; convert the categorical fields to numeric for regression
(def numeric-ds (ds/categorical->number ds cf/categorical))

