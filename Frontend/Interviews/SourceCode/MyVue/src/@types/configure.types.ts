//CREATE AT: 2021-12-18
export interface BuildConfig {
    entry: string,
    dest: string,
    format: string,
    banner?: string,
    moduleName?: string
    alias?: string
    plugins?: string
}
