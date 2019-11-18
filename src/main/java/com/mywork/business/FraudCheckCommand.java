package com.mywork.business;

public class FraudCheckCommand implements Command {

    private FraudCheck fraudCheck;

    public FraudCheckCommand(FraudCheck fraudCheck) {
        this.fraudCheck = fraudCheck;
    }

    @Override
    public void execute() {
        fraudCheck.check();
    }
}
