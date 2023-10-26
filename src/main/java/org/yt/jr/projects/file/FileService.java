package org.yt.jr.projects.file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {
    final private Path inputFile;
    final private Path outputFile;

    public FileService(final Path inputFile, final String outputPrefix) {
        this.inputFile = inputFile;
        this.outputFile = Path.of(inputFile.toString() + outputPrefix);
    }

    public char[] read() {
        try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
            StringBuilder text = new StringBuilder();
            while (reader.ready()) {
                text.append(reader.readLine());
                text.append("\n");
            }
            return text.toString().toCharArray();
        } catch (IOException e) {
            System.out.println("IO Exception" + e.getMessage());
        }
        return null;
    }

    public boolean write(final char[] text) {
        try (BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
            writer.write(text);
        } catch (IOException e) {
            System.out.println("IO Exception" + e.getMessage());
        }
        return true;
    }


}
