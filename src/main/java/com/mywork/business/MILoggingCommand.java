package com.mywork.business;

public class MILoggingCommand implements Command {

    private MILogging miLogging;

    public MILoggingCommand(MILogging miLogging) {
        this.miLogging = miLogging;
    }

    @Override
    public void execute() {
        miLogging.log();
    }
}
