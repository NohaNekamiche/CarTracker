<template>
<v-container>
  
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

      <listItems/>
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
  <Login_ForgetPwd/>
  <Login/>
</v-container>
</template>

<script>
import Logo from '~/components/Logo.vue'
import VuetifyLogo from '~/components/VuetifyLogo.vue'
import statistiques from '~/components/statistiques.vue'
import ListItems from '~/components/ListItems.vue'
import Login_ForgetPwd from '~/components/Login_ForgetPwd.vue'
import Login from '~/components/Login.vue'
export default {
  components: {
    Logo,
    VuetifyLogo,
    statistiques,
    ListItems,
    Login_ForgetPwd,
      Login
    
  }
}
</script>
<style scoped>
.headline{
  text-decoration-color:#FAC606;
}
h2{
  color:#FAC606 ;
}
</style>