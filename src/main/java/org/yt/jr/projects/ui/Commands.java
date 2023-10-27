package org.yt.jr.projects.ui;

import org.yt.jr.projects.ui.processors.*;

public enum Commands {
    EXIT("Exit", null, ""),
    SET_PATH("Set the path to file to proceed", new SetPathProcessor(), ""),
    SET_KEY("Set the key", new SetKeyProcessor(), ""),
    ENCRYPT("Encrypt file", new EncryptProcessor(), "ENCRYPT"),
    DECRYPT("Decrypt by key", new DecryptProcessor(), "DECRYPT"),
    BRUTEFORCE_ALT("Decrypt by alternate brute force method", new BruteForceAltProcessor(), "BRUTE_FORCE_ALT"),
    BRUTEFORCE_FREQ("Decrypt by frequency analysis brute force", null, "BRUTE_FORCE");

    final private String title;
    final private Processable processor;
    final private String cmd;

    Commands(final String title, final Processable processor, final String cmd) {
        this.title = title;
        this.processor = processor;
        this.cmd = cmd;
    }

    public String getTitle() {
        return title;
    }

    public Processable getProcessor() {
        return processor;
    }

    public String getCmd() {
        return cmd;
    }
}
