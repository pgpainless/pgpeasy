package org.pgpainless.pgpeasy.commands;

import org.pgpainless.pgpeasy.commands.cert.Certify;
import org.pgpainless.pgpeasy.commands.key.ExtractCert;
import picocli.CommandLine;

@CommandLine.Command(
        name = "cert",
        description = "Execute operations related to OpenPGP certificates",
        subcommands = {
                ExtractCert.class,
                Certify.class
        }
)
public class Cert implements Runnable {

    @Override
    public void run() {

    }
}
