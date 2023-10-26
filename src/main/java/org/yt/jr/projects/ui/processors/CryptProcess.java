package org.yt.jr.projects.ui.processors;

import org.yt.jr.projects.crypto.Caesar;
import org.yt.jr.projects.file.FileService;
import org.yt.jr.projects.lang.Languages;
import org.yt.jr.projects.ui.Config;

public abstract class CryptProcess {
    protected FileService fileService;
    protected char[] textToProcess;
    private Languages language = Languages.UNSUPPORTED;
    protected Caesar caesar;

    public boolean prepare(String outputPrefix) {
        return checkConfig() && readSource(outputPrefix) && detectLanguage() && createCaesar();
    }

    private boolean checkConfig() {
        String checkConfigResult = Config.CONFIG.checkConfig();
        if (!checkConfigResult.isEmpty()) {
            System.out.printf("Check config failed (%s): ", checkConfigResult);
            return false;
        }
        return true;
    }

    private boolean readSource(final String outputPrefix) {
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
