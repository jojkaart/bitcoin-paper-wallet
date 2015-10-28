# bitcoin-paper-wallet (Mini key version)

Generate Bitcoin wallets with
[mini private keys](https://en.bitcoin.it/wiki/Mini_private_key_format),
without the need for a browser.

## Usage

The program will print out given number of mini private keys along
with their public keys and bitcoin addresses. The private keys are not
encrypted, so be careful with them.

### Running

    ./lein run 5

This command will generate 5 keypairs. The output will look like this:

```
Sv7gQpP9UTUiStpTqmMKAnGUwYYmuL 044f6b6c83596895c1e06f12aa9658202ed44fbade7ab5ffa20b11c6f6a5e7d6c8a63006c33394ffb1733e1a2e677c4cdd2a9d8def18e70e95d7da1db9b4204763 1Muiu5JMJZyew3vLGz7pYu2PEdgGyjUgpp
StEq659PunPXrcyxZmYdL589LakZ9h 04bbcf54326aebd652f51d8b4ffaf0f44b23bf73ff4523e3e36039eb92032e3876cc6861b9cc11cfa9ca78f5ee4a9cf75e5961ffb8d038af0d0f411125faf3cbd6 1CQRR2DUDVHpAN2iY1osBqNYhCmTNVzGr
S7t3gjPehfbetCzPN4k6GGJW1rQtBE 04b425b57d6b8838cb9a05d5b049c03ddb35ff22871efe56037a79afc7279bddba0a8ca2432cc61e12a5547072bb0ef523e29a22bd8b21dc714c5706e83b2e32d0 1ECFCRACSAR58ytYssRQ92nu2AjhbUJx2N
SUuodsAETRS7dssAcifY5P3W1NnjG5 04167d4bddece86219b7b8e485e0dfbb1466650b54912ebec2abc8cf70ff4fc6736630bc3065e6837b714b091dcc25cfc4ab5fb9826368e4d38526e7662d7f8768 12FiQhbjMeUYX32iVyqi3GaWrLX5wSPbwM
SGCft5991PZzTNR4P118dWGcZvCMZx 040c36630e9504849c34c1974a81147adbf88f736282830441d3c4e92edbdf06c92fc45fedd872ddc77ac84fd67f410250f21ade23c955d073d7fefdc50af56457 1ASCaLv2hRbhqtg1sXWizRUxHUXDy24Ncz
```

### Compiling

To compile JAR package, run

    ./lein uberjar

 You may want to do this on a computer that's never been connected to the internet. For example, you could:

 * Boot a live CD/USB of Ubuntu, don't connect it to a network.
 * run `lein uberjar` on a trusted computer, copy the jar file to a pen drive and then to the Ubuntu box.
 * run `java -jar bitcoin-[version]-SNAPSHOT-standalone.jar` on the Ubuntu box.

## WARNING WARNING WARNING 

 Be very careful when using this program. It uses the bitcoinj library for key generation
  so we are not responsible for any bugs that might generate insecure wallets. Use at your own risk.

## License

* Copyright © 2014 Diego Basch
* Copyright © 2015 Prasos Ltd

  Distributed under the Eclipse Public License either version 1.0 or (at
      your option) any later version.
