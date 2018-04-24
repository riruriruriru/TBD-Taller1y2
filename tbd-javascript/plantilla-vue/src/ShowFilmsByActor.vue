<template>
  <div class="center">
    <h2>Peliculas Actor: {{actor.firstName}} {{actor.lastName}}</h2>
    <ul class="user-list">
      <li v-for="(u,i) in users">
        <img :src="'https://robohash.org/'+i+'?size=50x50'" />
        <span>{{u.film.title}}</span>
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
      actor:[],
      
      
    }
  },
  mounted:function(){
    this.id = this.$route.params.id;  
    console.log('Index.vue');
    // GET /someUrl
    this.$http.get('http://localhost:8090/actors/' + this.id+'/films')
    .then(response=>{
       // get body data
      this.users = response.body;
        this.users = JSON.parse(JSON.stringify(this.users))
     console.log('users',this.users)
    }, response=>{
       // error callback
       console.log('error cargando lista');
    }),
     this.$http.get('http://localhost:8090/actors/' + this.id)
    .then(response=>{
       // get body data
      this.actor = response.body;
     console.log('actor',this.actor)
    }, response=>{
       // error callback
       console.log('error cargando lista');
    })
  }
}
</script>