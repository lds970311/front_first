import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'
import VueJsx from '@vitejs/plugin-vue-jsx'

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [vue(),
        VueJsx()],
    server: {
        port: 12888,
        host: true,
        proxy: {
            '/api': {
                target: 'http://192.168.125.5:8901/boot_ssmp',
                changeOrigin: true,
                rewrite: (path) => path.replace(/^\/api/, '')
            },
        }
    },
})
