package org.yt.jr.projects.crypto;

public class BruteForce {

    private final Caesar caesar;

    public BruteForce(final Caesar caesar) {
        this.caesar = caesar;
    }

    public int search(final char[] encryptedText) {
        for (int testKey = 1; testKey < caesar.getAlphabet().getAlphabetLength(); testKey++) {
            final char[] testResult = caesar.process(encryptedText, testKey);

            // TODO
        }
        return -1;
    }
}
