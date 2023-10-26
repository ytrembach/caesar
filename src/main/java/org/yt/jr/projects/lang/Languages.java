package org.yt.jr.projects.lang;

public enum Languages {
    UNSUPPORTED(new Alphabet()),
    EN(new Alphabet("en", "abcdefghijklmnopqrstuvwxyz","aeiou")),
    UKR(new Alphabet("ukr", "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя","аеєиіїоуюя"));

    final private Alphabet alphabet;

    Languages(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public Alphabet getAlphabet() {
        return alphabet;
    }

    public static Languages detect(char[] text) {
        for (Languages language : values()) {
            if (language.alphabet.isTextMatches(text)) {
                return language;
            }
        }
        return UNSUPPORTED;
    }
}
