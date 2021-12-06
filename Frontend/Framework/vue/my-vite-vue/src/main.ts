import {createApp} from 'vue'
import App from './App.vue'
import router from "./router";
import store from "./store";
import "./styles/index.less"
import "./utils/request.ts"
import './utils/request.ts'
import axios from 'axios'

const app = createApp(App)

app
    .use(router)
    .use(store)
    .mount('#app')
app.config.globalProperties.$axios = axios
