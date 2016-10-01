(defproject codecamp2016 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [amazonica "0.3.76"]
                 [metosin/compojure-api "1.1.8"]]
  :ring {:handler codecamp2016.handler/app}
  :uberjar-name "codecamp2016.jar"
  :profiles {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]]
                   :plugins [[ikitommi/lein-ring "0.9.8-FIX"]]}})
