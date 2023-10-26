package org.yt.jr.projects.ui;

import org.yt.jr.projects.ui.processors.Processor;

public abstract class UserInterface {
    protected abstract Control getNextControl();

    public void processControls() {
        Control nextControl;
        while ((nextControl = getNextControl()) != Control.EXIT) {
            Processor processor = nextControl.getCmd().getProcessor();
            String param = nextControl.getParam();
            if (processor != null) {
                System.out.printf("%nDO %s: %s%n", nextControl.getCmd().getTitle(), param);
                int returnCode = processor.process(param);
                System.out.println(returnCode == 0 ? "Ok" : "Failed");
            }
        }

        System.out.println("Bye!");
    }
}
