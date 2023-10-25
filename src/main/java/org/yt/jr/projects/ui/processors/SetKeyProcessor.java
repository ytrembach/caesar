package org.yt.jr.projects.ui.processors;

import org.yt.jr.projects.ui.Config;

import java.security.InvalidParameterException;

public class SetKeyProcessor extends Processor {
    public void process(final String keyStr) {
        int key;
        try {
            key = Integer.parseInt(keyStr);
        } catch (NumberFormatException e) {
            System.out.println("Key should be an integer number");
            throw new InvalidParameterException();
        }

        Config.CONFIG.setKey(key);

    }
}
