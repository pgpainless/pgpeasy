package org.pgpainless.pgpeasy.commands.key;

import picocli.CommandLine;

@CommandLine.Command(
        name = "extract",
        description = "Extract a certificate from a secret key"
)
public class ExtractCert implements Runnable {

    @Override
    public void run() {

    }
}
