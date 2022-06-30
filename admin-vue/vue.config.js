const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true,
    devServer: {
        port: 3000,
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
