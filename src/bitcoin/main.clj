(ns bitcoin.main
  (:require [clojure.tools.cli :refer [cli]])
  (:require [bitcoin.miniwallet :refer [gen-wallet gen-miniwallet]])
  (:gen-class))

(defn -main [& args]
  (let [[opts args banner] (cli args
                                ["-h" "--help" "Print this help"
                                 :default false :flag true]
				["-m" "--mini" "Create mini private keys"
                                 :default false :flag true])]
    (cond
      (:help opts)
      (do
        (println "Bitcoin paper wallet generator. Usage:\n")
        (println " walletgen N              Generates N wallets")
        (println " walletgen -m N           Generates N wallets with mini private key")
        (println banner))
      (== (count args) 1) (doseq [x (range (bigint (first args)))] (if (:mini opts) (gen-miniwallet) (gen-wallet)))
      :else (println "Invalid arguments. See --help")
      )
    )
  )
