package com.ti.server.checkout.controller;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import com.stripe.model.checkout.Session;
import com.stripe.param.*;
import com.stripe.param.checkout.SessionCreateParams;
import com.ti.server.checkout.dto.CheckoutItemDTO;
import com.ti.server.checkout.dto.CustomerItemDTO;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Builder
@Data
public class CustomerService {






    public Customer createCustome() throws StripeException{
        Stripe.apiKey = "sk_test_51If5WfAvUyzs1dkX4OidydSPFFj4acLAx3zgZ3l2qKy08P0cHuGG5zuhuPL4rOv9mkZAnhgSyogqX2C8hHX5gZ4Q00dLcKGpqB";
        CustomerCreateParams params =
                CustomerCreateParams.builder()
                        .setEmail("jenny.rosen@example.com")


                        .build();

        Customer customer = Customer.create(params);
        return customer;
    }
    public void addCard(CustomerItemDTO id) throws StripeException{
        Stripe.apiKey = "sk_test_51If5WfAvUyzs1dkX4OidydSPFFj4acLAx3zgZ3l2qKy08P0cHuGG5zuhuPL4rOv9mkZAnhgSyogqX2C8hHX5gZ4Q00dLcKGpqB";
        Map<String, Object> cardParam = new HashMap<String, Object>();
        cardParam.put("number", "4242424242424242");
        cardParam.put("exp_month", "11");
        cardParam.put("exp_year", "2022");
        cardParam.put("cvc", "123");
        Map <String, Object> tokenParam = new HashMap<>();
        tokenParam.put("card", cardParam);
        Token token = Token.create(tokenParam);
        Map <String, Object> source = new HashMap<>();
        source.put("source", token.getId());

        PaymentSourceCollection paymentSourceCollection = new PaymentSourceCollection();
        paymentSourceCollection.setObject(token.getId());

        CustomerRetrieveParams retrieveParams =
                CustomerRetrieveParams.builder()
                        .addExpand("sources")
                        .build();
         Customer customer = Customer.retrieve(id.getUserId(), retrieveParams, null);
        System.out.println(customer);
//        PaymentMethod paymentMethod = new PaymentMethod();


//        PaymentMethodAttachParams params =
//                PaymentMethodAttachParams.builder()
//                        .setCustomer(id.getUserId())
//                        .build();
//
//        paymentMethod.attach(params);
        CustomerUpdateParams params =
                CustomerUpdateParams.builder()
                        .setSource("tok_visa")
                        .setEmail("s@gmail.com")

                        .build();

        customer.update(params);


    }
    public void pay() throws StripeException{
        Stripe.apiKey = "sk_test_51If5WfAvUyzs1dkX4OidydSPFFj4acLAx3zgZ3l2qKy08P0cHuGG5zuhuPL4rOv9mkZAnhgSyogqX2C8hHX5gZ4Q00dLcKGpqB";

        PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                .setCurrency("usd")
                .setCustomer("cus_JJBofg5MByJqjR")
                .setAmount(2000000L)
                .setPaymentMethod(
                        "card_1Ihc8kAvUyzs1dkXl5Gr8q70")
                .setConfirm(true)
.addPaymentMethodType("card")

                .build();
        // Create a PaymentIntent with the order amount and currency
        PaymentIntent intent = PaymentIntent.create(createParams);
    }


}
