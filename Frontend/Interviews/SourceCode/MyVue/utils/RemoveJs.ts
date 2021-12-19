//CREATE AT: 2021-12-18
import fs from 'fs'
import {join, resolve} from "path";

function removeJs(path: string) {
    // console.log(destPath)
    const files = fs.readdirSync(path)
    files.forEach(file => {
        const fullPath = resolve(path, file)
        const stat = fs.statSync(fullPath);
        if (stat.isDirectory()) {
            removeJs(join(path, file))
        }
        if (file.match(/\.js$/)) {
            fs.rm(fullPath, {
                force: true,
                recursive: true
            }, err => {

            })
        }
    })
}

const destPath = resolve(__dirname, "../src")

removeJs(destPath)
removeJs(resolve(__dirname, "../scripts"))
