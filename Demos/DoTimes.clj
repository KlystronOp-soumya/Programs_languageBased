(ns clojure.examples.hello
  (:gen-class))

;; This program displays Hello World
(defn Example []
  (dotimes [n 5]
    (println n))) ;; for n times for(i=1;i<=5;++i) 5 times
(Example)