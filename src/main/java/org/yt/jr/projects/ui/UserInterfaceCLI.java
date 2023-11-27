package org.yt.jr.projects.ui;

import java.util.Scanner;

public class UserInterfaceCLI extends UserInterface {

    final Scanner commandReader = new Scanner(System.in);

    protected Control getNextControl() {
        System.out.print("Type the next command >>> ");
        final String userCmd = commandReader.nextLine();

        for (Commands c : Commands.values()) {
            if (c.getCmd().equals(userCmd.toUpperCase())) {
                return new Control(c, "");
            }
        }

        try {
            Integer.parseInt(userCmd);
            return new Control(Commands.SET_KEY, userCmd);
        } catch (NumberFormatException e) {
            // nothing to do
        }

        return new Control(Commands.SET_PATH, userCmd);
    }


}
