import {createApp} from 'vue'
import App from './App.vue'
import store from './store'
import router from './router'
import "./styles/index.less"
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

createApp(App)
    .use(store)
    .use(router)
    .use(ElementPlus)
    .mount('#app')
