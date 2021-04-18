import {loadStripe} from "@stripe/stripe-js/pure";
import {Elements} from "@stripe/react-stripe-js";
const Payments = ()=>{



    const stripePromise = loadStripe('pk_test_51If5WfAvUyzs1dkXpkhk42bXYE3me2VhD5Uc0ci5vzfqFwhrCNj32DXov52eVAGht6QrcdHYsl75wEJApOOlskWr00iQaXel5K');

    return (
        <Elements stripe={stripePromise}>
            {/*<MyCheckoutForm />*/}
        </Elements>
    );

}
export default Payments