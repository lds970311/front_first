import {createApp} from 'vue'
import App from './App.vue'
import "./styles/index.less"
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as Icons from "@element-plus/icons-vue"
import service from "./utils/request"
import components from "./components";

const app = createApp(App)
//注册全局图标
for (const icon in Icons) {
    app.component(icon, Icons[icon])
}
//注册service
app.config.globalProperties.$axios = service

app.use(router)
    .use(store)
    .use(ElementPlus)
    .use(components) //全局注册自定义的组件
    .mount('#app')
