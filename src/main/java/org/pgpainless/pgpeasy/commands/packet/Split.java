package org.pgpainless.pgpeasy.commands.packet;

import picocli.CommandLine;

@CommandLine.Command(
        name = "split",
        description = "Split an OpenPGP message into individual packets"
)
public class Split implements Runnable {

    @Override
    public void run() {

    }
}
