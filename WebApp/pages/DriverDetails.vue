<template>
<v-container>
  <NavMenu/>
 <v-card color="#F2F2F2" >
        <v-card-title>
          <span class="headline" >Driver Informations</span>
           
        <v-spacer></v-spacer>
         <v-fab-transition>
        <v-btn
          color="#FAC606"
          fab
          small
          to="/DriversTable"
        >
           <v-icon>mdi-close</v-icon>
        </v-btn>
          </v-fab-transition>
         
        </v-card-title>
        <v-card-text>
             <v-row align-center>
            <v-col cols="8" sm="2" color="#409080">
                    <v-img
                                max-width="100"
                                max-height="100"
                                        src="driver.jpg"
                        ></v-img>
            </v-col>
             <v-col cols="2" sm="4" >
            <v-list-item>
            <v-list-item-content>
                <v-list-item-title> Nom : </v-list-item-title>
                <v-list-item-title>Prenom : </v-list-item-title>
                <v-list-item-title>Date de naissance : </v-list-item-title>
                <v-list-item-title>Numéro de téléphone :</v-list-item-title>
                <v-list-item-title>Numéro de série de permis :</v-list-item-title>
            </v-list-item-content>
            </v-list-item>
             </v-col>
             </v-row>
          <span class="headline" >Information de voiture de Driver</span>
            <v-progress-linear
                color="#707070"
                rounded
                value="100"
                ></v-progress-linear>
        <v-row>
            <v-col cols="8" sm="2" color="#409080">
                    <v-img
                                max-width="100"
                                max-height="100"
                                        src="car.png"
                        ></v-img>
            </v-col>
            <v-col cols="8" sm="8" >
                <v-list-item>
                <v-list-item-content>
                    <v-list-item-title>Marque : </v-list-item-title>
                    <v-list-item-title>Modele : </v-list-item-title>
                    <v-list-item-title>Matricule : </v-list-item-title>
                    <v-list-item-title>Status : </v-list-item-title>
                    <v-list-item-title>Compteur Odomètre (Km) :</v-list-item-title>
                    <v-list-item-title>Carburant (L) :</v-list-item-title>
                    <v-list-item-title>Bons consommé :  </v-list-item-title>
                    <v-list-item-title>Date de prise : </v-list-item-title>
                    <v-list-item-title>Date de remise :</v-list-item-title>
                    <v-list-item-title>Etat :</v-list-item-title>
                </v-list-item-content>
                </v-list-item>
            </v-col>
       </v-row>
        </v-card-text>
 </v-card>
</v-container>
</template>
<script>
import NavMenu from '~/components/NavMenu.vue'
export default {
  components:{
    NavMenu
  },
    
}
</script>
<style scoped>
.headline{
color: #FAC606;
font-size: larger;
}
</style>