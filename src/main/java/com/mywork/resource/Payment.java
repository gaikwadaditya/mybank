package com.mywork;

import com.mywork.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.mywork.service.Domestic1OffPaymentService;
import com.mywork.service.Domestic1OffPaymentServiceImpl;

/**
 * Root resource (exposed at "payment" path)
 */
@Path("payment")
public class Payment {

    /**
     * Method to query status of Domestic1OffPaymentRequest
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @return Domestic1OffPaymentRequest response.
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/domestic-payments/{DomesticPaymentId}")
    public Domestic1OffPaymentRequest getDomestic1OffPaymentRequestStatus (@PathParam("DomesticPaymentId") String domesticPaymentId) {
        //Compile time Dependency Injection library like Dagger can be used.
        Domestic1OffPaymentService domestic1OffPaymentService = new Domestic1OffPaymentServiceImpl();
        return domestic1OffPaymentService.getDomestic1OffPaymentRequest(domesticPaymentId);
    }

    /**
     * Method to process Domestic1OffPaymentRequest
     *
     * @return Domestic1OffPaymentRequest response.
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/domestic1OffPayment")
    public Domestic1OffPaymentRequest processDomestic1OffPayment (Domestic1OffPaymentRequest domestic1OffPaymentRequest) {

        //Compile time Dependency Injection library like Dagger can be used.
        Domestic1OffPaymentService domestic1OffPaymentService = new Domestic1OffPaymentServiceImpl();

        return domestic1OffPaymentService.processDomestic1OffPaymentRequest(domestic1OffPaymentRequest);
    }

}
