
<template>
  <div class="center">
    <h2>{{title}}</h2>
    <ul class="user-list">
      <li v-for="u,i in users">
        <img :src="'https://robohash.org/'+i+'?size=50x50'" />
        <span>{{u.title}}</span>
        <span class="date">{{Date(u.lastUpdate)}}</span>
        <router-link :to="{ name: 'agregarActor', params: { id: u.filmId } }">Agregar un actor</router-link>
        <router-link :to="{ name: 'mostrarActor', params: { id: u.filmId } }">Mostrar Actores</router-link>
      </li>
    </ul>
  </div>
</template>
<script>

export default {
  data(){
    return{
      title:'Peliculas  uwu',
      users:[]
    }
  },
  mounted:function(){
    console.log('Index.vue');
    // GET /someUrl
    this.$http.get('http://localhost:8090/film')
    .then(response=>{
       // get body data
      this.users = response.body;
     console.log('users',this.users)
    }, response=>{
       // error callback
       console.log('error cargando lista');
    })
  }
}
</script>