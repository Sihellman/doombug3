package com.ti.server.checkout.controller;

import com.stripe.exception.StripeException;
import com.ti.server.checkout.dto.CustomerItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Object> customerList() throws StripeException {
        customerService.createCustome();

        return new ResponseEntity<Object>("yahoo", HttpStatus.OK);
    }
    @PostMapping("/add")
    public void addCard(@RequestBody CustomerItemDTO id) throws StripeException {
        customerService.addCard(id);


    }
    @PostMapping("/pay")
    public void pay() throws StripeException{
        customerService.pay();
    }

}
