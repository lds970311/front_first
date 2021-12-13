//CREATE AT: 2021-12-12
export default function toLowerLine(name: string): string {
    return name.replace(/(A-Z)g/, '-$1').toLocaleLowerCase()
}
