let Vue

class MyStore {
    constructor(options) {
        this.state = new Vue({
            data: options.state
        })
        this.mutations = options.mutations
        this.actions = options.actions
        this.commit = this.commit.bind(this)
        this.dispatch = this.dispatch.bind(this)
    }

    commit(type, payload) {
        const func = this.mutations[type];
        console.log("123")
        if (func) {
            func(this.state, payload)
        }
    }

    dispatch(type, payload) {
        const func = this.actions[type]
        if (func) {
            func(this, payload)
        }
    }
}

function install(MyVue) {
    Vue = MyVue

    Vue.mixin({
        beforeCreate() {
            if (this.$options.store) {
                Vue.prototype.$store = this.$options.store
            }
        }
    })
}

export default {
    MyStore,
    install
}
