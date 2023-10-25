package org.yt.jr.projects.ui;

public class Control {
    private Commands cmd;
    private String param;

    final public static Control EXIT = new Control(Commands.EXIT,"");

    public Control(Commands cmd, String param) {
        this.cmd = cmd;
        this.param = param;
    }

    public Commands getCmd() {
        return cmd;
    }

    public String getParam() {
        return param;
    }
}
