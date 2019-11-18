package com.mywork.Business;

public class TransactionLoggingCommand implements Command {

    private TransactionLogging transactionLogging;

    public TransactionLoggingCommand(TransactionLogging transactionLogging) {
        this.transactionLogging = transactionLogging;
    }


    @Override
    public void execute() {
        transactionLogging.log();
    }
}
