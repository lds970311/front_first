import React from 'react';

import {BrowserRouter, Switch, Route} from 'react-router-dom'
import ClassView from '../views/ClassView'
import FunctionView from "../views/FunctionView";
import Sega from '../views/Sega'

const IndexRouter = () => {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/class" component={ClassView} exact={true}/>
                <Route path="/func" component={FunctionView}/>
                <Route path="/sega" component={Sega}/>
            </Switch>
        </BrowserRouter>
    );
};

export default IndexRouter;
