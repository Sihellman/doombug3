import {Route, Switch} from "react-router-dom";
import Login from "./components/LoginPage";
import SignUp from "./components/SignUp";
import EditAccount from "./components/EditAccount";
import Payments from "./components/Payments"
export const Routes = (props) => {
    return (

        <Switch>

            <Route exact path='/' component={() => <Login setUser={props.setUser}
                                                          setToggleLogInSignUp={props.setToggleLogInSignUp}
                                                          toggleLogInSignUp={props.toggleLogInSignUp}
            />}/>

            <Route path="/sign-in" component={() => <Login setUser={props.setUser}
                                                           setToggleLogInSignUp={props.setToggleLogInSignUp}
                                                           toggleLogInSignUp={props.toggleLogInSignUp}
            />}/>

            <Route path="/sign-up" component={() => <SignUp setUser={props.setUser}
                                                            setToggleLogInSignUp={props.setToggleLogInSignUp}
                                                            toggleLogInSignUp={props.toggleLogInSignUp}
            />}/>

            <Route path="/edit-account" component={() => <EditAccount setUser={props.setUser} user={props.user}/>}/>
    <Route path="/payments" component={()=><Payments/>}/>}
        </Switch>
    )
};