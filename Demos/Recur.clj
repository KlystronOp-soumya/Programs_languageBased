;;loop [binding]
;;(condition
 ;;(statement)
 ;;(recur (binding)))

(ns clojure.examples.hello
   (:gen-class))

;; This program displays Hello World
(defn Example []
   (loop [x 10]
      (when (> x 1)
         (println x)
         (recur (- x 2))))) ;;for(int i = 10;i>=1 ;i-=2)
(Example)

((defn Example_2 []
  
   (loop [x 1]
     (when (< x 10)
       (println x)
       (recur (+ x 1) ;;for(int i = 0;i<10 ;i++)
              )
       )
     )
   
   ))
(Example_2)