//CREATE AT: 2021-12-18
const builds = require("./config").getAllBuilds()
import * as rollup from "rollup";
import fs from "fs";
import {relative, resolve} from "path"
import terser from "terser";

const distPath = resolve(__dirname, "../dist")
if (!fs.existsSync(distPath)) {
    fs.mkdirSync(distPath)
}

function blue(str: string) {
    return '\x1b[1m\x1b[34m' + str + '\x1b[39m\x1b[22m'
}

function getSize(code: string) {
    return (code.length / 1024).toFixed(2) + 'kb'
}


function write(dest: string, code: any, zip?: boolean) {
    return new Promise<void>((resolve, reject) => {
        function report(extra?: string) {
            console.log(blue(relative(process.cwd(), dest)) + ' ' + getSize(code) + (extra || ''))
            resolve()
        }

        fs.writeFile(dest, code, err => {
            if (err) return reject(err)
            report()
            /*if (zip) {
                zlib.gzip(code, (err, zipped) => {
                    if (err) return reject(err)
                    report(' (gzipped: ' + getSize(zipped) + ')')
                })
            } else {
                report()
            }*/
        })
    })
}


function buildEntry(config) {
    const output = config.output
    const {file, banner} = output
    const isProd = /(min|prod)\.js$/.test(file)
    return rollup.rollup(config)
        .then(bundle => bundle.generate(output))
        .then(({output: [{code}]}) => {
            if (isProd) {
                const minified = (banner ? banner + '\n' : '') + terser.minify(code, {
                    toplevel: true,
                    output: {
                        ascii_only: true
                    },
                    compress: {
                        pure_funcs: ['makeMap']
                    }
                }).code
                return write(file, minified, true)
            } else {
                return write(file, code)
            }
        })
}


function build(buildConfig) {
    let built = 0
    const total = buildConfig.length
    const next = () => {
        buildEntry(buildConfig[built]).then(() => {
            built++
            if (built < total) {
                next()
            }
        }).catch(e => console.log(e))
    }

    next()
}

build(builds)
