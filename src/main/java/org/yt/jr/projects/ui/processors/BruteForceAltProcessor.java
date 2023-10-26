package org.yt.jr.projects.ui.processors;

import org.yt.jr.projects.ui.Config;
import org.yt.jr.projects.crypto.BruteForce;

public class BruteForceAltProcessor extends GeneralCryptProcessor implements Processor {
    public int process(final String keyStr) {
        if (!prepare("[DECRYPTED]")) {
            return -1;
        }

        final BruteForce bruteForce = new BruteForce(caesar);
        final int candidateKey = bruteForce.search(textToProcess);

        final char[] decryptedText = caesar.process(textToProcess, -candidateKey);
        if (!fileService.write(decryptedText)) {
            return -1;
        }
        return 0;
    }
}
