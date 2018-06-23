(ns calculadora.core
  (:require [clojure.pprint :refer :all]
            [clojure.string :as str]
)
  (:gen-class))

(defn abs [x]
  (if (> x 0) x (- x)))

(defn formata-hora [minutos]
  (let [horas (quot minutos 60)
        minutos-restantes (-> minutos (- (-> 60 (* horas))))]
    (if (-> horas (not= 0))
        (str horas "h" (abs minutos-restantes) "m ou " minutos "m")
        (str minutos-restantes "min"))))

(def operacoes {:+ + :- -})

(defn le-operacao [op]
  ((keyword op) operacoes))

(defn le-hora [p]
  (let [horas (cond 
               (str/includes? p "h") (first (str/split p #"h"))
               :else "0") 
        minutos (cond 
                 (and (str/includes? p "m") (str/includes? p "h")) (first (str/split (second (str/split p #"h")) #"m")) 
                 (str/includes? p "m")  (first (str/split p #"m")) 
                 (and (not (str/includes? p "m")) (str/includes? p "h")) (second (str/split p #"h")) 
                 (and (not (str/includes? p "m")) (not (str/includes? p "h"))) p
                 :else "0")] 
    (+
     (* 60 (read-string horas))
     (if minutos 
       (read-string minutos) 
       0))))

(defn calcula "Obrigatorio ser no formato 3h23m, ou seja, com h e m"
[args] 
(let [p1 (le-hora (nth args 0))
        op (le-operacao (nth args 1))
        p2 (le-hora (nth args 2))]
    (pprint (formata-hora (op p1 p2)))))

(defn -main [& args]
  (calcula args))
