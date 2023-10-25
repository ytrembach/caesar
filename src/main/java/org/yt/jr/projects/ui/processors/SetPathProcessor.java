package org.yt.jr.projects.ui.processors;

import org.yt.jr.projects.ui.Config;

import java.nio.file.Files;
import java.nio.file.Path;

public class SetPathProcessor extends Processor {
    public void process(final String fileName) {
        Path path = Path.of(fileName);
        if (Files.exists(path)) {
            Config.CONFIG.setPath(path);
        } else {
            System.out.println("File not found");
        }
    }
}
