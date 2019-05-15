<!-- -*- mode: markdown; coding: utf-8 -*- -->
# bitcoin-paper-wallet with bulk generation support

Generates standalone Bitcoin wallets without the need for a browser or
bitcoin wallet application. This tool supports
[mini private keys](https://en.bitcoin.it/wiki/Mini_private_key_format),
and ordinary bitcoin wallets in *dumpprivkey* format.

## Usage

The program will print out given number of private keys along with
their public keys and bitcoin addresses. The private keys are not
encrypted (unless you specify `-e`), so be careful with them.

### Running

#### Standard wallets

	./lein run -- 4

Will create 4 keypairs in *dumpprivkey* format. The output will
look like this:

```
L12M6hknHmXTJ35sDFLXWgUtjM7SsvvdHXp1wZ6hvnDHStAxHMEG 03d0dc7da415e9458b1c80c757bfff83ef35830651036df0f85fa98a5f1ac784ca 172Sdk4Y2G7qgraRBAjjtCAcW1rWX3s9X5
KykPgcLaRqaurFYsarbiYjWUWGhniWauYQ6EK42o1Pd755zAZ1Sy 02486d6137a5f8710b22fadb3eb3d553da89216c990b5464bfba162639ab496de5 13D2h6mJetbuRuzEf5qeEavJh4T9aJcSFB
Kx23GkzZR3kiMBykp3NveZQ412e664M19LH7TDE2jW3orMc7k4rJ 039da623defd53429d442e07a02c8de934c3e6600e9eb51b48f989fc203e905d0c 1PEn3U3c21GcD8Utd9sNRrRnyEkXj8WunG
L1duFDZcoTZb3RDqY4pT6Qhao77zfUFv7RY9AbDqXfdugEEXvyem 02d839200dac2a10cfa3745f566ae96f14e7950303a14e9792025e645b615ef987 1LNiB5t9s737KSQUH55zd4pnKAdNgNPrQs
```

#### Mini wallets

    ./lein run -- -m 5

This command will generate 5 keypairs in mini format.

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

You may want to do this on a computer that's never been connected to the Internet. For example, you could:

 * Boot a live CD/USB of Ubuntu, don't connect it to a network.
 * run `lein uberjar` on a trusted computer, copy the jar file to a pen drive and then to the Ubuntu box.
 * give executable flag to the .jar file: `chmod +x bitcoin-[version]-SNAPSHOT-standalone.jar`
 * just `./bitcoin-[version]-SNAPSHOT-standalone.jar` on the Ubuntu box.

## WARNING WARNING WARNING

 Be very careful when using this program. It uses the bitcoinj library for key generation
  so we are not responsible for any bugs that might generate insecure wallets. Use at your own risk.

## License

* Copyright © 2014 Diego Basch
* Copyright © 2015–2016 Prasos Ltd

  Distributed under the Eclipse Public License either version 1.0 or (at
      your option) any later version.
