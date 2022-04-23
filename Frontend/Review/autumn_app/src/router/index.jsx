import React from 'react';
import {BrowserRouter, Redirect, Route, Switch} from "react-router-dom"
import Swither from "../components/Swither";


const IndexRouter = () => {
    return (
        <BrowserRouter>
            <Switch>
                {/*<Redirect from="/" to="/swither"/>*/}
                <Route path="/swither" component={Swither} exact={true}/>
            </Switch>
        </BrowserRouter>
    );
};

export default IndexRouter;
