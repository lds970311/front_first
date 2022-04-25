import React from 'react';
import {BrowserRouter, Redirect, Route, Switch} from "react-router-dom"
import Swither from "../components/Swither";
import Detail from "../Detail";


const IndexRouter = () => {
    return (
        <BrowserRouter>
            <Switch>
                {/*<Redirect from="/" to="/swither"/>*/}
                <Route path="/swither" component={Swither} exact={true}/>
                <Route path="/detail/:id" component={Detail} exact={true}/>
            </Switch>
        </BrowserRouter>
    );
};

export default IndexRouter;
