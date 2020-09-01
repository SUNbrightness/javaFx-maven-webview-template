// const WriteFilePlugin = require('write-file-webpack-plugin')
module.exports = {
    "transpileDependencies": [
        "vuetify"
    ],
    publicPath: process.env.NODE_ENV === "production" ? "././" : "/",
    productionSourceMap: false,
    // outputDir: '../mypd_package/dist',
    configureWebpack: {
        plugins: [
            // new WriteFilePlugin()
        ]
    }
}
