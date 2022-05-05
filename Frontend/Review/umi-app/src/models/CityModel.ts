export default {
  state: {
    cityName: "北京",
    cityId: "110100"
  },
  reducers: {
    changeCity(preState, {type, payload}) {
      console.log(type)
      console.log(payload)
      return {
        ...preState,
        ...payload
      }
    }
  }
}
