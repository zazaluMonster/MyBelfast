module.exports = {
  publicPath: '/MyBelfast/',
  configureWebpack: {
    module: {
      rules: [
        {
          test: /\.less$/,
          use: [
            {
              loader: 'less-loader', // compiles Less to CSS
            },
          ],
        },
      ],
    }
  }
}