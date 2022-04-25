import axios from "axios";

export default function getDetailAction(id) {
    return dispatch => {
        axios.get(`/asgard/asgardapi/review/realtime/data.json?movieId=${id}`)
            .then(res => {
                console.log(res)
                dispatch({
                    type: "getDetail",
                    payload: res.data
                })
            })
    }
}
