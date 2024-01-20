(defproject tech-train-iris-xgboost "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :test-refresh {:quiet true}
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :plugins [[com.jakemccrary/lein-test-refresh "0.24.1"]]
  :dependencies [[org.clojure/clojure "1.11.1"]

                 ;;; these are for the old library stuff where the example throws
                 ;;; the ClassCastException :/
                 ;[techascent/tech.ml.dataset "7.022"]
                 ;[techascent/tech.ml "6.019"]
                 ;[com.github.haifengl/smile-core "3.0.2"]

                 ;;; this is the new thing!
                 [scicloj/scicloj.ml "0.3"]]
  :aliases {"co" ["test-refresh" ":changes-only"]}
  :repl-options {:init-ns tech-train-iris-xgboost.core})
