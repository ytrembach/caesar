package org.yt.jr.projects.ui.processors;

import org.yt.jr.projects.ui.Config;

import java.security.InvalidParameterException;

public class EncryptProcessor extends Processor{
    public void process(final String keyStr) {
        System.out.printf("Encrypting file %s by the key %d using alphabet for language %s%n",
                Config.CONFIG.getPath(),
                Config.CONFIG.getKey(),
                Config.CONFIG.getLanguage());
    }
}
