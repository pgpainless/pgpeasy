package org.pgpainless.pgpeasy;

import org.pgpainless.pgpeasy.commands.Packet;
import org.pgpainless.pgpeasy.commands.WOT;
import pgp.cert_d.cli.PGPCertDCli;
import pgp.vks.client.cli.VKSCLI;
import pgp.wkd.cli.WKDCLI;
import picocli.AutoComplete;
import picocli.CommandLine;
import sop.cli.picocli.SopCLI;
import sop.cli.picocli.commands.ArmorCmd;
import sop.cli.picocli.commands.DearmorCmd;
import sop.cli.picocli.commands.DecryptCmd;
import sop.cli.picocli.commands.EncryptCmd;
import sop.cli.picocli.commands.ExtractCertCmd;
import sop.cli.picocli.commands.GenerateKeyCmd;
import sop.cli.picocli.commands.InlineDetachCmd;
import sop.cli.picocli.commands.InlineSignCmd;
import sop.cli.picocli.commands.InlineVerifyCmd;
import sop.cli.picocli.commands.SignCmd;
import sop.cli.picocli.commands.VerifyCmd;

@CommandLine.Command(
        subcommands = {
                // Inherit from SOP
                EncryptCmd.class,
                DecryptCmd.class,
                SignCmd.class,
                InlineSignCmd.class,
                VerifyCmd.class,
                InlineVerifyCmd.class,
                ArmorCmd.class,
                DearmorCmd.class,
                ExtractCertCmd.class,
                GenerateKeyCmd.class,
                InlineDetachCmd.class,

                // SOP as subcommand
                SopCLI.class,

                // WKD
                WKDCLI.class,

                // VKS
                VKSCLI.class,

                // PGP-Cert-D
                PGPCertDCli.class,

                // PGPeasy
                WOT.class,
                Packet.class,

                // Picocli
                CommandLine.HelpCommand.class,
                AutoComplete.GenerateCompletion.class
        }
)
public class PGPeasy {

    static {
        // Call static block of PGPainlessCLI
        try {
            Class.forName("org.pgpainless.cli.PGPainlessCLI");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        int exitCode = execute(args);
        if (exitCode != 0) {
            System.exit(exitCode);
        }
    }

    public static int execute(String[] args) {
        CommandLine cmd = new CommandLine(PGPeasy.class);
        // Hide generate-completion command
        CommandLine gen = cmd.getSubcommands().get("generate-completion");
        gen.getCommandSpec().usageMessage().hidden(true);

        return cmd
                .setCommandName("pgpeasy")
                .setCaseInsensitiveEnumValuesAllowed(true)
                .execute(args);
    }
}
