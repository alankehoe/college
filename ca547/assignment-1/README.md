To use this executable jar file you will need to read the following instructions.

## Encrypting a file
in order to encrypt a file you will need to execute the following command

java -jar assignment-1.jar <password> <filename>

here is a sample of the output:

```bash
$ java -jar assignment-1.jar ComputingDublin2013 Crypto.java
Encrypting file: Crypto.java

Using password: ComputingDublin2013
Encrypted password: 3d5e64e68f80e29983f9532c902390d6a807507c21117eac409b4da5960c1b92fac3ce1829a1de87c699a5fabffe517626c77100ff9d58c363353cdbb1b8336db63c924027ee022a23f3ffa3cf84c3ca9964b691c6045d39c2d69b85c82130d804b733b19960252397e42dad5793c0a0e5f951e0ecc76f10c3e0b2f8ef69cf8c

Using 128 bit salt : 6c5a938ba464035f18d070673e99ca84
Using 128 bit IV : ba34da2845e6fa6ba24abccc7e337fac

Success
```

This will result in the file being encrypted.. take note of the following variables as you will need them to decrypt the file.
N.B) Password & IV

## Decrypting a file
to decrypt a file you will need to execute the following command

java -jar assignment-1.jar <password> <salt> <iv> <filename>

here is a sample of the output:

```bash
$ java -jar assignment-1.jar ComputingDublin2013 6c5a938ba464035f18d070673e99ca84 ba34da2845e6fa6ba24abccc7e337fac Crypto.java

Decrypting file: Crypto.java
Using password: ComputingDublin2013
Using 128 bit Salt : 6c5a938ba464035f18d070673e99ca84
Using 128 bit IV : ba34da2845e6fa6ba24abccc7e337fac
Using 256 bit AES KEY: c0ae1e92cfbe308ed9904fcefcbf36110572e54ff34f752c7d33985929bad2ea

Success
```

The encrypted file should now be back to its original state.
N.B) If the password, salt or iv are different from the ones used to encrypt the document
the decryption algorithm will fail. I considered outputting these variables to a file so they will be stored but that would be messy and insecure.

## Got an error
if you don't supply the correct amount of arguments to the program it will display a usage guide so
you can correct your execution.

That will look like:

```bash
$ java -jar assignment-1.jar
Usage : java -jar assignment-1.jar <password> <filename>
Usage : java -jar assignment-1.jar <password> <salt> <iv> <filename>
```
