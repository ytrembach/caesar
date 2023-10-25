package org.yt.jr.projects.ui;

import org.yt.jr.projects.alphabet.SupportedAlphabets;

import java.nio.file.Path;

public class Config {

    public final static Config CONFIG = new Config();
    private Path path = null;
    private int key = 0;
    private SupportedAlphabets language = SupportedAlphabets.UNSUPPORTED;

    private Config() {

    }

    public Path getPath() {
        return path;
    }

    public void setPath(final Path path) {
        this.path = path;
    }

    public int getKey() {
        return key;
    }

    public void setKey(final int key) {
        this.key = key;
    }

    public SupportedAlphabets getLanguage() {
        return language;
    }

    public void setLanguage(final SupportedAlphabets language) {
        this.language = language;
    }

    public boolean checkConfig() {
        if (path == null) {
            System.out.println("Path to file not set");
            return false;
        }

        if (language == SupportedAlphabets.UNSUPPORTED) {
            System.out.println("Language doesn't recognized");
        }
        return true;
    }
}
