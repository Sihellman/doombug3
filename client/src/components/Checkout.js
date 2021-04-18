import React, {Component} from "react";
import {Button, Col, Form, FormGroup, Input, Label} from 'reactstrap';
import {post} from "../helper/Fetch";
import {Alert} from 'reactstrap';
import {loadStripe} from "@stripe/stripe-js/pure";
const stripePromise = loadStripe('pk_test_51If5WfAvUyzs1dkXpkhk42bXYE3me2VhD5Uc0ci5vzfqFwhrCNj32DXov52eVAGht6QrcdHYsl75wEJApOOlskWr00iQaXel5K');

export default class Checkout extends Component {


    handleClick = async (event) => {
        // Get Stripe.js instance
        const stripe = await stripePromise;

        // Call your backend to create the Checkout Session
        const response = await fetch('/create-checkout-session', { method: 'POST' });

        const session = await response.json();

        // When the customer clicks on the button, redirect them to Checkout.
        const result = await stripe.redirectToCheckout({
            sessionId: session.id,
        });

        if (result.error) {
            // If `redirectToCheckout` fails due to a browser or network
            // error, display the localized error message to your customer
            // using `result.error.message`.
        }
    };


    render() {

        return (
            <button onClick={()=>this.handleClick()} role="link">
                Checkout
            </button>


        )
    }
}