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
            label="Marque"
            placeholder="VOLKSWAGEN"
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
            label="Marque"
            placeholder="VOLKSWAGEN"
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
            label="Matricule"
            placeholder="13352 110 16"
            outlined
          ></v-text-field>
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
            label="Compteur Odomètre"
            placeholder="123 (KM)"
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
            label="Carburant"
            placeholder="60 (L)"
            outlined
          ></v-text-field>
        </v-col>
        <v-col
          cols="12"
          md="4"
        >
           <v-select
                  :items="['Bonne', 'En Maintenance']"
                  label="Status*"
                required
                  outlined
                ></v-select>
        </v-col>
      </v-row>
     
          
      <v-row>
          <v-col
          cols="12"
          md="10">
        <v-file-input
            label="Photo de voiture"
            outlined
            prepend-icon="mdi-camera"
        ></v-file-input>
         </v-col>
         <v-col
          cols="12"
          md="10">
        <v-file-input
            label="Photo de tableau de bord"
            outlined
            prepend-icon="mdi-camera"
        ></v-file-input>
         </v-col>
     
      </v-row>
       <v-row justify="center">   
             <v-col
          cols="12"
          md="10">
          <v-btn color="#FAC606" >Sauvegarder</v-btn>
          </v-col></v-row>
    </v-container>
  </v-form>
          <small>*indicates required field</small>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="blue darken-1"
            text
            @click="dialog = false"
          >
            Close
          </v-btn>
          <v-btn
            color="blue darken-1"
            text
            @click="dialog = false"
          >
            Save
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
    }),
  }
</script>