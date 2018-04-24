

<template>
<div class= "center">
    <h2>Actor/Actriz {{actor2.firstName}}</h2>
    <form>
  
    <select v-model="filmSelected" class="form-control">
        <option v-for="film in this.films" :key="film.film.filmId" :value="film.film.filmId">{{ film.film.title }}</option>
    </select>
<h2>Selected: {{filmSelected}}</h2>
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
    filmSelected: "",
      films: [],
      actor2:[],
      validador1:false,
      validador2:false,
      filmActor: {actor:"", film:"", filmActorPk: ""},
      faPK: {actorId: "", filmId: ""},

    }

  },
  mounted:function(){
      this.id = this.$route.params.id;
          this.$http.get('http://localhost:8090/filmsbynotactor/'+this.id)
    .then(response=>{
       // get body data
      this.films = response.body;
     console.log('FILMS: ', this.films)
    }, response=>{
       // error callback
       console.log('error cargando lista');
    }),
    // GET /someUrl
    this.$http.get('http://localhost:8090/actors/'+ this.id)
    .then(response=>{
       // get body data
      this.actor2 = response.body;
     console.log('ACTOR PEDIDO CON ID: ',this.actor2, this.id)
    }, response=>{
       // error callback
       console.log('error cargando lista');
    })
    // GET /someUrl

    
  },
  
  methods:{
      post(){
          //this.filmActor.film = this.filmSelected;
          //this.filmActor.actor = this.actor2;
          //this.faPK.actorId = this.id;
          //this.faPK.filmId = this.filmSelected.filmId;
          //this.filmActor.filmActorPk = this.faPK;
            //console.log('uguuu: ' + this.filmSelected);
            //console.log(this.actor2);
            //console.log(this.faPK);
            //console.log(this.filmActor); 
          this.$http.post('http://localhost:8090/actors/' +this.id+ '/films/'+this.filmSelected)
          .then(function(response){
              this.filmSelected="";
              this.validador1=false;
              this.validador2=true;
              //console.log('uguuu: ' + this.filmSelected);
              //console.log(this.actor2);
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