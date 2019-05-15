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

Will create 4 keypairs in *dumpprivkey* format. Columns are: private
key, public key, bitcoin address. The output looks like this:

```
L12M6hknHmXTJ35sDFLXWgUtjM7SsvvdHXp1wZ6hvnDHStAxHMEG 03d0dc7da415e9458b1c80c757bfff83ef35830651036df0f85fa98a5f1ac784ca 172Sdk4Y2G7qgraRBAjjtCAcW1rWX3s9X5
KykPgcLaRqaurFYsarbiYjWUWGhniWauYQ6EK42o1Pd755zAZ1Sy 02486d6137a5f8710b22fadb3eb3d553da89216c990b5464bfba162639ab496de5 13D2h6mJetbuRuzEf5qeEavJh4T9aJcSFB
Kx23GkzZR3kiMBykp3NveZQ412e664M19LH7TDE2jW3orMc7k4rJ 039da623defd53429d442e07a02c8de934c3e6600e9eb51b48f989fc203e905d0c 1PEn3U3c21GcD8Utd9sNRrRnyEkXj8WunG
L1duFDZcoTZb3RDqY4pT6Qhao77zfUFv7RY9AbDqXfdugEEXvyem 02d839200dac2a10cfa3745f566ae96f14e7950303a14e9792025e645b615ef987 1LNiB5t9s737KSQUH55zd4pnKAdNgNPrQs
```

#### Mini wallets

    ./lein run -- -m 5

This command will generate 5 keypairs in mini format. Columns are:
Mini private key, public key, bitcoin address, uncompressed private
key.

```
SE4u6E4o7EeGtLqg8KFwzHkh8gqxA3 04eb5de1b2499395f1c20a8b15999278bede8456e32ec299bbad58becef7ff28ae3e452b7ad8fb3f64350d236156871227f7c1c2393a41fe36d5da8f8f859d4412 1Gj77XugXEaoTjYfsceMtfPxVhPdgU3rDR 5Kfjx5gTSjvBRqCoWHbiCFbSV1kwhV6vo446ELQbr1pay6Uskiu
SXhBiV3VVKQS5hrV9wpLUGJYhaECNd 04a0b40b6ee10e36965ae8542c1247f08a3ecad279910acaaf590b93483a755970bedad23ba6ab6a8e2804a1b1109698fb1bc9c9dfa2abe4000a69baf71f817ce2 1LLMymhismjfKfvaPT9vMoVHcpvTASbP4p 5J7L7YKNfNY2Ddae4haqdfmdQU6XRJSzVuYWphf6AbnUCS6v94p
SjBnnujGV8K5s3PdeGZPvjA17o1qGV 0485fd3c28892b23a65371c5b3d6942ad2b078f4e01f5ecc96bb6e7389c2f91198be636873919cf77a20ef278b500b28bc9bd4d0a3401e67a8efe109c19e784e8d 1PrWinNz5xySABu8jiCk5CFEv6HFAFbFHN 5JuevzenBHyRGJdYiv7WD58YvAqMm9phFyzRRrifGcWGKrJsXxR
SUjsg21YZ4mRjucTWNGGqoqmNXNfnz 0447a75840b2fcca3d32ee7e013896d5e94ebab6bdc721014762c79b38cdbfbc530bf50e857e3826771d801e8aac1a375fbb6f81398c9c29100c8caba2063b045c 13qLU1ZKb2tpebJeFMufJE6CgriKN1nSyh 5Hz7UF8Qhfsn8PHSb6LEMB9Wp3VUr9zkUW8SixRro3dDag7dj5s
SrrGBxRDvVeSNotLv6qL9Th1mJ3pn4 04c78d74b2200b2940778600b7a535fcee90a0ff83fa85e03d19b9087fe237ca2bc8cc9e016ac9bb90a4bbb31ceae5673b03511286ed6a35af188b0d9a3464c196 13M9EWAchopNcWCijQhKbAQGwLapHf8jzt 5JJ2atjKRB2kXjZGmzzZxow1KqK9ThX3fy6J8p1j9GQBTERbjgx
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
* Copyright © 2015–2019 Prasos Oy

  Distributed under the Eclipse Public License either version 1.0 or (at
      your option) any later version.
