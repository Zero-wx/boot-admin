const {defineConfig} = require('@vue/cli-service')

const AutoImport = require('unplugin-auto-import/webpack')
const Components = require('unplugin-vue-components/webpack')
const {ElementPlusResolver} = require('unplugin-vue-components/resolvers')


console.log(process.env.NODE_ENV)

module.exports = defineConfig({
    transpileDependencies: true,
    devServer: {
        port: 3000,
        proxy: {
            [process.env.VUE_APP_BASE_API]: {
                target: 'http://localhost:8088',
                changeOrigin: true,
                // pathRewrite: {
                //     ['^' + process.env.VUE_APP_BASE_API]: ''
                // }
            }
        }
    },
    chainWebpack: config => {
        config.plugin('AutoImport').use(AutoImport({resolvers: [ElementPlusResolver()]}))
        config.plugin('Components').use(Components({resolvers: [ElementPlusResolver()]}))
    }
})
