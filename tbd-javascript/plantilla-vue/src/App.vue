<template>
  <div>
    <header>
      <div class="branding">
        <img class ="logo-small" src="./img/fidget-spinner.svg" />
        <span>Nagevación superior</span>
      </div>
      <nav>
        <a href="#/">Home</a>
        <a href="#/actors">Lista</a>
        <a href="#/AddActors">Agregar Actores</a>
        <a href="#/films"> Films</a>
      </nav>
    </header>

    <main class="container">
      <router-view></router-view>
    </main>
    <footer>
      Footer
    </footer>
</div>
</template>

<script>
export default {

}
</script>
