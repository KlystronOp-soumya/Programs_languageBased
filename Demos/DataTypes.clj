;;This class demonstrates the different data types
(ns clojure.examples.hello
    (:gen-class))
(defn example []

    ;;defines the variable
  (def x 1)
  (def y 2)
  (def greet "Hello World")
  (def status true)
  (println x)
  (println y)
  (println greet)
  (println status)
  )

(example)