<template>
<v-container>
 <v-row >
   <v-col cols="12" sm="12" md="8">
  <v-card
    max-width="300"
    class="mx-auto"
    color="#F2F2F2"
  >
    <v-app-bar
      dark
      color="#B3B3B3"
    >
      

      <v-toolbar-title><h4>NB de Voitures totales</h4></v-toolbar-title>

      <v-spacer></v-spacer>

    </v-app-bar>
 <v-container>
   <v-row align="start">
      <v-icon
        :color="checking ? 'red lighten-2' : '#FAC606'"
        class="mr-12"
        size="64"
        @click="takePulse"
      >
        mdi-car
      </v-icon>
        
        <div class="caption grey--text text-uppercase">
          <h1>23</h1>
        </div>
        <div>
          <span
            class="display-2 font-weight-black"
            
          ></span>
          <h5>Drivers</h5>
        </div>
      </v-row>
 </v-container>
  </v-card>
   </v-col>
 </v-row>
 <v-row>
     <v-col cols="12" sm="8" md="8">
<v-card
    max-width="280"
    class="mx-auto"
    color="#F2F2F2"
  >
    <v-app-bar
      dark
      color="#B3B3B3"
    >
      

      <v-toolbar-title><h4>NB de Voitures totales</h4></v-toolbar-title>

      <v-spacer></v-spacer>

    </v-app-bar>
 <v-container>
   <v-row align="start">
      <v-icon
        :color="checking ? 'red lighten-2' : '#FAC606'"
        class="mr-12"
        size="64"
        @click="takePulse"
      >
         mdi-car
      </v-icon>
      <div class="caption grey--text text-uppercase">
          <h1>50</h1>
        </div>
        <div>
          <span
            class="display-2 font-weight-black"
            
          ></span>
          <h5>Voitures</h5>
        </div>
   </v-row>
 </v-container>
  </v-card>
     </v-col>
</v-row>
<v-row>
     <v-col cols="12" sm="8" md="8">
<v-card
    max-width="280"
    class="mx-auto"
    color="#F2F2F2"
  >
    <v-app-bar
      dark
      color="#B3B3B3"
    >
      

      <v-toolbar-title><h4>NB de drivers totale</h4></v-toolbar-title>

      <v-spacer></v-spacer>

    </v-app-bar>
 <v-container>
   <v-row align="start">
      <v-icon
        :color="checking ? 'red lighten-2' : '#FAC606'"
        class="mr-12"
        size="64"
        @click="takePulse"
      >
        mdi-car
      </v-icon>
      <div class="caption grey--text text-uppercase">
          <h1>50</h1>
        </div>
        <div>
          <span
            class="display-2 font-weight-black"
            
          ></span>
          <h5>Voitures</h5>
        </div>
   </v-row>
 </v-container>
  </v-card>
     </v-col>
</v-row>

</v-container>
 
</template>
<script>
  export default {
    data: () => ({
      items: [
        {
          color: '#F2F2F2',
          src: 'https://cdn.vuetifyjs.com/images/cards/foster.jpg',
          title: 'Supermodel',
          artist: 'Foster the People',
        },
        {
          color: '#F2F2F2',
          src: 'https://cdn.vuetifyjs.com/images/cards/halcyon.png',
          title: 'Halcyon Days',
          artist: 'Ellie Goulding',
        },
      ],
    }),
  }
</script>

<style scoped>
h1,h2,h3,h4,h5{
  margin-top: 20px;
  color: #333333;
}
</style>