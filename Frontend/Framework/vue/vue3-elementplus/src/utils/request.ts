//CREATE AT: 2021-12-14
import axios from "axios"

const service = axios.create({
    baseURL: "https://mock.mengxuegu.com/mock/61b792d5ca09cb42105adf8b/citydata",
    timeout: 5000
})

export default service
