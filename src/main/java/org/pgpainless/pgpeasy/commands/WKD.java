package org.pgpainless.pgpeasy.commands;

import org.pgpainless.pgpeasy.commands.wkd.Fetch;
import picocli.CommandLine;

@CommandLine.Command(
        name = "wkd",
        description = "Interact with the Web Key Directory",
        subcommands = {
                Fetch.class,
        }
)
public class WKD implements Runnable {

    @Override
    public void run() {

    }
}
