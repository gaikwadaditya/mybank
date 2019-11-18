package com.mywork;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mywork.Model.*;
import org.glassfish.grizzly.http.server.HttpServer;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PaymentTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newBuilder().register(JacksonFeature.class).build();

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to trigger domestic money transfer.
     */
    @Test
    public void processDomestic1OffPaymentTest() {

        //Create a Debitor Account with 10 GBP balance

        //TODO Take input from JSON file so as data multiple sets of data sets can be prepared
        Account debitorAccount = createDebitorAccount();

        //Create a Creditor Account with 0 GBP balance
        Account creditorAccount = createCreditorAccount();

        InstructedAmount instructedAmount = new InstructedAmount();
        instructedAmount.setAmount("5");
        instructedAmount.setCurrency("GBP");

        //Verify Creditor balance, before money transfer is 0
        assertEquals(creditorAccount.getBalance(), "0");

        Domestic1OffPaymentRequest domestic1OffPaymentRequest = new Domestic1OffPaymentRequest(creditorAccount, debitorAccount, instructedAmount);

        //Invoke money transfer API with 5 GBP domestic1Off transfer & note down the payment Id
        Response response = target.path("payment").path("domestic1OffPayment").request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(domestic1OffPaymentRequest, MediaType.APPLICATION_JSON));

        System.out.println("Response Status: " + response.getStatus());

        assertEquals(response.getStatus(),200);
        //Domestic1OffPaymentRequest entity = (Domestic1OffPaymentRequest)response.getEntity();

        Domestic1OffPaymentRequest domestic1OffPaymentResponse = response.readEntity(Domestic1OffPaymentRequest.class);
        //Verify PaymentId should not be null
        assertNotNull("PaymentId should not be null", domestic1OffPaymentResponse.getPaymentId());

        //Verify if Payment Request Status is Pending
        assertEquals("Payment Status should be Pending", domestic1OffPaymentResponse.getStatusCode(),PaymentStatusCode.PENDING);

        //String domestic1OffPaymentResponse = response.readEntity(String.class);
        System.out.println(domestic1OffPaymentResponse);

        //Query the status of PaymentRequest with PaymentId, If payment state is AcceptedSettlementCompleted
        //that means transfer happened successfully. Verify Credtior and Debitor updated balance.
        String getURL = "payment/domestic-payments/" + domestic1OffPaymentResponse.getPaymentId();
        Domestic1OffPaymentRequest responseMsg = target.path(getURL).request().get(Domestic1OffPaymentRequest.class);
        System.out.println("responseMsg: " + responseMsg);

    }

    private Account createCreditorAccount() {
        Account creditorAccount =  new Account();
        creditorAccount.setSchemeName("UK.OBIE.SortCodeAccountNumber");
        creditorAccount.setIdentification("08080021325698");
        creditorAccount.setName("Bob Clements");
        creditorAccount.setAccountType(AccountType.PERSONAL);
        creditorAccount.setAccountSubType(AccountSubType.CURRENTACCOUNT);
        creditorAccount.setCurrency("GBP");
        creditorAccount.setBalance("0");
        return creditorAccount;
    }

    private Account createDebitorAccount() {
        Account debitorAccount =  new Account();
        debitorAccount.setSchemeName("UK.OBIE.SortCodeAccountNumber");
        debitorAccount.setIdentification("11280001234567");
        debitorAccount.setName("Andrea Smith");
        debitorAccount.setAccountType(AccountType.PERSONAL);
        debitorAccount.setAccountSubType(AccountSubType.CURRENTACCOUNT);
        debitorAccount.setCurrency("GBP");
        debitorAccount.setBalance("10");
        return debitorAccount;
    }

}
