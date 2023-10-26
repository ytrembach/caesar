package org.yt.jr.projects.ui.processors;

import org.yt.jr.projects.ui.Config;

import java.security.InvalidKeyException;
import java.security.InvalidParameterException;

public class SetKeyProcessor implements Processor {
    public int process(final String keyStr) {
        int key;
        try {
            key = Integer.parseInt(keyStr);
            Config.CONFIG.setKey(key);
            return 0;
        } catch (NumberFormatException e) {
            System.out.print("Key should be an integer number: ");
        }
        return -1;
    }
}
