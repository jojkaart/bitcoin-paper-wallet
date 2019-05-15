(ns bitcoin.miniwallet
  (:gen-class :main true)
  (:import java.math.BigInteger
           [org.bitcoinj.core Address ECKey NetworkParameters DumpedPrivateKey])
  (:require [clojure.string :as str]
            [pandect.algo.sha256 :refer :all]))

(defn private-to-address [k]
  (.toString (Address. (NetworkParameters/prodNet) (.getPubKeyHash k))))

(defn gen-uncompressed-key []
  ;; hack to get the key uncompressed, because bitcoinj makes it compressed by default.
  (.getPrivateKeyEncoded (ECKey. (.getPrivKeyBytes (ECKey.)) nil) (NetworkParameters/prodNet)))

(defn minikey-candidate []
  (let [key-str (.toString (gen-uncompressed-key))]
    (str "S" (subs key-str 2 31))))

(defn minikey-validate [key-str]
  (.startsWith (sha256 (str key-str "?")) "00"))

(defn gen-minikey []
  (loop [testkey (minikey-candidate)]
    (if (minikey-validate testkey)
         testkey
      (recur (minikey-candidate)))))

(defn minikey-to-private [minikey]
  (ECKey/fromPrivate (BigInteger. (sha256 minikey) 16) false))

;; Format given ECKey to "dumpprivkey" format
(defn key-to-str [key] (.toString (.getPrivateKeyEncoded key (NetworkParameters/prodNet))))

;; Ordinary bitcoin wallet with compressed public key
(defn gen-wallet []
  (let [key (ECKey.)]
    (println (key-to-str key) (.getPublicKeyAsHex key) (private-to-address key))))

;; Bitcoin wallet with mini private key (https://en.bitcoin.it/wiki/Mini_private_key_format)
(defn gen-miniwallet []
  (let [key-str (gen-minikey)
        key (minikey-to-private key-str)]
    (println key-str (.getPublicKeyAsHex key) (private-to-address key))))
