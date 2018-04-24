

<template>
<div class= "center">
    <h2>FILM {{film.title}}</h2>
    <form>
  
    <select v-model="actorSelected" class="form-control">
        <option v-for="actor in this.actors" :key="actor.actorId" :value="actor.actorId">{{ actor.firstName }}</option>
    </select>
<h2>Selected: {{actorSelected}}</h2>
 <button v-on:click.prevent="post" type=submit >Agregar</button>

        <p v-if="validador1">No se enviaron los datos</p>

        <p v-if="validador2"> Se agrega el actor correctamente </p>
    </form>
</div>
</template>
<script>
export default {
  data(){
    return{
    actorSelected: "",
      actors: [],
      film:[],
      validador1:false,
      validador2:false,
      filmActor: {actor:"", film:"", filmActorPk: ""},
      faPK: {actorId: "", filmId: ""},

    }

  },
  mounted:function(){
      this.id = this.$route.params.id;
          this.$http.get('http://localhost:8090/actors')
    .then(response=>{
       // get body data
      this.actors = response.body;
     console.log('ACTORS: ', this.actors)
    }, response=>{
       // error callback
       console.log('error cargando lista');
    }),
    // GET /someUrl
    this.$http.get('http://localhost:8090/film/'+ this.id)
    .then(response=>{
       // get body data
      this.film = response.body;
     console.log('ACTOR PEDIDO CON ID: ',this.film, this.id)
    }, response=>{
       // error callback
       console.log('error cargando lista');
    })
    // GET /someUrl

    
  },
  
  methods:{
      post(){
          //this.filmActor.actor = this.actorSelected;
          //this.filmActor.film = this.film;
          //this.faPK.filmId = this.id;
          //this.faPK.actorId = this.actorSelected.filmId;
          //this.filmActor.filmActorPk = this.faPK;
            //console.log('uguuu: ' + this.actorSelected);
            //console.log(this.film);
            //console.log(this.faPK);
            //console.log(this.filmActor); 
          this.$http.post('http://localhost:8090/films/'+ this.id+'/actors/' +this.actorSelected)
          .then(function(response){
              this.actorSelected="";
              this.validador1=false;
              this.validador2=true;
              console.log('uguuu: ' + this.actorSelected);
              //console.log(this.film);
          },
          function(response){
              this.validador1=true;
              this.validador2=false;
          }
          
          );
      }
      
  }
}
</script>