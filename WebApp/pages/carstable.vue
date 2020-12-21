<template color="#F2F2F2">
<v-container>
  <NavMenu/>
  <v-card color="#F2F2F2">
    <v-data-table
      :headers="headers"
      :items="desserts"
      :search="search"
      sort-by="calories"
      class="elevation-1"
    
    >
    <template v-slot:[`item.name`]="{ item }">
      
        <v-img :src="getImg(item.name)" style="width:50px; height:50px"></v-img>
      </template>
      <template v-slot:top>
        <v-toolbar
          flat
        >
          <v-toolbar-title >Voitures</v-toolbar-title>
          <v-divider
            class="mx-4"
            inset
            vertical
          ></v-divider>
          <v-spacer></v-spacer>
          <v-text-field
          v-model="search"
          append-icon="mdi-magnify"
          label="Search"
          single-line
          hide-details
        ></v-text-field>
          <v-dialog
            v-model="dialog"
            max-width="700px"
          >
            <template v-slot:activator="{ on, attrs }">
            
              <v-fab-transition>
          <v-btn
            color="#FAC606"
            
            v-bind="attrs"
            v-on="on"
            fab
            small
          >
            <v-icon>mdi-plus</v-icon>
          </v-btn>
            </v-fab-transition>
            </template>
            <v-card>
              <v-card-title>
                <span class="headline">{{ formTitle }}</span>
              </v-card-title>

              <v-card-text>
              
              <v-form v-model="valid">
      <v-container>
        <v-row>
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
              v-model="editedItem.fat"
              :rules="nameRules"
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
              v-model="editedItem.km"
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
            v-model="editedItem.carbs"
                    :items="['Super', 'Normal','sans-plomb','gazole']"
                    label="Type Carburant*"
                  required
                    outlined
                  ></v-select>
          </v-col>
        </v-row>  
        <v-row>
           <v-col
            cols="12"
            md="4"
          >
            <v-select
            v-model="editedItem.carbs"
                    :items="['Netfer Smart Solutions', 'Harizi']"
                    label="Proprietaire*"
                  required
                    outlined
                  ></v-select>
          </v-col> 
        <v-col
            cols="12"
            md="4"
          >
            <v-select
            v-model="editedItem.carbs"
                    :items="['Bonne', 'En Maintenance']"
                    label="Status*"
                  required
                    outlined
                  ></v-select>
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
                  @click="close"
                >
                  Cancel
                </v-btn>
                <v-btn
                  color="#FAC606"
                  text
                  @click="save"
                >
                  Save
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
          
        </v-toolbar>
      </template>
    
        
      <template v-slot:no-data>
        <v-btn
          color="primary"
          @click="initialize"
        >
          Reset
        </v-btn>
      </template>
    </v-data-table>
  </v-card>
</v-container>
</template>

<script>
import AddCar1 from '~/components/AddCar1.vue'
import NavMenu from '~/components/NavMenu.vue'
  export default {
 components: {
    AddCar1,
    NavMenu
 },
    data: () => ({
      dialog: false,
      dialogDelete: false,
       MarqueItems:['Renault','Peugeot','Citroën','Dacia','Volkswagen','Toyota','Fiat','Ford'],
        ModeleItems:['Clio IV','208','3008 II','C3 III','Sandero','2008','Twingo III','Mégane IV','Duster 2','C3 Aircross','Polo','Yaris','500','Golf VII'],
        NbBonsItems:['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20'],
        nbval:null,
        values:null,
        Modelvalues:null,
      search: '',
      headers: [
        {
          text: 'Photo',
          align: 'start',
          sortable: false,
          value: 'name',
        },
        { text: 'Marque', value: 'calories' },
        { text: 'Modèle', value: 'fat' },
        { text: 'Matricule', value: 'carbs' },
        { text: 'Status', value: 'protein' },
        {text: "Compteur Odomètre (Km) ",value:'km'},
        {text: "Current Driver",value:'user'},
      ],
      desserts: [],
      editedIndex: -1,
      editedItem: {
        name: '',
        calories: 0,
        fat: 0,
        carbs: 0,
        protein: 0,
        km:0,
        user:"Noha Nekamiche"
      },
      defaultItem: {
        name: '',
        calories: 0,
        fat: 0,
        carbs: 0,
        protein: 0,
        km:0,
          user:"Noha Nekamiche"
              },
    }),
    

    computed: {
      formTitle () {
        return this.editedIndex === -1 ? 'Ajouter Voiture' : 'Edit Item'
      },
    },

    watch: {
      dialog (val) {
        val || this.close()
      },
      
    },

    created () {
      this.initialize()
    },

    methods: {
       getImg (calories) {
        return "https://randomuser.me/api/portraits/women/81.jpg"
      },
      initialize () {
        this.desserts = [
          {
            name: 'Frozen Yogurt',
            calories: 159,
            fat: 6.0,
            carbs: 24,
            protein: 4.0,
            km:122,
             user:"Noha Nekamiche"
          },
          {
            name: 'Ice cream sandwich',
            calories: 237,
            fat: 9.0,
            carbs: 37,
            protein: 4.3,
            km:12
            ,
              user:"Noha Nekamiche"
          },
          {
            name: 'Eclair',
            calories: 262,
            fat: 16.0,
            carbs: 23,
            protein: 6.0,
            km:150,
              user:"Noha Nekamiche"
          },
          {
            name: 'Cupcake',
            calories: 305,
            fat: 3.7,
            carbs: 67,
            protein: 4.3,
            km:231,
              user:"Noha Nekamiche"
          },
        
        ]
      },
      close () {
        this.dialog = false
        this.$nextTick(() => {
          this.editedItem = Object.assign({}, this.defaultItem)
          this.editedIndex = -1
        })
      },

      closeDelete () {
        this.dialogDelete = false
        this.$nextTick(() => {
          this.editedItem = Object.assign({}, this.defaultItem)
          this.editedIndex = -1
        })
      },

      save () {
        if (this.editedIndex > -1) {
          Object.assign(this.desserts[this.editedIndex], this.editedItem)
        } else {
          this.desserts.push(this.editedItem)
        }
        this.close()
      },
    },
  }
</script>
<style scoped>
.v-text-field,.v-autocomplete{
  color: #FAC606;
}
</style>