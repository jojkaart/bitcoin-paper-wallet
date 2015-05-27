# bitcoin-paper-wallet

Generate Bitcoin wallets with mini private keys, without the need for a browser.

## Usage

The program will print out a number of mini private keys along with their public bitcoin addresses
The private keys are not encrypted, so be careful with them.

### Example

`lein run 5`

This command will generate 5 keypairs. The output will look like this:

<pre>
17DEuNqrYHKGzrJX174RtKmTcSh1KgsREy S3CXvnqjNdjfBjG7LUF8cLehU6mDZC
12GTyB5g5zhw6M8TaVAx4u7xLuHYqEkPYn SCwPgpCMUL7y84R2V5odGCVBpJWjbw
1636MEbWnopM2XjCczJPsAgKuQwR6YmfEr S9j4HVvfknnEKLKGbbYQCZ5dysQCtf
1HnHnfDWDXcsSxHp3kEw3MmNNsBB4dQUZJ Sa7y5u5iQxgejhoHh6uXs1ac1umjvi
1ERwg9n1X6VoSgJ84K9D6EZZVE5ecrngTR SyY5HGopq8QKMX3EXk7YB9cdi2pP43
</pre>

 You may want to do this on a computer that's never been connected to the internet. For example, you could:

 * Boot a live CD/USB of Ubuntu, don't connect it to a network.
 * run `lein uberjar` on a trusted computer, copy the jar file to a pen drive and then to the Ubuntu box.
 * run `java -jar bitcoin-[version]-SNAPSHOT-standalone.jar` on the Ubuntu box.

## WARNING WARNING WARNING 

 Be very careful when using this program. It uses the bitcoinj library for key generation
  so I'm not responsible for any bugs that might generate insecure wallets. Use at your own risk.

## License

  Copyright © 2014 Diego Basch
  Copyright © 2015 Joel Kaartinen

  Distributed under the Eclipse Public License either version 1.0 or (at
      your option) any later version.
