import React, {useEffect} from 'react';
import {NavBar} from 'antd-mobile'
import {SearchOutline} from 'antd-mobile-icons'
import {connect} from 'dva'

const Cinema = (props: any) => {
  useEffect(() => {
    console.log(props.cinemaModel.cinemaList)
    if (props.cinemaModel.cinemaList.length === 0) {
      props.dispatch({
        type: 'cinemaModel/getList',
        payload: {
          cityId: props.CityModel.cityId
        }
      })
    } else {
      //缓存
      console.log('cache')
    }
  }, [])

  return (
    <div>
      <NavBar onBack={() => {
      }} back={props.CityModel.cityName} backArrow={false} right={<SearchOutline/>}>标题</NavBar>
      Cinema
    </div>
  );
};

Cinema.wrappers = ['@/wrappers/auth']
export default connect(state => {
  // @ts-ignore
  return state
})(Cinema);
