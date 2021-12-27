//CREATE AT: 2021-12-26
import * as path from 'path';
import webpack from "webpack";
import {merge} from "webpack-merge"
import HtmlWebpackPlugin from "html-webpack-plugin"
import baseConfig from "./wepack.base";

const OpenBrowserPlugin = require('open-browser-webpack4-plugin');


const devConfig: webpack.Configuration = {
    mode: "development",
    // @ts-ignore
    devServer: {
        allowedHosts: 'all',
        open: false,
        port: 13288,
        historyApiFallback: false,
    },
    plugins: [
        new webpack.HotModuleReplacementPlugin(),
        new HtmlWebpackPlugin({
            title: "react app",
            filename: 'index.html',
            template: path.resolve(__dirname, "../index.html")
        }),
    ]
}

export default merge(baseConfig, devConfig)
