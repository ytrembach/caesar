package org.yt.jr.projects.ui;

import java.util.ArrayList;

public class UserInterfaceCmdline extends UserInterface {

    final ArrayList<Control> queue = new ArrayList<>();

    protected Control getNextControl() {
        if (!queue.isEmpty()) {
            return queue.remove(0);
        }
        return (Control.EXIT);
    }

    public UserInterfaceCmdline(final String userCmd, final String userPath, final String userKey) {
        if (!"0".equals(userKey)) {
            queue.add(new Control(Commands.SET_KEY, userKey));
        }

        queue.add(new Control(Commands.SET_PATH, userPath));

        Control control = Control.BAD_COMMAND;
        for (Commands c : Commands.values()) {
            if (c.getCmd().equals(userCmd.toUpperCase())) {
                control = new Control(c, "");
                break;
            }
        }
        queue.add(control);
    }

}
