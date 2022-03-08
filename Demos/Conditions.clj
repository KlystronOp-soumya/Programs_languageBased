 (ns clojure.demo
   (:gen-class))

;;(defn ifDemo []
;;  (
;;   (def x 1)
;;   (def y 1)

;;   if(= 2 2) ;;the expression will nmot work here
;;   (println "True")
;;   (println "False") ;;this is the else statement
;;   ))

;;(ifDemo)

(defn ifDoDemo []
  (def x  2)
   (def y 2)
   (def check (= x y))

   (if check
    (do
      (println "X: "x" Y:"y)
      (inc x)
      (inc y)
      (println "X: " x " Y:"y)
      )
    (do
      (println "Not Eq X: " x " Y:" y)
      (def x (dec x))
      (def y (dec y))
      (println "X: "x " Y:" y)
      ))
  )

(ifDoDemo)