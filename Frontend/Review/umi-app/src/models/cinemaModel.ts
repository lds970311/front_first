async function getDataList(cityId) {
  const res = await fetch(`https://m.maizuo.com/gateway?cityId=${cityId}&ticketFlag=1&k=6412143`, {
    headers: {
      'X-Client-Info': '{"a":"3000","ch":"1002","v":"5.2.0","e":"16395416565231270166529"}',
      'X-Host': 'mall.film-ticket.cinema.list'
    }
  }).then(res => res.json())

  return res.data.cinemas
}

export default {
  state: {
    cinemaList: []
  },
  reducers: {
    changeList(prevState, action) {
      return {
        ...prevState,
        cinemaList: action.payload
      }
    }
  },
  effects: {
    * getList(action, {call, put}) {
      console.log(action)
      const res = yield call(getDataList(action.payload.cityId))
      console.log(res)
      yield put({
        type: 'changeList',
        payload: res
      })
    }
  }
}
