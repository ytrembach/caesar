package org.yt.jr.projects.ui;

import java.nio.file.Files;
import java.nio.file.Path;

public class Config {

    public final static Config CONFIG = new Config();
    private Path path = null;
    private int key = 0;

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

}
