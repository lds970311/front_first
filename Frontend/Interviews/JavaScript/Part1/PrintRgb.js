//CREATE AT: 2021-12-08
//红灯 3s 亮一次，绿灯 1s 亮一次，黄灯 2s 亮一次；如何让三个灯不断交替重复亮灯？
const task = (timer, light) =>
    new Promise((resolve, reject) => {
        setTimeout(() => {
            if (light === 'red') {
                console.log("red")
            } else if (light === 'green') {
                console.log("green")
            } else if (light === 'yellow') {
                console.log("yellow")
            }
            resolve()
        }, timer)
    })
const step = () => {
    task(3000, 'red')
        .then(() => task(1000, 'green'))
        .then(() => task(2000, 'yellow'))
        .then(step)
}
step()
