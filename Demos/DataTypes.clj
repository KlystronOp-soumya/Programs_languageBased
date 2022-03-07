;;This class demonstrates the different data types
(ns clojure.examples.hello
    (:gen-class))
(defn example []

    ;;defines the variable
  (def x 1)
  (def y 2)
  (def greet "Hello World")
  (def status true)
  ;;(def m Nil) ;;The Nil is equivalent to NULL
  (def n (atom 1))
  (def z (not= x y))
  (println x)
  (println y)
  (println greet)
  (println status)
  (println z)
  ;;(println m)
  (println n)
  )
 

(example)