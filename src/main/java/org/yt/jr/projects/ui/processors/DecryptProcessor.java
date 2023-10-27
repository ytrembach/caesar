package org.yt.jr.projects.ui.processors;

import org.yt.jr.projects.ui.Config;

public class DecryptProcessor extends GeneralCryptProcessor implements Processable {
    public int process(final String keyStr) {
        if (!prepare("[DECRYPTED]")) {
            return -1;
        }
        final char[] decryptedText = caesar.process(textToProcess, -Config.CONFIG.getKey());
        if (!fileService.write(decryptedText)) {
            return -1;
        }
        return 0;
    }
}

