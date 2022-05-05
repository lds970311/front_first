import React from 'react';
import {NavLink} from 'umi'
import style from './index.less'
import {IRouteProps} from 'umi'

interface Props {
  children: React.ReactNode
}

type IProps = Props & IRouteProps

const IndexLayouts: React.FunctionComponent = (props: IProps) => {
  const path = props.location.pathname
  if (path === "/city" || path.includes("/detail") || path === '/cinema') {
    return <div>{props.children}</div>
  }

  return (
    <div>
      <ul>
        <li><NavLink to="/film" activeClassName={style.active}>film</NavLink></li>
        <li><NavLink to="/cinema" activeClassName={style.active}>cinema</NavLink></li>
        <li><NavLink to="/center" activeClassName={style.active}>center</NavLink></li>
      </ul>
      {props.children}
    </div>

  );
};

export default IndexLayouts;
