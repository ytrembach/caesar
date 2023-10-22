package org.yt.jr.projects.crypto;

import org.yt.jr.projects.alphabet.Alphabet;

public class Caesar {
    private final Alphabet alphabet;

    public Caesar(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public char[] process(char[] textToProcess, int key) {
        char[] proceeded = new char[textToProcess.length];
        for (int i = 0; i < textToProcess.length; i++) {
            proceeded[i] = alphabet.shift(textToProcess[i], key);
        }
        return proceeded;
    }

    public Alphabet getAlphabet() {
        return alphabet;
    }
}

