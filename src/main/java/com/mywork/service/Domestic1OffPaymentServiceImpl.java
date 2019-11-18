package com.mywork.service;

import com.fasterxml.uuid.Generators;
import com.mywork.business.*;
import com.mywork.model.Domestic1OffPaymentRequest;
import com.mywork.model.PaymentStatusCode;

import java.util.*;

public class Domestic1OffPaymentServiceImpl implements Domestic1OffPaymentService {

    //Only for demo purpose, in real life scenario data would be fetch from backend data-store
    private static Map<String, Domestic1OffPaymentRequest> transactions = new HashMap<String, Domestic1OffPaymentRequest>();

    public Domestic1OffPaymentRequest processDomestic1OffPaymentRequest(Domestic1OffPaymentRequest domestic1OffPaymentRequest) {

        Domestic1OffPaymentComandProcessor domestic1OffPaymentComandProcessor = new Domestic1OffPaymentComandProcessor();

        PreValidationCommand preValidationCommand = new PreValidationCommand(new PreValidation(domestic1OffPaymentRequest));
        FraudCheckCommand fraudCheckCommand = new FraudCheckCommand(new FraudCheck(domestic1OffPaymentRequest));

        //All the applicable command can be externalised & configured & loaded dynamically.
        ArrayList<Command> preCheckCommands = new ArrayList<>();
        preCheckCommands.add(preValidationCommand);
        preCheckCommands.add(fraudCheckCommand);

        runCommands(preCheckCommands, domestic1OffPaymentComandProcessor);

        //Submit request to payment Gateway OR
        //in case of Me 2 Me Domestic transfer, execute logic in thread synchronized block and return

        TransactionLoggingCommand transactionLoggingCommand = new TransactionLoggingCommand(new TransactionLogging(domestic1OffPaymentRequest));
        MILoggingCommand miLoggingCommand = new MILoggingCommand(new MILogging(domestic1OffPaymentRequest));
        AuditLoggingCommand auditLoggingCommand = new AuditLoggingCommand(new AuditLogging(domestic1OffPaymentRequest));

        ArrayList<Command> postTransferCommands = new ArrayList<>();
        postTransferCommands.add(miLoggingCommand);
        postTransferCommands.add(fraudCheckCommand);
        postTransferCommands.add(auditLoggingCommand);

        runCommands(postTransferCommands, domestic1OffPaymentComandProcessor);

        UUID uuid1 = Generators.timeBasedGenerator().generate();
        domestic1OffPaymentRequest.setPaymentId(uuid1.toString());
        domestic1OffPaymentRequest.setStatusCode(PaymentStatusCode.PENDING);

        transactions.put(domestic1OffPaymentRequest.getPaymentId(), domestic1OffPaymentRequest);

        return domestic1OffPaymentRequest;
    }

    @Override
    public Domestic1OffPaymentRequest getDomestic1OffPaymentRequest(String paymentId) {
        return transactions.get(paymentId);
    }

    private void runCommands(List<Command> commands, Domestic1OffPaymentComandProcessor domestic1OffPaymentComandProcessor) {
        for (Command command: commands) {
            domestic1OffPaymentComandProcessor.setCommand(command);
            domestic1OffPaymentComandProcessor.process();
        }
    }

}
