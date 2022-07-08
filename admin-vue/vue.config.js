const {defineConfig} = require('@vue/cli-service')

// If your port is set to 80,
// use administrator privileges to execute the command line.
// For example, Mac: sudo npm run
// You can change the port by the following method:
// port = 9527 npm run dev OR npm run dev --port = 9527
const port = process.env.port || process.env.npm_config_port || 3000 // dev port
const host = "localhost"

module.exports = defineConfig({
    transpileDependencies: true,
    devServer: {
        host: host,
        port: port,
        // open: true,
        // proxy: {
        //     [process.env.VUE_APP_BASE_API]: {
        //         target: `http://localhost:8080`,
        //         changeOrigin: true,
        //     }
        // },
        // proxy: {
        //     [process.env.VUE_APP_BASE_API]: {
        //         target: `http://localhost:8080`,
        //         changeOrigin: true,
        //         pathRewrite: {
        //             ['^' + process.env.VUE_APP_BASE_API]: ''
        //         }
        //     }
        // }
    },

    // webpack 相关操作
    // 1、将相关配置最终合并到Webpack
    configureWebpack: config => {

    },
    // 2、对相关的webpack配置进行更加细粒度修改
    chainWebpack(config) {

    }
})
console.log(process.env.NODE_ENV)
