//CREATE AT: 2021-12-18
import * as path from 'path';
import {BuildConfig} from "../src/@types/configure.types";
import flow from 'rollup-plugin-flow-no-whitespace'
import alias from 'rollup-plugin-alias'
import res from 'rollup-plugin-node-resolve';
import commonjs from 'rollup-plugin-commonjs';

const version = process.env.VERSION || require('../package.json').version
const aliases = require("./alias")

function resolve(p: string) {
    const base = p.split('/')[0]
    if (aliases[base]) {
        return path.resolve(aliases[base], p.slice(base.length + 1))
    } else {
        return path.resolve(__dirname, '../', p)
    }
}

const banner =
    '/*!\n' +
    ` * Vue.js v${version}\n` +
    ` * (c) 2018-${new Date().getFullYear()} Evan Lee\n` +
    ' * Released under the MIT License.\n' +
    ' */'

const builds = {
    'web-full-dev': {
        entry: resolve('web/entry-runtime-with-compiler.ts'),
        dest: resolve('dist/vue.js'),
        format: 'umd',
    },
    'web-runtime-dev': {
        entry: resolve('web/entry-runtime.ts'),
        dest: resolve('dist/vue.runtime.js'),
        format: 'umd',
        env: 'development',
        banner
    },
}

function getConfig(name: string) {
    const opts: BuildConfig = builds[name]
    const conf = {
        input: opts.entry,
        plugins: [
            flow(),
            res(),
            commonjs(),
            alias(Object.assign({}, aliases, opts.alias))
        ].concat(opts.plugins || []),
        output: {
            file: opts.dest,
            format: opts.format,
            banner: opts.banner || '',
            name: opts.moduleName || 'Vue'
        },
    }
    return conf
}

exports.getAllBuilds = () => {
    return Object.keys(builds).map(conf => {
        return getConfig(conf)
    })
}
