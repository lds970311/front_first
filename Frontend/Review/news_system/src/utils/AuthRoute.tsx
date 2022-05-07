import React from 'react';
import Redirect from "./Redirect";

interface Props {
    children: JSX.Element;
}

const AuthRoute: React.FunctionComponent<Props> = (props) => {
    const children: JSX.Element = props.children;
    const token = localStorage.getItem("token")
    if (token) {
        return children
    }

    return <Redirect to="/login"/>
};

export default AuthRoute;
