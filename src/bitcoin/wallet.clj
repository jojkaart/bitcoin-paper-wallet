(ns bitcoin.wallet
  (:gen-class :main true)
  (:import java.awt.image.BufferedImage
           [java.awt Font Color]
           com.google.zxing.qrcode.QRCodeWriter
           com.google.zxing.common.BitMatrix
           com.google.zxing.BarcodeFormat
           com.google.zxing.client.j2se.MatrixToImageWriter
           com.fruitcat.bitcoin.BIP38
           [com.google.bitcoin.core Address ECKey NetworkParameters DumpedPrivateKey])
  (:require [clojure.string :as str]
            [pandect.algo.sha256 :refer :all]))

;; generate qr code as an image
(defn qr [s]
  (let [writer (QRCodeWriter.)
        matrix (.encode writer s BarcodeFormat/QR_CODE 300 300)]
    (MatrixToImageWriter/toBufferedImage matrix)))

(defn address [k]
  (Address. (NetworkParameters/prodNet) (.getPubKeyHash k)))

(defn gen-image [qr-key qr-add key-str add-str]
  ;; I'm no artist, I just draw everything with absolute coordinates
  ;; in a way that looks ok for me.
  (let [img (BufferedImage. 800 350 BufferedImage/TYPE_INT_RGB)
        g (.getGraphics img)]
    (.setPaint g (Color/WHITE))
    (.fillRect g 0 0 800 350)
    (.drawImage g qr-add 0 20 nil)
    (.drawImage g qr-key 500 20 nil)
    (.setPaint g (Color/BLACK))
    (.setFont g (Font. "Courier" Font/PLAIN 14))
    (.drawString g "Bitcoin Address" 35 30)
    (if (= \5 (first key-str))
      (do
        (.drawString g "Private Key (Wallet Import Format)" 400 30)
        (.drawString g key-str 360 320))
      (do
        (.drawString g "Private Key (Encrypted Format)" 420 30)
        (.drawString g key-str 320 320)))
    (.drawString g add-str 35 320)
    (.setPaint g (Color/GREEN))
    (.setFont g (Font. "Courier" Font/BOLD 20))
    (.drawString g "SHARE" 210 30)
    (.setPaint g (Color/RED))
    (.drawString g "SECRET" 695 30)
    (javax.imageio.ImageIO/write img "png" (java.io.File. "wallet.png"))))

(defn gen-key []
  ;; hack to get the key uncompressed, because bitcoinj makes it compressed by default.
  (.getPrivateKeyEncoded (ECKey. (.getPrivKeyBytes (ECKey.)) nil) (NetworkParameters/prodNet)))

(defn minikey-candidate []
  (let [key-str (.toString (gen-key))]
    (str "S" (subs key-str 2 31)))

(defn minikey-validate [key-str]
  (.startsWith (digest/sha256 (str key-str "?")) "00"))

(defn gen-minikey []
  (loop [testkey (minikey-candidate)]
    (if (minikey-validate testkey)
         testkey
      (recur (minikey-candidate))))

(defn gen-wallet [passphrase]
  
  (let [key-str (if passphrase
                  (com.fruitcat.bitcoin.BIP38/generateEncryptedKey passphrase)
                  (.toString (gen-key)))
        plain-key (if passphrase
                    (com.fruitcat.bitcoin.BIP38/decrypt passphrase key-str)
                    key-str)
        k (.getKey (DumpedPrivateKey. (NetworkParameters/prodNet) plain-key))
        add-str (.toString (address k))
        qr-key (qr key-str)
        qr-add (qr add-str)]
    (println add-str key-str passphrase)))

(defn -main [& args]
  (doseq [x args] (gen-wallet x)))
