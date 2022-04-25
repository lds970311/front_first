const createMyStore = (reducer) => {
    const list = []
    let currentState = reducer()

    function subscribe(cb) {
        list.push(cb)
    }

    function getState() {
        return currentState
    }

    function dispatch(action) {
        currentState = reducer(currentState, action)
        list.forEach(cb => {
            cb()
        })
    }


    return {
        subscribe,
        getState,
        dispatch
    }
}

export default createMyStore
