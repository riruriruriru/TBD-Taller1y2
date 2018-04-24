import Vue from 'vue';
import VueRouter from 'vue-router';
import Index from './Index.vue';
import Actors from './Actors.vue';
import Films from './Films.vue';
import AddFilmToActor from './AddFilmToActor.vue';
import AddActors from './AddActors.vue';
import AddActorToFilm from './AddActorToFilm.vue';
import ShowActorsByFilm from './ShowActorsByFilm.vue';
import ShowFilmsByActor from './ShowFilmsByActor.vue';

import VueResource from 'vue-resource';
require("./style.scss");
import App from './App.vue';
Vue.use(VueRouter);
Vue.use(VueResource);
const routes = [
  { path: '/index', alias: '/', component: Index},
  { path:'/actors', component: Actors},
  { path:'/films', component: Films},
  { path:'/AddActors', component: AddActors},
  { path:'/actors/:id', name: 'agregarFilm', component: AddFilmToActor},
  { path:'/films/:id', name: 'agregarActor', component: AddActorToFilm},
  { path:'/actors/:id', name: 'mostrarFilm', component: ShowFilmsByActor},
  { path:'/films/:id', name: 'mostrarActor', component: ShowActorsByFilm}
]

// Create the router instance and pass the `routes` option
const router = new VueRouter({
  routes
})

new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
