;;DoSeq is like the forEach statement
(ns clojure.examples.hello
  (:gen-class))

;; This program displays Hello World
(defn Example []
  (doseq [n [0 1 2]] ;; [0 1 2] like the array for n in [0,1,2]
    (println n)))
(Example)