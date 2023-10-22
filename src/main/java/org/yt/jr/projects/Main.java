package org.yt.jr.projects;

import org.yt.jr.projects.alphabet.Alphabet;
import org.yt.jr.projects.crypto.Caesar;

import java.security.InvalidParameterException;

public class Main {
    public static void main(String[] args) {
        int key = 13;
        char[] textToProcess =
                ("And so, the king is once again my guest\n" +
                "And why is this?\n" +
                "Was Herod unimpressed?\n").toCharArray();
        // char[] textToProcess = "This is a test! Do you see me?!\n".toCharArray();
        // char[] textToProcess = "А я на небі, мила моя, на небі\n", "To be or not to be\n".toCharArray();

        for (char currChar : textToProcess) {
            System.out.print(currChar);
        }

        Alphabet alphabet = Alphabet.detect(textToProcess);
        if (alphabet == Alphabet.UNKNOWN) {
            throw new InvalidParameterException("Alphabet detection failed");
        }

        Caesar caesar = new Caesar(alphabet);
        char[] resultText = caesar.process(textToProcess, key);

        for (char currChar : resultText) {
            System.out.print(currChar);
        }

        char[] reverseText = caesar.process(resultText, -key);
        for (char currChar : reverseText) {
            System.out.print(currChar);
        }

    }
}