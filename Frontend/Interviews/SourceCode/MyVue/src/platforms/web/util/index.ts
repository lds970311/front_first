//CREATE AT: 2021-12-18
/**
 * Query an element selector if it's not an element already.
 */
export function query(el) {
    if (typeof el === 'string') {
        const selected = document.querySelector(el)
        if (!selected) {
            /* process.env.NODE_ENV !== 'production' && warn(
                 'Cannot find element: ' + el
             )*/
            console.error("el mount error!")
            return document.createElement('div')
        }
        return selected
    } else {
        return el
    }
}
