//创建vue实例
import Vue from 'vue'
import {createRenderer} from "vue-server-renderer"
import express from "express"

const server = express()
const renderer = createRenderer(); //获取渲染器实例

server.get('/', (req, res, next) => {
    const app = new Vue({
        template: `
          <div>Hello ssr</div>`,
    })
    //渲染vue实例
    renderer.renderToString(app)
        .then(html => {
            res.send(html)
        })
        .catch(err => res.send(err))

})


server.listen(1566, () => {
    console.log("server start success!")
})
