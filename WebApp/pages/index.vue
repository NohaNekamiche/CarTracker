<template>
<v-container>
<v-row>  
 <LoginForgetPwd/>
 </v-row>

 
</v-container>
</template>

<script>
import Logo from '~/components/Logo.vue'
import VuetifyLogo from '~/components/VuetifyLogo.vue'
import statistiques from '~/components/statistiques.vue'
import ListItems from '~/components/ListItems.vue'
import LoginForgetPwd from '~/components/Login_ForgetPwd.vue'
import Login from '~/components/Login.vue'
import dialog from '~/components/dialog.vue'
export default {
  components: {
    Logo,
    VuetifyLogo,
    statistiques,
    ListItems,
    LoginForgetPwd,
      Login,
      dialog
    
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