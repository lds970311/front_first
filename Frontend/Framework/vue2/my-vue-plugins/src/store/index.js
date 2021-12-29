import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex)

const store = new Vuex.Store({
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
