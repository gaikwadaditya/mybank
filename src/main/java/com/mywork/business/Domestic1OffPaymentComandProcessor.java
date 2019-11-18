package com.mywork.Business;

public class Domestic1OffPaymentComandProcessor {

    Command command;

    public Domestic1OffPaymentComandProcessor() {
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void process() {
        command.execute();
    }
}
