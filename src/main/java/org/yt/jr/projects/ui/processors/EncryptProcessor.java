package org.yt.jr.projects.ui.processors;

import org.yt.jr.projects.ui.Config;

public class EncryptProcessor extends GeneralCryptProcessor implements Processor {
    public int process(final String keyStr) {
        if (!prepare("[ENCRYPTED]")) {
            return -1;
        }
        final char[] encryptedText = caesar.process(textToProcess, Config.CONFIG.getKey());
        if (!fileService.write(encryptedText)) {
            return -1;
        }
        return 0;
    }
}

