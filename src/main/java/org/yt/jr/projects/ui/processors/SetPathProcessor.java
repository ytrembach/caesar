package org.yt.jr.projects.ui.processors;

import org.yt.jr.projects.ui.Config;

import java.nio.file.Files;
import java.nio.file.Path;

public class SetPathProcessor implements Processable {
    public int process(final String fileName) {
        final Path path = Path.of(fileName);
        if (Files.exists(path) && Files.isRegularFile(path)) {
            Config.CONFIG.setPath(path);
            return 0;
        } else {
            System.out.printf("Path not found or not a file: %s: ", fileName);
            return -1;
        }
    }
}
