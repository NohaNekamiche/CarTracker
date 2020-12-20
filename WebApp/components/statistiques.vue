<template>
  <div class="text-center">
    <v-row>
      <v-col
          cols="12"
          md="4"
        >
      <v-progress-circular
        :rotate="-90"
        :size="100"
        :width="15"
        :value="value"
        color="#FAC606"
      >
        {{ value }}
      </v-progress-circular></v-col>
      <v-col
          cols="12"
          md="4"
        >
    <v-progress-circular
      :rotate="90"
      :size="100"
      :width="15"
      :value="value"
      color="#FAC606"
    >
      {{ value }}
    </v-progress-circular></v-col>
<v-col
          cols="12"
          md="4"
        >
    <v-progress-circular
      :rotate="180"
      :size="100"
      :width="15"
      :value="value"
      color="#FAC606"
    >
      {{ value }}
    </v-progress-circular></v-col>
    </v-row>
    <v-row>
       <v-col
          cols="12"
          md="4"
        >
      <h3 >Voiture en Maintenance</h3></v-col>
       <v-col
          cols="12"
          md="4"
        >
      <h3 >Bons de Carburant Consommé</h3></v-col>
       <v-col
          cols="12"
          md="4"
        >
      <h3 >Voiture disponible</h3></v-col>
    </v-row>
     <v-row> 
       <v-col
          cols="12"
          md="4"
        > <v-btn color="#fff"><h3>Voir</h3></v-btn>
       </v-col>
       <v-col
          cols="12"
          md="4"
        > <v-btn color="#fff"><h3>Voir</h3></v-btn>
       </v-col>
       <v-col
          cols="12"
          md="4"
        > 
        <v-btn color="#fff" 
            nuxt
            to="/inspire"><h3>Voir</h3></v-btn>
       </v-col>
        </v-row>

  </div>
</template>
<script>
  export default {
    data () {
      return {
        interval: {},
        value: 0,
        value2:3,
        value5:25
      }
    },
    beforeDestroy () {
      clearInterval(this.interval)
    },
    mounted () {
      this.interval = setInterval(() => {
        if (this.value <= 50) {
           this.value += 10
        }
       
      }, 1000)
    },
  }
</script>
<style scoped>
.v-progress-circular {
  margin: 1rem;
}
h3,h2{
  color:#333333;
}

</style>