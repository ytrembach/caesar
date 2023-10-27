package org.yt.jr.projects.lang;

import org.yt.jr.projects.crypto.Caesar;

import java.util.HashMap;

public class FrequencyAnalyzer {
    final Alphabet alphabet;
    final private HashMap<Integer, Double> frequencies;

    public FrequencyAnalyzer(Alphabet alphabet) {
        this.alphabet = alphabet;
        this.frequencies = new HashMap<>();
    }

    public void setFrequencies(char[] symbols, double[] freqArray) {
        for (int i = 0; i < symbols.length; i++) {
            char capitalizedSymbol = Character.toUpperCase(symbols[i]);
            if (alphabet.getSymbolPos(capitalizedSymbol) >= 0) {
                this.frequencies.put(alphabet.getSymbolPos(capitalizedSymbol), freqArray[i]);
            }
        }
    }

    public int search(final char[] encryptedText) {
        final Caesar caesar = new Caesar(alphabet);
        final HashMap<Integer, Double> testFreq = new HashMap<>(frequencies);
        final HashMap<Integer, Double> candidates = new HashMap<>();

        for (int testKey = 1; testKey < alphabet.getAlphabetLength(); testKey++) {
            final char[] testResult = caesar.process(encryptedText, -testKey);

            testFreq.replaceAll((k, v) -> 0.0);
            for (char c : testResult) {
                final int symbolPos = alphabet.getSymbolPos(Character.toUpperCase(c));
                if (testFreq.containsKey(symbolPos)) {
                    testFreq.replace(symbolPos, testFreq.get(symbolPos) + 1);
                }
            }
            testFreq.replaceAll((k, v) -> v / encryptedText.length);

            double distance = 0;
            for (int symbolPos : testFreq.keySet()) {
                distance += Math.pow(testFreq.get(symbolPos) - frequencies.get(symbolPos), 2);
            }
            distance = Math.sqrt(distance);
            candidates.put(testKey, distance);
        }

        int candidate = -1;
        double minDistance = Double.MAX_VALUE;
        for (int testKey = 1; testKey < alphabet.getAlphabetLength(); testKey++) {
            final double distance = candidates.get(testKey);
            if (distance < minDistance) {
                minDistance = distance;
                candidate = testKey;
            }
        }
        return candidate;
    }
}
