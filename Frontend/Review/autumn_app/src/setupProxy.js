const {createProxyMiddleware} = require("http-proxy-middleware");

module.exports = function (app) {
    app.use(
        "/ajax", // /api/list /api/detail /api/center /api/cart
        createProxyMiddleware({
            target: "https://i.maoyan.com",
            changeOrigin: true,
        })
    );

    app.use(
        "/asgard",
        createProxyMiddleware({
            target: "https://i.maoyan.com",
            changeOrigin: true,
        })
    )
}
