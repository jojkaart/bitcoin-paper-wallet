(defproject bitcoin "0.1.1-SNAPSHOT"
  :description "offline paper wallet generator"
  :url "http://diegobasch.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.bitcoinj/bitcoinj-core "0.15.2"]
                 [org.clojure/tools.cli "0.4.2"]
                 [org.slf4j/slf4j-simple "1.7.26"]
                 [org.clojure/clojure "1.10.0"]
                 [pandect "0.5.4"]]
  :main bitcoin.main)
