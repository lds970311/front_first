import React from 'react';
import {Redirect} from 'umi'

const Auth = (props) => {
  if (!localStorage.getItem("token")) {
    return (
      <div>
        {props.children}
      </div>
    );
  }
  return (
    <Redirect to="/login"/>
  )
};

export default Auth;
