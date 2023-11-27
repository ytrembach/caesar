package org.yt.jr.projects.crypto;

import org.yt.jr.projects.lang.Alphabet;

public class Caesar {
    private final Alphabet alphabet;

    public Caesar(final Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public char[] process(final char[] textToProcess, final int key) {
        final char[] proceeded = new char[textToProcess.length];
        for (int i = 0; i < textToProcess.length; i++) {
            proceeded[i] = alphabet.shift(textToProcess[i], key);
        }
        return proceeded;
    }

    public Alphabet getAlphabet() {
        return alphabet;
    }
}

