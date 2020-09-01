import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import './sass/default.scss';
Vue.config.productionTip = false


import indexController from './controller/index.js';
if(process.env.NODE_ENV != "production"){
    //绑定上java 的controller
    Vue.use(indexController);
}

window.JL = {};



new Vue({
  vuetify,
  render: h => h(App)
}).$mount('#app')
