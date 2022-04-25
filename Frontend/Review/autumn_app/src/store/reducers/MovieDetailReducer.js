import _ from 'lodash';

const initialState = {
    snum: 0,
    watched: 0,
    wish: 0
}

const movieDetailReducer = (state = initialState, {type, payload}) => {
    const newState = _.cloneDeep(state);

    switch (type) {
        case "enter":
            return payload
        case "getDetail":
            return payload
        default:
            return state
    }
}

export default movieDetailReducer
