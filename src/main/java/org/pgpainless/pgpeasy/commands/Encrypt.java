package org.pgpainless.pgpeasy.commands;

import picocli.CommandLine;

@CommandLine.Command(
        name = "encrypt",
        description = "Encrypt a message"
)
public class Encrypt implements Runnable {
    @Override
    public void run() {
        System.out.println("Not yet implemented.");
    }
}
