//CREATE AT: 2021-12-13


const containerOptions = {
    namespaced: true,
    state: {
        isCollapse: false
    },
    mutations: {
        changeCollapse(state) {
            state.isCollapse = !state.isCollapse;
        }
    }
}

export default containerOptions
