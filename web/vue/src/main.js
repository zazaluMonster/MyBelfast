import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import iView from 'iview';
import 'iview/dist/styles/iview.css';
import { boot } from '@/boot.js';

//预加载
boot();

//取消vue生产Tip
Vue.config.productionTip = false

//默认配置iView
Vue.use(iView);

//iView全局配置，按需使用
Vue.use(iView, {
    //config...
});

// vue注册全局对象
// Vue.prototype.$global.$prop = global.$prop;

// 实例化根vue
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
