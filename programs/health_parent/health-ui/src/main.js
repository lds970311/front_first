// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import "./assets/font-awesome/css/font-awesome.min.css"
import "./styles/index.css"
import 'element-ui/lib/theme-chalk/index.css'
import store from "./store/index"
import service from "./utils/Axios";


Vue.config.productionTip = false
Vue.use(ElementUI)

window.axios = service

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: {App},
  template: '<App/>'
})
