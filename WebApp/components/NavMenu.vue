<template>
<v-container>
<v-navigation-drawer
      v-model="drawer"
      :mini-variant="miniVariant"
      :clipped="clipped"
      fixed
      app
      color="#333333"
    >
    <template v-slot:prepend>
        <v-list-item two-line>
          <v-list-item-avatar>
            <img src="https://randomuser.me/api/portraits/women/81.jpg">
          </v-list-item-avatar>

          <v-list-item-content>
            <v-list-item-title><h4>Noha Nekamiche</h4></v-list-item-title>
            <v-list-item-subtitle><h5>hn_nekamiche@esi.dz</h5></v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
      </template>

      <v-divider></v-divider>
      <v-list>
        <v-list-item
          v-for="(item, i) in items"
          :key="i"
          :to="item.to"
          router
          exact
        >
          <v-list-item-action>
            <v-icon color="#FAC606">{{ item.icon }}</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title  ><h4>{{item.title}}</h4></v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-app-bar
      :clipped-left="clipped"
      fixed
      app
    >
      <v-app-bar-nav-icon @click.stop="drawer = !drawer" />
      <v-btn
        icon
        @click.stop="miniVariant = !miniVariant"
      >
        <v-icon>mdi-{{ `chevron-${miniVariant ? 'right' : 'left'}` }}</v-icon>
      </v-btn>
      <v-btn
        icon
        @click.stop="clipped = !clipped"
      >
        <v-icon>mdi-application</v-icon>
      </v-btn>
      <v-btn
        icon
        @click.stop="fixed = !fixed"
      >
        <v-icon>mdi-minus</v-icon>
      </v-btn>
      <v-toolbar-title v-text="title" />
      <v-spacer />
      
    </v-app-bar>
    <v-main>
      <v-container>
        <nuxt />
      </v-container>
    </v-main>
    <v-navigation-drawer
      v-model="rightDrawer"
      :right="right"
      temporary
      fixed
    >
      
    </v-navigation-drawer>
</v-container>
</template>







 
<script>
export default {
  data () {
    return {
      clipped: false,
      drawer: true,
      fixed: true,
      items: [
        {
          icon: 'mdi-apps',
          title: 'Table de Bord',
          to: '/home'
        },
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
          title: 'Ajouter Voiture',
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
          to:'/'
        }
      ],
      miniVariant: false,
      right: true,
      rightDrawer: false,
      title: 'Admin'
    }
  }
}
</script>
<style scoped>
h4,h5{
  color: white;
}
</style>
   