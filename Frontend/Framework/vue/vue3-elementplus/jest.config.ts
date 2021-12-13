//CREATE AT: 2021-12-12
import * as path from "path";

export default {
    rootDir: path.resolve(__dirname),
    clearMocks: true,
    coverageDirectory: 'coverage',
    coverageProvider: 'v8',
    moduleFileExtensions: ['vue', 'js', 'json', 'jsx', 'ts', 'tsx', 'node'],
    // 别名设置
    moduleNameMapper: {
        '@/(.*)$': '<rootDir>/src/components/$1'
    },
    preset: 'ts-jest',
    testEnvironment: 'jsdom',
    // 测试文件
    // testMatch: ['<rootDir>/tests/unit/*.spec.ts?(x)'],

    transform: {
        '^.+\\.vue$': 'vue-jest',
        '^.+\\js$': 'babel-jest',
        '^.+\\.(t|j)sx?$': 'ts-jest'
    }
}
