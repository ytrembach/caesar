package org.yt.jr.projects;

import org.yt.jr.projects.ui.UserInterface;
import org.yt.jr.projects.ui.UserInterfaceCmdline;

public class Main {
    public static void main(String[] args) {
//        int key = 32;
//        char[] textToProcess =
//                ("And so, the king is once again my guest\n" +
//                "And why is this?\n" +
//                "Was Herod unimpressed?\n").toCharArray();
//        // char[] textToProcess = "This is a test! Do you see me?!\n".toCharArray();
//        // char[] textToProcess = "А я на небі, \nмила моя, на небі\n".toCharArray();
//
//        for (char currChar : textToProcess) {
//            System.out.print(currChar);
//        }
//
//        SupportedAlphabets detected = SupportedAlphabets.detect(textToProcess);
//        if (detected == SupportedAlphabets.UNSUPPORTED) {
//            throw new InvalidParameterException("Alphabet detection failed");
//        }
//
//        Caesar caesar = new Caesar(detected.getAlphabet());
//        char[] resultText = caesar.process(textToProcess, key);
//        for (char currChar : resultText) {
//            System.out.print(currChar);
//        }
//
//        BruteForce bruteForce = new BruteForce(caesar);
//        int candidate = bruteForce.search(resultText);
//        System.out.println(candidate);
//
//        char[] reverseText = caesar.process(resultText, -candidate);
//        for (char currChar : reverseText) {
//            System.out.print(currChar);
//        }
        UserInterface ui = null;
        if (args.length > 0) {
            if (args.length >= 2) {
                String cmd = args[0];
                String filePath = args[1];
                String key = args.length == 3 ? args[2] : "0";
                ui = new UserInterfaceCmdline(cmd, filePath, key);
            }
        }
        ui.processControls();
    }
}