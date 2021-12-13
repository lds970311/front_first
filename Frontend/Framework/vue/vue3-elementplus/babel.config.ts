//CREATE AT: 2021-12-12
module.exports = {
    presets: [
        ['@babel/preset-env', {targets: {node: 'current'}}],
        +'@babel/preset-typescript',
        "@vue/cli-plugin-babel/preset"
    ],
    plugins: ["transform-es2015-modules-commonjs"]
};
