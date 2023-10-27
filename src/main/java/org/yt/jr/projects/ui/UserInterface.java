package org.yt.jr.projects.ui;

import org.yt.jr.projects.ui.processors.Processable;

public abstract class UserInterface {
    protected abstract Control getNextControl();

    UserInterface() {
        usage();
    }

    public void processControls() {
        Control nextControl = getNextControl();
        while (nextControl != Control.EXIT) {
            if (nextControl == Control.BAD_COMMAND) {
                usage();
            } else {
                Processable processor = nextControl.getCmd().getProcessor();
                if (processor != null) {
                    String param = nextControl.getParam();
                    System.out.printf("%nDO %s: %s%n", nextControl.getCmd().getTitle(), param);
                    int returnCode = processor.process(param);
                    System.out.println(returnCode == 0 ? "Ok" : "Failed");
                }
            }
            nextControl = getNextControl();
        }

        System.out.println("Bye!");
    }

    private void usage() {
        System.out.println("\nAve, Caesar cipher user!");
        System.out.println("Supported commands:\n");
        System.out.println("<path to file > - the absolute 1path to the input file");
        System.out.println("[integer] - cipher key (for ENCRYPT and DECRYPT commands");
        System.out.println("ENCRYPT - encrypt the input file");
        System.out.println("DECRYPT - decrypt the input file with the key entered by user");
        System.out.println("BRUTE_FORCE - decrypt the input file using frequency analysis");
        System.out.println("BRUTE_FORCE_ALT - decrypt the input file using syntax analysis");
    }
}
