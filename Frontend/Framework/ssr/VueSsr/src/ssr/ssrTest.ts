//创建vue实例
import Vue from 'vue'
import {createRenderer} from "vue-server-renderer"

const app = new Vue({
    template: `<div>Hello ssr</div>`
})
const renderer = createRenderer(); //获取渲染器实例
//渲染vue实例
renderer.renderToString(app)
    .then(html => console.log(html))
    .catch(err => console.error(err))

