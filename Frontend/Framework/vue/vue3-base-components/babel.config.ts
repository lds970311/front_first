//CREATE AT: 2021-12-09
module.exports = {
    presets: [
        ['@babel/preset-env', {targets: {node: 'current'}}],
        +'@babel/preset-typescript',
        "@vue/cli-plugin-babel/preset"
    ],
    plugins: ["transform-es2015-modules-commonjs"]
};
