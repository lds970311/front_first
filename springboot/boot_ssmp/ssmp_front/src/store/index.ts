import {createPinia} from 'pinia'
import piniaPluginPersist from 'pinia-plugin-persist' //引入持久化插件
const store = createPinia()
store.use(piniaPluginPersist)

export default store
