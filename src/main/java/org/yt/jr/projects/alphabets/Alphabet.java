package org.yt.jr.projects.alphabets;

import java.security.InvalidParameterException;

public enum Alphabet {

    UNKNOWN(),
    EN("en", "abcdefghijklmnopqrstuvwxyz"),
    UKR("ukr", "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя");

    private final String name;
    private final char[] symbols;

    Alphabet() {
        this.name = "unknown";
        this.symbols = new char[0];
    }

    Alphabet(final String name, final String alphabet) {
        char[] PUNCTUATION = {'.', ',', '«', '»', '"', '\\', ':', '!', '?', ' '};

        char[] alphabetChars = alphabet.toCharArray();
        if (isCharsUnique(alphabetChars)) {
            this.name = name;

            int length = alphabet.length() * 2 + PUNCTUATION.length; // small/capital letter + punctuation
            symbols = new char[length];

            System.arraycopy(alphabet.toUpperCase().toCharArray(), 0, symbols, 0, alphabet.length());
            System.arraycopy(alphabet.toLowerCase().toCharArray(), 0, symbols, alphabet.length(), alphabet.length());
            System.arraycopy(PUNCTUATION, 0, symbols, 2 * alphabet.length(), PUNCTUATION.length);
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

    public int getSymbolPos(final char symbol) {
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == symbol) {
                return i;
            }
        }
        return -1;
    }

    public char shift(final char symbol, final int offset) {
        if (symbols.length == 0 || offset == 0) {
            return symbol;
        }
        int symbolPos = getSymbolPos(symbol);
        int shiftedPos = symbolPos + offset;
        if (shiftedPos > symbols.length) {
            shiftedPos = shiftedPos % symbols.length;
        } else if (shiftedPos < 0) {
            shiftedPos = symbols.length - (symbols.length - shiftedPos) % symbols.length;
        }
        return symbols[shiftedPos];
    }

    public boolean isTextMatches(final String[] text) {
        for (String line : text) {
            for (int i = 0; i < line.length(); i++) {
                char currChar = line.charAt(i);
                if (Character.isLetter(currChar) && getSymbolPos(currChar) < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Alphabet detect(String[] text) {
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
