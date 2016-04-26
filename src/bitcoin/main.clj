(ns bitcoin.main
  (:require [clojure.tools.cli :refer [cli]])
  (:require [bitcoin.miniwallet :refer [gen-miniwallet]])
  (:gen-class))

(defn gen-bip38 [] (println "Not implemented yet!"))

(defn -main [& args]
  (let [[opts args banner] (cli args
                                ["-h" "--help" "Print this help"
                                 :default false :flag true]
				["-e" "--bip38" "Create encrypted wallet (BIP38)"
                                 :default false :flag true])]
    (cond
      (:help opts)
      (do
        (println "Paper wallet generator. Give number of wallets to generate as an argument.\n")
        (println banner))
      (== (count args) 1)
      (doseq [x (range (bigint (first args)))] (if (:bip38 opts) (gen-bip38) (gen-miniwallet)))
      :else (println "Invalid arguments. See --help")
      )
    )
  )
