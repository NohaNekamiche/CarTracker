<template>
<v-container>
  <NavMenu/>
  <v-row justify="center">
      <v-card color="#F2F2F2" >
        <v-card-title>
          <span class="headline" >Affecter Voiture</span>
         
        </v-card-title>
        <v-card-text>
            <v-form v-model="valid">
    <v-container>
      <v-row>
        <v-col
          cols="12"
          md="4"
        >
          <v-text-field
            v-model="firstname"
            :rules="nameRules"
            :counter="20"
            color="#FAC606"
            label="Nom"
            placeholder="Nekamiche"
            outlined
          ></v-text-field>
        </v-col>

        <v-col
          cols="12"
          md="4"
        >
          <v-text-field
            v-model="firstname"
            :rules="nameRules"
            :counter="20"
            label="Prenom"
            color="#FAC606"
            placeholder="Noha"
            outlined
          ></v-text-field>
        </v-col>

        <v-col
          cols="12"
          md="4"
        >
          <v-text-field
            v-model="firstname"
            :rules="nameRules"
            color="#FAC606"
            :counter="20"
            label="Email"
            placeholder="hn_nekamiche@esi.dz"
            outlined
          ></v-text-field>
        </v-col>
      </v-row>
      <v-row>  
         <v-col
         cols="12"
          md="4">
                <v-layout  wrap>
                    <v-menu
                    v-model="fromDateMenu"
                    :close-on-content-click="false"
                    :nudge-right="40"
                    lazy
                    transition="scale-transition"
                    offset-y
                    
                    >
                    <template v-slot:activator="{ on }">
                        <v-text-field
                        label="Date De Prise"
                        prepend-inner-icon="mdi-calendar"
                        outlined
                        color="#FAC606"
                        :value="fromDateDisp"
                        v-on="on"
                        
                        ></v-text-field>
                    </template>
                    <v-date-picker
                        locale="en-in"
                        :min="minDate"
                        :max="maxDate"
                        v-model="fromDateVal"
                        no-title
                        @input="fromDateMenu = false"
                    ></v-date-picker>
                    </v-menu>
                </v-layout>
         </v-col>

        <v-col
         cols="12"
          md="4">
            <v-layout  wrap>
                <v-menu
                v-model="toDateMenu"
                :close-on-content-click="false"
                :nudge-right="40"
                lazy
                transition="scale-transition"
                offset-y
                full-width
                max-width="290px"
                min-width="290px"
                >
                <template v-slot:activator="{ on }">
                    <v-text-field
                    label="Date De Remise"
                    prepend-inner-icon="mdi-calendar"
                    outlined
                    color="#FAC606"
                    :value="toDateDisp"
                    v-on="on"
                    ></v-text-field>
                </template>
                <v-date-picker
                    locale="en-in"
                    :min="minDate"
                    :max="maxDate"
                    v-model="toDateVal"
                    no-title
                    @input="toDateMenu = false"
                ></v-date-picker>
                </v-menu>
            </v-layout>
            </v-col>
        <v-col
          cols="12"
          md="4"
        >
          <v-autocomplete
            v-model="values"
            :items="MarqueItems"
            outlined
            color="#FAC606"
            label="Marque*"
          ></v-autocomplete>
        </v-col>
      </v-row>
      <v-row>
        <v-col
          cols="12"
          md="4"
        >
          <v-autocomplete
            v-model="Modelvalues"
            :items="ModeleItems"
            outlined
            color="#FAC606"
            label="Modele*"
          ></v-autocomplete>
        </v-col>

        <v-col
          cols="12"
          md="4"
        >
          <v-text-field
            v-model="firstname"
            :rules="nameRules"
            :counter="20"
            color="#FAC606"
            label="Matricule"
            placeholder="13352 110 16"
            outlined
          ></v-text-field>
        </v-col>

        <v-col
          cols="12"
          md="4"
        >
         <v-autocomplete
            v-model="Nbval"
            :items="NbBonsItems"
            outlined
            color="#FAC606"
            label="Nombre De Bons*"
          ></v-autocomplete>
        </v-col>
      </v-row>        
    </v-container>
     <small>*indicates required field</small>
  </v-form>
         
        </v-card-text>
        <v-card-actions>
          <v-spacer ></v-spacer>
         <v-btn color="#FAC606" >Sauvegarder</v-btn>
        </v-card-actions>
      </v-card>
  </v-row>
</v-container>
</template>

<script>
import NavMenu from '~/components/NavMenu.vue'
import axios from 'axios'

  export default {
     components:{
            NavMenu,
     }, 
    data: () => ({
      dialog: false,
      fromDateMenu: false,
      toDateMenu: false,
        fromDateVal: null,
        toDateVal:null,
        minDate: "2020-07-04",
        maxDate: "2030-08-30",
        MarqueItems:['Renault','Peugeot','Citroën','Dacia','Volkswagen','Toyota','Fiat','Ford'],
        ModeleItems:['Clio IV','208','3008 II','C3 III','Sandero','2008','Twingo III','Mégane IV','Duster 2','C3 Aircross','Polo','Yaris','500','Golf VII'],
        NbBonsItems:['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20'],
        nbval:null,
        values:null,
        Modelvalues:null,
        formdata:{
          
        }
    }),
    computed: {
      fromDateDisp() {
        return this.fromDateVal;
        // format date, apply validations, etc. Example below.
        // return this.fromDateVal ? this.formatDate(this.fromDateVal) : "";
      },
      toDateDisp(){
          return this.toDateVal
      }
    },
     methods:{
      save(){
        let car=this.formdata;
        console.log(car);
        axios.post('http://127.0.0.1:8000/api/envoyerAlerte',car)
       .catch(function (error){
         console.log(error);
       })
       dialog:false;
      }
    }
  }
</script>
<style scoped>
.headline{
    color:#FAC606;
    text-decoration-style: solid;
    text-align: left;
}
</style>