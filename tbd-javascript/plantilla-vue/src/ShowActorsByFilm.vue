<template>
  <div class="center">
    <h2>Actores pelicula: {{film.title}}</h2>
    <ul class="user-list">
      <li v-for="(u,i) in users">
        <img :src="'https://robohash.org/'+i+'?size=50x50'" />
        <span>{{u.actor.firstName}}</span>
        <span>{{u.actor.lastName}}</span>
        <span class="date">{{Date(u.lastUpdate)}}</span>
      </li>
    </ul>
  </div>
</template>
<script>

export default {
  data(){
    return{
      users:[],
      film:[],
      
      
    }
  },
  mounted:function(){
    this.id = this.$route.params.id;  
    console.log('Index.vue');
    // GET /someUrl
    this.$http.get('http://localhost:8090/films/' + this.id+'/actors')
    .then(response=>{
       // get body data
      this.users = response.body;
        this.users = JSON.parse(JSON.stringify(this.users))
     console.log('users',this.users)
    }, response=>{
       // error callback
       console.log('error cargando lista');
    }),
     this.$http.get('http://localhost:8090/film/' + this.id)
    .then(response=>{
       // get body data
      this.film = response.body;
     console.log('film',this.film)
    }, response=>{
       // error callback
       console.log('error cargando lista');
    })
  }
}
</script>