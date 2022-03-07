(ns clojure.examples.hello
  (:gen-class))

;; This program displays Hello World
(defn Example []
  (def x  (atom 1))
  (while (< @x 5)
    (do
      (println @x)
      (swap! x inc)))) ;; this is like the assignment operator x =x + 1
(Example)