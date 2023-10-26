package org.yt.jr.projects.ui.processors;

import org.yt.jr.projects.ui.Config;

import java.nio.file.Files;
import java.nio.file.Path;

public class SetPathProcessor implements Processor {
    public int process(final String fileName) {
        Path path = Path.of(fileName);
        if (Files.exists(path)) {
            Config.CONFIG.setPath(path);
            return 0;
        } else {
            System.out.printf("File not found: %s: ", fileName);
            return -1;
        }
    }
}
