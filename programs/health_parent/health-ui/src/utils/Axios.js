import axios from "axios";

const service = axios.create({
  baseURL: "http://localhost:9082/backend"
})

export default service

