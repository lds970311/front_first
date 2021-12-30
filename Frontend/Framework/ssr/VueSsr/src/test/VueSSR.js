//创建vue实例
const Vue = require('vue');
const {createRenderer} = require("vue-server-renderer")
const express = require("express")
const Home = require("Home.vue")

const server = express()
const renderer = createRenderer(); //获取渲染器实例

server.get('/', (req, res, next) => {
    const app = new Vue({
        template: `
          <div>Hello ssr</div>`,
        render(h) {
            return h(Home)
        }
    })

    //渲染vue实例
    renderer.renderToString(app)
        .then(html => {
            res.send(html)
        })
        .catch(err => res.send(err))

})


server.listen(1566, () => {
    console.log("server start success! ,port 1556")
})
