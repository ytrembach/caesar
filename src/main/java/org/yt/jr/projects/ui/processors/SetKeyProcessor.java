package org.yt.jr.projects.ui.processors;

import org.yt.jr.projects.ui.Config;

public class SetKeyProcessor implements Processable {
    public int process(final String keyStr) {
        final int key;
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
