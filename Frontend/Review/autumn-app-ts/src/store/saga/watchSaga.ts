import axios from 'axios';
import {take, fork, call, put, all} from 'redux-saga/effects'


function* watchSaga() {
    while (true) {
        //take监听发来的action,
        yield take('a')
        // fork同步执行异步处理函数
        yield fork(getList)
    }
}

function* getList() {
    const res = yield call(getDataList)
    yield put({
        type: "list",
        payload: res
    })
}

function getDataList() {
    return new Promise((resolve, reject) => {
        axios({
            url: "https://i.maoyan.com/ajax/moreComingList?token=&movieIds=1324722,1355569,1338984,1357983,341955,1336452,1433696,1446115,1302341,1299976&optimus_uuid=B7186F20C34E11EC9556B19FB19558B18CD577F033F9463AB27E5C36DE9F8B77&optimus_risk_level=71&optimus_code=10",
            method: 'GET'
        }).then(res => {
            console.log(res)
            resolve(res)
        }).catch(err => reject(err))
    })
}

function* watch() {
    yield all([watchSaga()])
}

export default watch
