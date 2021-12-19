//CREATE AT: 2021-12-18
import {resolve} from 'path';

const resolver = (p: string) => resolve(__dirname, '../', p)

// console.log(resolver("src/platforms/web"))
module.exports = {
    web: resolver('src/platforms/web'),
}
