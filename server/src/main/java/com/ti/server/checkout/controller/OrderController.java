package com.ti.server.checkout.controller;

import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.net.HttpHeaders;
import com.stripe.net.StripeResponse;
import com.ti.server.checkout.OrderService;
import com.ti.server.checkout.dto.CheckoutItemDTO;
import com.ti.server.checkout.dto.StripeRespons;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create-checkout-session")
    public ResponseEntity<StripeRespons> checkoutList(@RequestBody List<CheckoutItemDTO> checkoutItemDtoList) throws StripeException {
        Session session = orderService.createSession(checkoutItemDtoList);
        StripeRespons stripeResponse = new StripeRespons(session.getId());
        return new ResponseEntity<StripeRespons>(stripeResponse,HttpStatus.OK);
    }

}
