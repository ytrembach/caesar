package org.yt.jr.projects;

import org.yt.jr.projects.ui.UserInterface;
import org.yt.jr.projects.ui.UserInterfaceCLI;
import org.yt.jr.projects.ui.UserInterfaceCmdline;

public class Main {
    public static void main(String[] args) {
        UserInterface ui;
        if (args.length >= 2) {
            String cmd = args[0];
            String filePath = args[1];
            String key = args.length == 3 ? args[2] : "0";
            ui = new UserInterfaceCmdline(cmd, filePath, key);
        } else {
            ui = new UserInterfaceCLI();
        }
        ui.processControls();
    }
}