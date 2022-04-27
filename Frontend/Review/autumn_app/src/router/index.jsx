import React from 'react';
import {BrowserRouter, Redirect, Route, Switch} from "react-router-dom"
import Swither from "../components/Swither";
import Detail from "../components/Film/Detail";
import Ant from "../components/Ant";
import MobxComp from "../views/MobxComp";


const IndexRouter = () => {
    return (
        <BrowserRouter>
            <Switch>
                {/*<Redirect from="/" to="/swither"/>*/}
                <Route path="/swither" component={Swither} exact={true}/>
                <Route path="/detail/:id" component={Detail} exact={true}/>
                <Route path="/ant" component={Ant} exact={true}/>/>
                <Route path="/mobx" component={MobxComp} exact={true}/>/>
            </Switch>
        </BrowserRouter>
    );
};

export default IndexRouter;
