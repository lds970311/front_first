import Vue from 'vue'
import Router from 'vue-router'
import Main from "../pages/Main"
import Login from "../pages/Login";
import CheckItem from "../components/Reserve/CheckItem";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/Login',
      name: 'login',
      component: Login
    },
    {
      path: '/',
      name: 'Main',
      component: Main,
      children: [
        {
          path: '/checkItem',
          name: 'checkItem',
          component: CheckItem
        }
      ]
    }
  ]
})
