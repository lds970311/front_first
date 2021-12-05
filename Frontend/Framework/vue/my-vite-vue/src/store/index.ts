//CREATE AT: 2021-12-05
import {createStore} from "vuex";

const store = createStore({
    state: {
        msg: "vuex"
    },
    mutations: {
        change(state) {
            state.msg = "new vuex"
        }
    },
    actions: {
        changeMsg(ctx) {
            ctx.commit("change")
        }
    },
    getters: {
        getMsg(state) {
            return state.msg
        }
    },
    modules: {}
})

export default store
