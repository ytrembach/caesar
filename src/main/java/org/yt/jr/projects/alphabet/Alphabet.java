package org.yt.jr.projects.alphabet;

import java.security.InvalidParameterException;

public enum Alphabet {

    UNKNOWN(),
    EN("en", "abcdefghijklmnopqrstuvwxyz"),
    UKR("ukr", "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя");

    private final String name;
    private final char[] symbols;
    private final int alphabetLength;

    Alphabet() {
        this.name = "unknown";
        this.alphabetLength = 0;
        this.symbols = new char[0];
    }

    Alphabet(final String name, final String letters) {
        char[] PUNCTUATION = {'.', ',', '«', '»', '"', '\\', ':', '!', '?', ' '};

        char[] alphabetChars = letters.toCharArray();
        if (isCharsUnique(alphabetChars)) {
            this.name = name;

            alphabetLength = letters.length() * 2 + PUNCTUATION.length; // small letters + capital letters + punctuation
            symbols = new char[alphabetLength];

            System.arraycopy(letters.toUpperCase().toCharArray(), 0, symbols, 0, letters.length());
            System.arraycopy(letters.toLowerCase().toCharArray(), 0, symbols, letters.length(), letters.length());
            System.arraycopy(PUNCTUATION, 0, symbols, 2 * letters.length(), PUNCTUATION.length);
        } else {
            throw new InvalidParameterException(String.format("Symbols in alphabet %s are not unique", name));
        }
    }

    private boolean isCharsUnique(final char[] chars) {
        for (int i = 0; i < chars.length - 1; i++) {
            char testedSymbol = chars[i];
            for (int j = i + 1; j < chars.length; j++) {
                if (testedSymbol == chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public int getAlphabetLength() {
        return alphabetLength;
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

        int symbolPos = getSymbolPos(symbol);
        if (symbolPos == -1) { // the symbol is not a letter or a known punctuation - pass it through
            return symbol;
        }

        int shiftedPos = symbolPos + key;
        if (shiftedPos > alphabetLength) {
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

    public static Alphabet detect(char[] text) {
        for (Alphabet alphabet : Alphabet.values()) {
            if (alphabet.isTextMatches(text)) {
                return alphabet;
            }
        }
        return UNKNOWN;
    }

    @Override
    public String toString() {
        return "Alphabet{" +
                "name='" + name + '\'' +
                '}';
    }
}
