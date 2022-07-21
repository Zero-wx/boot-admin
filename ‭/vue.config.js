// const { defineConfig } = require("@vue/cli-service");
// const port = process.env.port || process.env.npm_config_port || 3000; // dev port
// const host = "localhost";
//
// module.exports = defineConfig({
//     transpileDependencies: true,
//     devServer: {
//         host: host,
//         port: port,
//         open: true,
//         proxy: {
//             [process.env.VUE_APP_BASE_API]: {
//                 target: `http://localhost:8080`,
//                 changeOrigin: true
//             }
//         }
//     },
//
//     // webpack 相关操作
//     // 1、将相关配置最终合并到Webpack
//     configureWebpack: {
//
//
//     },
//     // 2、对相关的webpack配置进行更加细粒度修改
//     chainWebpack(config) {
//     }
// });
//
const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true
})
