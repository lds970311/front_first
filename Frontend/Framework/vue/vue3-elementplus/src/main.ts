import {createApp} from 'vue'
import App from './App.vue'
import "./styles/index.less"
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as Icons from "@element-plus/icons-vue"

const app = createApp(App)
//注册全局图标
for (const icon in Icons) {
    app.component(icon, Icons[icon])
}


app.use(router)
    .use(store)
    .use(ElementPlus)
    .mount('#app')
