(defproject bitcoin "0.1.0-SNAPSHOT"
  :description "offline paper wallet generator"
  :url "http://diegobasch.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repositories {"bitcoinj" "http://distribution.bitcoinj.googlecode.com/git/releases/"}
  :dependencies [[org.bitcoinj/bitcoinj-core "0.12.3"]
                 [org.slf4j/slf4j-simple "1.7.5"]
                 [org.clojure/clojure "1.5.1"]
                 [pandect "0.5.2"]]
  :main bitcoin.miniwallet)
