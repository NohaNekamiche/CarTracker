<template>
  <v-row justify="center">
    <v-dialog
      v-model="dialog"
      persistent
      max-width="800px"
    >
      <template v-slot:activator="{ on, attrs }">
          <v-fab-transition>
        <v-btn
          color="#FAC606"
          dark
          v-bind="attrs"
          v-on="on"
          fab
          small
        >
           <v-icon>mdi-plus</v-icon>
        </v-btn>
          </v-fab-transition>
      </template>
      <v-card >
        <v-card-title>
          <span class="headline" >Ajouter Driver</span>
         
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
            placeholder="Noha"
            outlined
          ></v-text-field>
        </v-col>

        <v-col
          cols="12"
          md="4"
        >
           
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
                        
                        v-model="fromDateVal"
                        no-title
                        @input="fromDateMenu = false"
                    ></v-date-picker>
                    </v-menu>
                </v-layout>
         </v-col>
      </v-row>
      <v-row>
          
        <v-col
          cols="12"
          md="4"
        >
          <v-text-field
            v-model="firstname"
            :rules="nameRules"
            :counter="20"
            label="N° serie de Permis"
            placeholder="13325565"
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
            color="#fff"
            :counter="20" 
            label="N° Tel"
            placeholder="05 55 46 66 78 "
            outlined
          ></v-text-field>
        </v-col>
       
      </v-row>
    </v-container>
  </v-form>
          <small>*indicates required field</small>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="#FAC606"
            text
            @click="dialog = false"
          >
            Fermer
          </v-btn>
          <v-btn
            color="#FAC606"
            text
            @click="dialog = false"
          >
            Sauvegarder
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>
<script>
  export default {
    data: () => ({
      dialog: false,
       fromDateMenu: false,
        fromDateVal: null,
    }),
    computed:{
      fromDateDisp() {
        return this.fromDateVal;
        // format date, apply validations, etc. Example below.
        // return this.fromDateVal ? this.formatDate(this.fromDateVal) : "";
      },
    }
  }
</script>