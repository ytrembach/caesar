package org.yt.jr.projects;

import org.yt.jr.projects.alphabet.SupportedAlphabets;
import org.yt.jr.projects.crypto.BruteForce;
import org.yt.jr.projects.crypto.Caesar;

import java.security.InvalidParameterException;

public class Main {
    public static void main(String[] args) {
        int key = 44;
        char[] textToProcess =
                ("And so, the king is once again my guest\n" +
                "And why is this?\n" +
                "Was Herod unimpressed?\n").toCharArray();
        // char[] textToProcess = "This is a test! Do you see me?!\n".toCharArray();
        // char[] textToProcess = "А я на небі, мила моя, на небі\n", "To be or not to be\n".toCharArray();

        for (char currChar : textToProcess) {
            System.out.print(currChar);
        }

        SupportedAlphabets detected = SupportedAlphabets.detect(textToProcess);
        if (detected == SupportedAlphabets.UNSUPPORTED) {
            throw new InvalidParameterException("Alphabet detection failed");
        }

        Caesar caesar = new Caesar(detected.getAlphabet());
        char[] resultText = caesar.process(textToProcess, key);

        for (char currChar : resultText) {
            System.out.print(currChar);
        }

        BruteForce bruteForce = new BruteForce(caesar);
        int candidate = bruteForce.search(resultText);
        System.out.println(candidate);

    }
}