//CREATE AT: 2021-12-26
import * as path from 'path';
import webpack from "webpack";
import {merge} from "webpack-merge"
import HtmlWebpackPlugin from "html-webpack-plugin"
import baseConfig from "./wepack.base";


const devConfig: webpack.Configuration = {
    mode: "development",
    // @ts-ignore
    devServer: {
        compress: true,
        allowedHosts: 'all',
        open: true,
        port: 13288,
    },
    plugins: [
        new webpack.HotModuleReplacementPlugin(),
        new HtmlWebpackPlugin({
            inject: 'body',
            title: "react app",
            filename: 'index.html',
            hot: true,
            template: path.resolve(__dirname, "../index.html")
        }),
    ]
}

export default merge(devConfig, baseConfig)
