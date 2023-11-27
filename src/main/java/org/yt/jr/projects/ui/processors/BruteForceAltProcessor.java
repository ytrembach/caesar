package org.yt.jr.projects.ui.processors;

import org.yt.jr.projects.crypto.BruteForceAlt;

public class BruteForceAltProcessor extends GeneralCryptProcessor implements Processable {
    public int process(final String keyStr) {
        if (!prepare("[DECRYPTED]")) {
            return -1;
        }

        final BruteForceAlt bruteForceAlt = new BruteForceAlt(caesar);
        final int candidateKey = bruteForceAlt.search(textToProcess);

        final char[] decryptedText = caesar.process(textToProcess, -candidateKey);
        if (!fileService.write(decryptedText)) {
            return -1;
        }
        return 0;
    }
}
