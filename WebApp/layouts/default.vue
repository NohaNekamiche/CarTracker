<template>
  <v-app dark>
    <v-main>
      <v-container>
        <nuxt />
      </v-container>
    </v-main>
   
    <v-footer
      :absolute="!fixed"
      app
    >
      <span>&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>
  </v-app>
</template>

<script>
export default {
  data () {
    return {
      clipped: false,
      drawer: true,
      fixed: false,
      items: [
         {
          icon: 'mdi-apps',
          title: 'Drivers',
          to: '/DriversTable'
        },
        {
          icon: 'mdi-car',
          title: 'Liste des Voitures',
          to: '/CarsTable'
        }
        ,
        {
          icon: 'mdi-chart-bubble',
          title: 'Affecter Voiture',
          to: '/AffecterCar'
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
      title: ''
    }
  }
}
</script>
<style scoped>
h4,h5{
  color: white;

}
</style>
