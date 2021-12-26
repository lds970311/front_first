//CREATE AT: 2021-12-26
import * as path from 'path';
import webpack from "webpack";
import {merge} from "webpack-merge"
import HtmlWebpackPlugin from "html-webpack-plugin"
import baseConfig from "./wepack.base";
import {CleanWebpackPlugin} from "clean-webpack-plugin"


const prodConfig: webpack.Configuration = {
    mode: "production",
    // @ts-ignore

    plugins: [
        new webpack.HotModuleReplacementPlugin(),
        new CleanWebpackPlugin({
            protectWebpackAssets: true
        }),
        new HtmlWebpackPlugin({
            inject: 'body',
            title: "react app",
            filename: 'index.html',
            hot: true,
            template: path.resolve(__dirname, "../index.html")
        }),
    ]
}

export default merge(baseConfig, prodConfig)
