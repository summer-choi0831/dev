import Vue from 'vue'
import Router from 'vue-router'
import WeddingCard from "./components/WeddingCard";
import index from "./App";

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/wedding_card',
      component: WeddingCard
    },
    {
      path: '/',
      component: index
    }
  ]
})
