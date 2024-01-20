(ns tech-train-iris-xgboost.core-test
  #_(:require [clojure.test :refer :all]
            [tech-train-iris-xgboost.core :refer :all]
            [tech.v3.dataset :as ds]
            [tech.v3.dataset.categorical :as ds-cat]
            [tech.v3.dataset.column-filters :as cf]
            [tech.v3.dataset.modelling :as ds-mod]
            [tech.v3.libs.xgboost]
            [tech.v3.ml :as ml]))

;;; blatantly stolen from https://github.com/techascent/tech.ml
;
;
;;; note that I also copied this file into the resources directory ;)
;(def ds (ds/->dataset "https://raw.githubusercontent.com/techascent/tech.ml/master/test/data/iris.csv"))
;
;(deftest a-test
;  (is (= 5 (count (ds/head ds)))))
;
;;;; print only the numerical fields in the data set
;(prn :numeric (ds/head (cf/numeric ds)))
;
;;;; print only the categorical fields in the data set
;(prn :categorical (ds/head (cf/categorical ds)))
;
;;;; convert the categorical fields to numeric for regression
;(def numeric-ds (ds/categorical->number ds cf/categorical))
;
;(deftest meta-test
;  (is (= {:categorical? true
;          :name "species"
;          :datatype :float64
;          :n-elems 150
;          :categorical-map
;          {:lookup-table {"versicolor" 2 "setosa" 0 "virginica" 1}
;           :src-column "species"
;           :result-datatype :float64}}
;         (-> (meta (numeric-ds "species"))
;             (update :categorical-map #(into {} %))))))
;
;(def regression-ds (ds-mod/set-inference-target numeric-ds "petal_width"))
;
;(def model (ml/train-split regression-ds {:model-type :xgboost/regression}))
;
;(deftest loss-test
;  (prn :loss (:loss model))
;  (is (< 0.0 (:loss model) 1.0)))
;
;(try
;  (def k-fold-model (ml/train-k-fold regression-ds {:model-type :xgboost/regression}))
;
;  ;;; WTF!
;  ;;; => java.lang.ClassCastException: class java.lang.Double cannot be cast to class clojure.lang.IFn
;  (catch Exception e (.printStackTrace e)))
;
;
;#_(select-keys k-fold-model [:min-loss :avg-loss :max-loss])
;
;#_(def predictions (ml/predict numeric-ds k-fold-model))
;
;#_(prn :predictions
;     (-> predictions
;         ds-cat/reverse-map-categorical-xforms
;         ds/head))