package com.mywork.Business;

public class PreValidationCommand implements Command{

    private PreValidation preValidation;

    public PreValidationCommand(PreValidation preValidation) {
        this.preValidation = preValidation;
    }

    @Override
    public void execute() {
        preValidation.performValidationChecks();
    }
}
