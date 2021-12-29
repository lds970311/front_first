import Vue from "vue";
import MyVuex from "@/MyStore/MyVuex";

Vue.use(MyVuex)

const store = new MyVuex.MyStore({
    state: {
        count: 100
    },
    actions: {
        getAdd({commit}, payload) {
            setTimeout(() => {
                commit("add", payload)
            }, 500)
        }
    },
    mutations: {
        add(state, payload) {
            state.count += payload;
        }
    },
    getters: {},
    modules: {}
})

export default store;
