<!--
SPDX-FileCopyrightText: 2022 Paul Schaub <vanitasvitae@fsfe.org>

SPDX-License-Identifier: Apache-2.0
-->
# PGPeasy Lemon Squeezy!

PGPeasy is intended to become your next OpenPGP multi-tool.
It provides an easy interface for all sorts of operations, such as generating and discovering keys, encrypting and decrypting messages, managing certificates...

Contrary to `pgpainless-cli`, this application is not limited to the SOP specification, so it is possible to extend it with additional behavior and more powerful features.

A good example for a feature that will get added at some point is support for password protected keys.

```shell
$ pgpeasy help
Usage: pgpeasy [COMMAND]
Commands:
  encrypt                   Encrypt a message from standard input
  decrypt                   Decrypt a message from standard input
  sign                      Create a detached signature on the data
                              from standard input
  verify                    Verify a detached signature over the
                              data from standard input
  armor                     Add ASCII Armor to standard input
  dearmor                   Remove ASCII Armor from standard input
  extract-cert              Extract a public key certificate from a
                              secret key from standard input
  generate-key              Generate a secret key
  sop                       Stateless OpenPGP Protocol
  wkd                       Interact with the Web Key Directory
  vks                       Interact with Verifying Key Servers
  certificate-store         Store and manage public OpenPGP
                              certificates
  wot                       Interact with the Web of Trust
  help                      Displays help information about the
                              specified command

```

## Building Instructions

Clone the repository and execute `gradle build` in the project directory.
Afterwards you can find archives containing the application in the `build/distributions/` directory.
Once extracted, you can execute the `pgpeasy` script in the `bin` subdirectory.

