 (ns clojure.demo
   (:gen-class))

(defn nestedIf []
  
   (def x (atom 1))
   (def y (atom 2))

   (def check (= x y))
   ;;(println "Check: " check)
  (if check
     (if (< 1 2)
      (println "x is less than y")
      (println "y is greater than x"))
   (println "x and y not eq"))
  )
(nestedIf)