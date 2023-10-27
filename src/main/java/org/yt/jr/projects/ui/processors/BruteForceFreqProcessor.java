package org.yt.jr.projects.ui.processors;

import org.yt.jr.projects.crypto.BruteForceAlt;
import org.yt.jr.projects.lang.FrequencyAnalyzer;

public class BruteForceFreqProcessor extends GeneralCryptProcessor implements Processable {
    public int process(final String keyStr) {
        if (!prepare("[DECRYPTED]")) {
            return -1;
        }

        final FrequencyAnalyzer frequencyAnalyzer = caesar.getAlphabet().getFrequencyAnalyzer();
        final int candidateKey = frequencyAnalyzer.search(textToProcess);

        final char[] decryptedText = caesar.process(textToProcess, -candidateKey);
        if (!fileService.write(decryptedText)) {
            return -1;
        }
        return 0;
    }
}
