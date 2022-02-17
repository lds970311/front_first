import axios from "axios"

const service = axios.create({
    baseURL: "http://192.168.125.5:8901/boot_ssmp",
    timeout: 5000
})

export default service
