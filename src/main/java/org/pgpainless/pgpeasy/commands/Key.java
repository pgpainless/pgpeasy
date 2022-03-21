package org.pgpainless.pgpeasy.commands;

import org.pgpainless.pgpeasy.commands.key.ExtractCert;
import org.pgpainless.pgpeasy.commands.key.Generate;
import picocli.CommandLine;

@CommandLine.Command(
        name = "key",
        description = "Operations related to secret keys",
        subcommands = {
                ExtractCert.class,
                Generate.class,
        }
)
public class Key implements Runnable {

    @Override
    public void run() {

    }
}
