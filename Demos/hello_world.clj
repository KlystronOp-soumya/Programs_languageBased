(ns clojure.examples.hello ;;namespace
    (:gen-class))
 (defn hello-world [] ;;function name
    (println "Hello World")
    (println "This is clojure")
    ) ;;funtion definition
 (hello-world) ;;calling the function