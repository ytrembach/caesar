package org.yt.jr.projects.lang;

public enum Languages {
    UNSUPPORTED(new Alphabet()),
    EN(new Alphabet("en",
            "abcdefghijklmnopqrstuvwxyz",
            "aeiou",
            null)),
    UKR(new Alphabet("ukr",
            "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя",
            "аеєиіїоуюя",
            new double[]{0.064, 0.042, 0.005, 0.055, 0.044, 0.010, 0.086, 0.027, 0.008, 0.019}
    ));

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
