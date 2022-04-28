import {observable, configure, action, runInAction} from 'mobx'
import {getData} from "../utils/Data"


configure({
    enforceActions: 'never'
})


class MyMobx {
    @observable num = 1
    @observable name = 'evan'
    @observable list = []

    @action changeNum = () => {
        console.log("a")
        this.num = 10
        console.log(this.num)
    }

    @action changeName = () => {
        console.log("b")
        this.name = 'lisi'
    }

    @action getDataList = async () => {
        console.log("c")
        const data = await getData()
        //runInAction解决异步
        runInAction(() => {
            this.list = data
        })
    }
}

const myMobx = new MyMobx()

export default myMobx
