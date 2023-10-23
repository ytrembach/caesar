package org.yt.jr.projects.crypto;

import org.yt.jr.projects.alphabet.Alphabet;
import java.util.HashMap;

public class BruteForce {

    private final Caesar caesar;

    public BruteForce(final Caesar caesar) {
        this.caesar = caesar;

    }

    public int search(final char[] encryptedText) {
        // violations - the number of failed checks, the variant with minimum number will be the candidate
        HashMap<Integer, Integer> violations = new HashMap<>();

        for (int testKey = 1; testKey < caesar.getAlphabet().getAlphabetLength(); testKey++) {
            final char[] testResult = caesar.process(encryptedText, -testKey);
            violations.put(testKey,
                    countSignBetweenTwoLetters(testResult) +
                            countConsonantSequences(testResult, 4));
        }
        return getMinKey(violations);
    }

    private int countSignBetweenTwoLetters(final char[] text) {
        final int sampleLength = 3;
        int count = 0;
        for (int i = 0; i < text.length - sampleLength; i++) {
            if (Character.isLetter(text[i]) && Alphabet.isSign(text[i + 1]) && Character.isLetter(text[i + 2])) {
                count++;
            }
        }
        return count;
    }

    private int countConsonantSequences(final char[] text, final int checkLen) {
        int count = 0;
        final Alphabet alphabet = caesar.getAlphabet();
        boolean prevConsonant = false;
        int seqLen = 0;

        for (char symbol : text) {
            if (!alphabet.isVowel(symbol)) {
                seqLen++;
                if (prevConsonant && seqLen >= checkLen) {
                    count++;
                }
                prevConsonant = true;
            } else {
                seqLen = 0;
                prevConsonant = false;
            }

        }
        return count;
    }

    private int getMinKey(final HashMap<Integer, Integer> violations) {
        int min = Integer.MAX_VALUE;
        int minKey = -1;
        for (Integer key : violations.keySet()) {
            if (violations.get(key) < min) {
                minKey = key;
                min = violations.get(minKey);
            }
        }
        return minKey;
    }
}
