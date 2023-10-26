package org.yt.jr.projects.ui.processors;

import org.yt.jr.projects.ui.Config;

import java.io.File;
import java.security.InvalidParameterException;

public class EncryptProcessor extends CryptProcess implements Processor {
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

