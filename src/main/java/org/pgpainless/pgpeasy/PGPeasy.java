package org.pgpainless.pgpeasy;

import org.pgpainless.cli.PGPainlessCLI;
import org.pgpainless.pgpeasy.commands.Packet;
import org.pgpainless.pgpeasy.commands.WOT;
import org.pgpainless.sop.SOPImpl;
import pgp.cert_d.cli.PGPCertDCli;
import pgp.vks.client.cli.VKSCLI;
import pgp.wkd.cli.WKDCLI;
import picocli.AutoComplete;
import picocli.CommandLine;
import sop.cli.picocli.SopCLI;
import sop.cli.picocli.commands.ArmorCmd;
import sop.cli.picocli.commands.DearmorCmd;
import sop.cli.picocli.commands.DecryptCmd;
import sop.cli.picocli.commands.DetachInbandSignatureAndMessageCmd;
import sop.cli.picocli.commands.EncryptCmd;
import sop.cli.picocli.commands.ExtractCertCmd;
import sop.cli.picocli.commands.GenerateKeyCmd;
import sop.cli.picocli.commands.SignCmd;
import sop.cli.picocli.commands.VerifyCmd;

@CommandLine.Command(
        subcommands = {
                // Inherit from SOP
                EncryptCmd.class,
                DecryptCmd.class,
                SignCmd.class,
                VerifyCmd.class,
                ArmorCmd.class,
                DearmorCmd.class,
                ExtractCertCmd.class,
                GenerateKeyCmd.class,
                DetachInbandSignatureAndMessageCmd.class,

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

    public static void main(String[] args) {
        SopCLI.setSopInstance(new SOPImpl());
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
