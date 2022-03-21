package org.pgpainless.pgpeasy.commands;

import org.pgpainless.pgpeasy.commands.packet.Join;
import org.pgpainless.pgpeasy.commands.packet.Split;
import picocli.CommandLine;

@CommandLine.Command(
        name = "packet",
        description = "Operations on OpenPGP packets",
        subcommands = {
                Split.class,
                Join.class
        }
)
public class Packet implements Runnable {

    @Override
    public void run() {

    }
}
