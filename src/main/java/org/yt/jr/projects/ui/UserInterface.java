package org.yt.jr.projects.ui;

import org.yt.jr.projects.alphabet.Alphabet;
import org.yt.jr.projects.alphabet.SupportedAlphabets;
import org.yt.jr.projects.ui.processors.Processor;

import java.nio.file.Path;

public abstract class UserInterface {
    protected abstract Control getNextControl();

    public void processControls() {
        Control nextControl;
        while ((nextControl = getNextControl()) != Control.EXIT) {
            Processor processor = nextControl.getCmd().getProcessor();
            String param = nextControl.getParam();
            if (processor != null) {
                System.out.printf("%s: %s%n",nextControl.getCmd().getTitle(), param);
                processor.process(param);
            }
        }

        System.out.println("Bye!");
    }

    ;

}
