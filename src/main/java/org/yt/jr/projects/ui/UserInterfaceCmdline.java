package org.yt.jr.projects.ui;

import java.util.ArrayList;

public class UserInterfaceCmdline extends UserInterface {

    ArrayList<Control> queue = new ArrayList<>();

    protected Control getNextControl() {
        if (!queue.isEmpty()) {
            return queue.remove(0);
        }
        return (Control.EXIT);
    }

    public UserInterfaceCmdline(final String userCmd, final String userPath, final String userKey) {
        queue.add(new Control(Commands.SET_PATH, userPath));
        if (!"0".equals(userKey)) {
            queue.add(new Control(Commands.SET_KEY, userKey));
        }

        for (Commands command : Commands.values()) {
            if (command.getCmd().equals(userCmd.toUpperCase())) {
                queue.add(new Control(command, ""));
            }
        }
    }

}
