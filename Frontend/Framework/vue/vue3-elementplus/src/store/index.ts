//CREATE AT: 2021-12-12
import {createStore} from "vuex";
import containerOptions from "./modules/containerOptions";

const store = createStore({
    strict: true,
    state: {
        homeTitle: "Home111"
    },
    actions: {},
    mutations: {},
    getters: {},
    modules: {
        containerOptions
    }
})

export default store
