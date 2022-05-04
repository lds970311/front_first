export default {
  namespace: 'film',

  state: {
    isShow: true
  },
  reducers: {
    hide(state, action) {
      return {...state, isShow: false};
    },
    show(state, action) {
      return {...state, isShow: true};
    },
  },
  subscriptions: {
    setup({dispatch, history}) {  // eslint-disable-line
    },
  },

  effects: {
    * fetch({payload}, {call, put}) {  // eslint-disable-line
      yield put({type: 'save'});
    },
  },
}
