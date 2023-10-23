package org.yt.jr.projects.alphabet;

public enum SupportedAlphabets {
    UNSUPPORTED(new Alphabet()),
    EN(new Alphabet("en", "abcdefghijklmnopqrstuvwxyz")),
    UKR(new Alphabet("ukr", "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя"));

    private Alphabet alphabet;

    SupportedAlphabets(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public Alphabet getAlphabet() {
        return alphabet;
    }

    public static SupportedAlphabets detect(char[] text) {
        for (SupportedAlphabets value : values()) {
            if (value.alphabet.isTextMatches(text)) {
                return value;
            }
        }
        return UNSUPPORTED;
    }
}
