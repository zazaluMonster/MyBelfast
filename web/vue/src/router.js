import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  // 从hash模式改为history，url中的#号消失
  mode: 'history',
  routes: [
    {
      path: '/MyBelfast/',
      name: 'login',
      component: () => import('./views/login/login.vue')
    },
    {
      path: '/MyBelfast/main',
      // 路由懒加载，有利于高效加载，webpackChunkName是一个可选项，表示你想把多个相同的vue组件都包在一起进行懒加载
      component: () => import(/* webpackChunkName: "about" */ './views/main/main.vue'),
      children: [
        // 默认子路由,直接重定向到希望展示的一个页面内容,本项目首页默认展示新闻,所以重定向到news
        {
          path: '/',
          name: "main",
          redirect: "news",
        },
        {
          path: 'news',
          name: 'news',
          component: () => import('./components/news/news-list.vue'),
        },
        {
          path: 'crewManage',
          name: 'crewManage',
          component: () => import('./components/crewManage/crewManage.vue'),
        },
        {
          path: 'about',
          name: 'about',
          component: () => import('./components/about/about-me.vue'),
        },

      ]
    },
    {
      // 未指定的页面重定向回首页（或者404页面）
      path: "*",
      redirect: "/MyBelfast/"
    }
  ]
})
