package org.pgpainless.pgpeasy;

import org.pgpainless.pgpeasy.commands.Cert;
import org.pgpainless.pgpeasy.commands.Decrypt;
import org.pgpainless.pgpeasy.commands.Encrypt;
import org.pgpainless.pgpeasy.commands.Key;
import org.pgpainless.pgpeasy.commands.Packet;
import org.pgpainless.pgpeasy.commands.Sign;
import org.pgpainless.pgpeasy.commands.Verify;
import org.pgpainless.pgpeasy.commands.WKD;
import org.pgpainless.pgpeasy.commands.WOT;
import picocli.AutoComplete;
import picocli.CommandLine;

@CommandLine.Command(
        subcommands = {
                Encrypt.class,
                Decrypt.class,
                Sign.class,
                Verify.class,
                Key.class,
                Cert.class,
                Packet.class,
                WKD.class,
                WOT.class,
                CommandLine.HelpCommand.class,
                AutoComplete.GenerateCompletion.class
        }
)
public class PGPeasy {

    public static void main(String[] args) {
        int exitCode = execute(args);
        if (exitCode != 0) {
            System.exit(exitCode);
        }
    }

    public static int execute(String[] args) {
        return new CommandLine(PGPeasy.class)
                .setCommandName("pgpeasy")
                // .setExecutionExceptionHandler(new SOPExecutionExceptionHandler())
                // .setExitCodeExceptionMapper(new SOPExceptionExitCodeMapper())
                .setCaseInsensitiveEnumValuesAllowed(true)
                .execute(args);
    }
}
