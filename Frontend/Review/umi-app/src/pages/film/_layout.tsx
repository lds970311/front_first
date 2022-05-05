import React from 'react';
import {Redirect} from 'umi'

const Film = (props) => {
  return (
    <div>
      <div style={{height: '200px', background: "yellow"}}>大轮播</div>
      {props.children}
      <Redirect from='/film' to='/film/comingsoon'/>
    </div>
  )
};

export default Film;


