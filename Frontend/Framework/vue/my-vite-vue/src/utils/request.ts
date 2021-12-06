//CREATE AT: 2021-12-05
import axios from "axios"

const service = axios.create({
    baseURL: '/api',
    timeout: 3000
})
export default service
