package org.yt.jr.projects.ui.processors;

import org.yt.jr.projects.ui.Commands;

public abstract class Processor {

    Commands command;

    public abstract void process(String param);
}
