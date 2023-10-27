package org.yt.jr.projects.ui.processors;

import org.yt.jr.projects.crypto.Caesar;
import org.yt.jr.projects.file.FileService;
import org.yt.jr.projects.lang.Languages;
import org.yt.jr.projects.ui.Config;

import java.nio.file.Files;
import java.nio.file.Path;

public abstract class GeneralCryptProcessor {
    protected FileService fileService;
    protected char[] textToProcess;
    private Languages language = Languages.UNSUPPORTED;
    protected Caesar caesar;

    public boolean prepare(final String outputPrefix) {
        return readSource(outputPrefix) && detectLanguage() && createCaesar();
    }

    private boolean readSource(final String outputPrefix) {
        Path inputFile = Config.CONFIG.getPath();
        if (inputFile == null || !Files.exists(inputFile)) {
            System.out.print("Input file not found or path to it is invalid");
        }
        fileService = new FileService(Config.CONFIG.getPath(), outputPrefix);
        textToProcess = fileService.read();
        return textToProcess != null;
    }

    private boolean detectLanguage() {
        language = Languages.detect(textToProcess);
        if (language == Languages.UNSUPPORTED) {
            System.out.print("Language is not supported or detection failed");
        }
        return language != Languages.UNSUPPORTED;
    }

    private boolean createCaesar() {
        caesar = new Caesar(language.getAlphabet());
        return true;
    }
}
