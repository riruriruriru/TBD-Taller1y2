<template>
  <div class="center">
    <h2>{{title}}</h2>
    <form>
        <input v-model="actor.firstName" type=text />
        <input v-model="actor.lastName" type=text  />
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
      title:'Agregar actores',
      actor:{
        firstName:"",
        lastName:""
      },
      validador1:false,
      validador2:false
    }
  },
  methods:{
      post(){
          console.log(this.actor.firstName);
          console.log(this.actor.lastName);
          this.$http.post('http://localhost:8090/actors',this.actor)
          .then(function(response){
              this.actor.firstName="";
              this.actor.lastName="";
              this.validador1=false;
              this.validador2=true;
              
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