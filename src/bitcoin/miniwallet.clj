(ns bitcoin.miniwallet
  (:gen-class :main true)
  (:import java.math.BigInteger
           [org.bitcoinj.core Address ECKey NetworkParameters DumpedPrivateKey])
  (:require [clojure.string :as str]
            [pandect.algo.sha256 :refer :all]))

(defn address [k]
  (Address. (NetworkParameters/prodNet) (.getPubKeyHash k)))

(defn gen-key []
  ;; hack to get the key uncompressed, because bitcoinj makes it compressed by default.
  (.getPrivateKeyEncoded (ECKey. (.getPrivKeyBytes (ECKey.)) nil) (NetworkParameters/prodNet)))

(defn minikey-candidate []
  (let [key-str (.toString (gen-key))]
    (str "S" (subs key-str 2 31))))

(defn minikey-validate [key-str]
  (.startsWith (sha256 (str key-str "?")) "00"))

(defn gen-minikey []
  (loop [testkey (minikey-candidate)]
    (if (minikey-validate testkey)
         testkey
      (recur (minikey-candidate)))))

(defn minikey-to-address [minikey]
  (.toString (address (ECKey/fromPrivate (BigInteger. (sha256 minikey) 16) false))))

(defn gen-miniwallet []
  (let [key-str (gen-minikey)
        add-str (minikey-to-address key-str)]
    (println add-str key-str)))

(defn -main [& args]
  (doseq [x (range (bigint (first args)))] (gen-miniwallet)))
