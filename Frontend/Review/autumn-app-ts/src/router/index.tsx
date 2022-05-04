import React, {Suspense} from 'react';

import {BrowserRouter, Switch, Route} from 'react-router-dom'
import ClassView from '../views/ClassView'
import FunctionView from "../views/FunctionView";
import Sega from '../views/Sega'

const ProtalView = React.lazy(() => import("../views/ProtalView"))
const GraphqlView = React.lazy(() => import("../views/GraphqlView"))

const IndexRouter = () => {
    return (
        <BrowserRouter>
            <Switch>
                <Suspense fallback={<div>Loading...</div>}>
                    <Route path="/class" component={ClassView} exact={true}/>
                    <Route path="/func" component={FunctionView}/>
                    <Route path="/sega" component={Sega}/>
                    <Route path="/protal" component={ProtalView}></Route>
                    <Route path="/graphql" component={GraphqlView}></Route>
                </Suspense>
            </Switch>
        </BrowserRouter>
    );
};

export default IndexRouter;
