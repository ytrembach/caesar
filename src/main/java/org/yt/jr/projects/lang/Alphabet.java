package org.yt.jr.projects.lang;

import java.security.InvalidParameterException;

public class Alphabet {
    private final String name;
    private final char[] symbols;
    private final char[] vowels;
    private final int alphabetLength;
    private final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer(this);
    public final static char[] PUNCTUATION = {'.', ',', '«', '»', '"', '\\', ':', '!', '?'};

    public static boolean isSign(final char ch) {
        for (int i = 0; i < Alphabet.PUNCTUATION.length; i++) {
            if (ch == Alphabet.PUNCTUATION[i]) {
                return true;
            }
        }
        return false;
    }

    Alphabet() {
        this.name = "unknown";
        this.alphabetLength = 0;
        this.symbols = new char[0];
        this.vowels = new char[0];
    }

    Alphabet(final String name, final String letters, final String vowels, final double[] vowelsFrequencies) {
        final char[] alphabetChars = letters.toCharArray();
        if (checkSymbolsUnique(alphabetChars)) {
            this.name = name;

            // small letters + capital letters + punctuation count + space symbol
            alphabetLength = letters.length() * 2 + PUNCTUATION.length + 1;
            symbols = new char[alphabetLength];

            System.arraycopy(letters.toUpperCase().toCharArray(), 0, symbols, 0, letters.length());
            System.arraycopy(letters.toLowerCase().toCharArray(), 0, symbols, letters.length(), letters.length());
            System.arraycopy(PUNCTUATION, 0, symbols, 2 * letters.length(), PUNCTUATION.length);
            symbols[symbols.length - 1] = ' '; // add space to the end

            if (checkSymbolsInAlphabet(vowels.toCharArray())) {
                this.vowels = vowels.toCharArray();
            } else {
                throw new InvalidParameterException(String.format("Vowels are not in alphabet %s", name));
            }

        } else {
            throw new InvalidParameterException(String.format("Symbols in alphabet %s are not unique", name));
        }
        if (vowelsFrequencies != null && vowelsFrequencies.length == vowels.length()) {
            frequencyAnalyzer.setFrequencies(vowels.toCharArray(), vowelsFrequencies);
        }
    }

    public String getName() {
        return name;
    }

    private boolean checkSymbolsUnique(final char[] symbolsSet) {
        for (int i = 0; i < symbolsSet.length - 1; i++) {
            final char testedSymbol = symbolsSet[i];
            for (int j = i + 1; j < symbolsSet.length; j++) {
                if (testedSymbol == symbolsSet[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkSymbolsInAlphabet(final char[] symbolSet) {
        for (char symbol : symbolSet) {
            if (getSymbolPos(symbol) == -1) {
                return false;
            }
        }
        return true;
    }

    public int getAlphabetLength() {
        return alphabetLength;
    }

    public FrequencyAnalyzer getFrequencyAnalyzer() {
        return frequencyAnalyzer;
    }

    public boolean isVowel(final char symbol) {
        for (char vowel : vowels) {
            if (symbol == vowel) {
                return true;
            }
        }
        return false;
    }

    public int getSymbolPos(final char symbol) {
        for (int i = 0; i < alphabetLength; i++) {
            if (symbols[i] == symbol) {
                return i;
            }
        }
        return -1;
    }

    public char shift(final char symbol, final int key) {
        if (alphabetLength == 0 || key == 0) {
            return symbol;
        }

        final int symbolPos = getSymbolPos(symbol);
        if (symbolPos == -1) { // the symbol is not a letter or a known punctuation - pass it through
            return symbol;
        }

        int shiftedPos = symbolPos + key;
        if (shiftedPos >= alphabetLength) {
            shiftedPos = shiftedPos % alphabetLength;
        } else if (shiftedPos < 0) {
            shiftedPos = alphabetLength - (alphabetLength - shiftedPos) % alphabetLength;
        }

        return symbols[shiftedPos];
    }

    public boolean isTextMatches(final char[] text) {
        for (char currChar : text) {
            if (Character.isLetter(currChar) && getSymbolPos(currChar) < 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Alphabet{" + "name='" + name + '\'' + '}';
    }
}
