<template>
  <v-app dark>
  <NavMenu/>
  <v-row justify="center" align="center" >
    <v-col cols="12" sm="8" md="6">
      <v-card color="#F2F2F2">
        <v-card-title class="headline">
          <h2>Statistiques</h2>
        </v-card-title>
        <v-card-text>
          
          <statistiques/>
          
        </v-card-text>     
        <v-card-actions>
          <v-spacer />        
        </v-card-actions>
      </v-card>
      
    </v-col>
    <v-col cols="12" sm="8" md="6">

      <ListItems/>
    </v-col>
  </v-row>
 <v-row justify="center" align="center" >
    <v-col cols="12" sm="8" md="6">
      <v-card color="#F2F2F2">
        <v-app-bar
      dark
      color="#FAC606"
    >
      <v-toolbar-title><h4>Maps</h4></v-toolbar-title>
      <v-spacer></v-spacer>
    </v-app-bar>
        
        <v-card-actions>
          <v-spacer />        
        </v-card-actions>
      </v-card>
    </v-col>
 </v-row>
</v-app>
</template>

<script>
import statistiques from '~/components/statistiques.vue'
import ListItems from '~/components/ListItems.vue'
import NavMenu from '~/components/NavMenu.vue'
export default {
  components:{
    statistiques,
   ListItems,
   NavMenu
  },
  data () {
    return {
      clipped: false,
      drawer: false,
      fixed: false,
      items: [
         {
          icon: 'mdi-apps',
          title: 'Drivers',
          to: '/'
        },
        {
          icon: 'mdi-car',
          title: 'Liste des Voitures',
          to: '/CarsTable'
        }
        ,
        {
          icon: 'mdi-chart-bubble',
          title: 'Ajouter Voiture',
          to: '/inspire'
        },
        {
          icon: 'mdi-chart-bubble',
          title: 'Ajouter Bons Du Carburants',
          to: '/inspire'
        },
        {
          icon: 'mdi-chart-bubble',
          title: 'Service Maintenance',
          to: '/inspire'
        },
        {
          icon: 'mdi-file-document',
          title: 'Rapports',
          to: '/inspire'
        }
        ,{
          icon: 'mdi-logout',
          title:'Se Deconnecter',
          to:'/inspire'
        }
      ],
      miniVariant: false,
      right: true,
      rightDrawer: false,
      title: 'Vuetify.js'
    }
  }
}
</script>
