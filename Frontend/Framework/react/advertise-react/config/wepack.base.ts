//CREATE AT: 2021-12-26
import * as path from 'path';
import webpack from "webpack";

const baseConfig: webpack.Configuration = {
    entry: path.resolve(__dirname, "../src/main.tsx"),
    output: {
        path: path.resolve(__dirname, "../dist"),
        filename: '[name].bundle.js',
        clean: true
    },
    resolve: {
        extensions: ['.js', '.ts', '.tsx', '.jsx']
    },
    module: {
        rules: [
            {
                test: /\.jsx?$/,
                use: 'babel-loader',
                exclude: /node_modules/
            },
            {
                test: /\.tsx?$/,
                include: path.resolve(__dirname, '../src'),
                use: [
                    {
                        loader: 'ts-loader',
                        options: {
                            transpileOnly: true,
                            happyPackMode: true,
                        },
                    },
                ],
            },
            {
                test: /\.(sc|c)ss$/i,
                use: ['style-loader', 'css-loader', 'sass-loader']
            },
        ]
    }
}
export default baseConfig
