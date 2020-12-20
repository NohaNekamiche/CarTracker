<template>
<v-container>
  <NavMenu/>
  <v-data-table
    ref="myTable"
    :headers="headers"
    :items="desserts"
    :search="search"
    class="elevation-1"
  >
  <template v-slot:top>
  <v-toolbar
        flat
      >
        <v-toolbar-title class="headerline">Drivers </v-toolbar-title>
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
        color="#FAC606"
        single-line
        hide-details
      ></v-text-field>
      <AddDriver/>
      
  </v-toolbar>
  </template>
    <template v-slot:[`item.name`]="{ item }">
     
      <v-img :src="getImg(item.name)" style="width:50px; height:50px"></v-img>
    </template>
    <template v-slot:[`item.iron`]="{  }">
     
      <v-btn to="/DriverDetails">More</v-btn>
    </template>
    
  </v-data-table>
  <v-btn @click="createPDF">generatePDF</v-btn>
</v-container>
</template>
<script >
import jspdf from 'jspdf'
import AddDriver from '~/components/AddDriver.vue'
import NavMenu from '~/components/NavMenu.vue'
  export default {
    components:{
      AddDriver,
      NavMenu
    },
    data () {
      return {

         search: '',
        headers: [
          {
            text: 'Photo',
            align: 'start',
            sortable: false,
            value: 'name',
          },
          { text: 'Nom', value: 'calories' },
          { text: 'Prenom', value: 'fat' },
          { text: 'Voiture', value: 'carbs' },
          { text: 'date de prise', value: 'protein' },
          {text:'heure de prise',value:'date'},
          { text: 'Voir Plus', value: 'iron' },
        ],
        desserts: [
          {
            name: 'Frozen Yogurt',
            calories: 159,
            fat: 6.0,
            carbs: 24,
            protein: 4.0,
            date: '12/12/2020',
            iron: '1%',
          },
          {
            name: 'Ice cream sandwich',
            calories: 237,
            fat: 9.0,
            carbs: 37,
            protein: 4.3,
             date: '12/12/2020',
            iron: '1%',
          },
          {
            name: 'Eclair',
            calories: 262,
            fat: 16.0,
            carbs: 23,
            protein: 6.0,
             date: '12/12/2020',
            iron: '7%',
          },
          {
            name: 'Cupcake',
            calories: 305,
            fat: 3.7,
            carbs: 67,
            protein: 4.3,
             date: '12/12/2020',
            iron: '8%',
          },
          {
            name: 'Gingerbread',
            calories: 356,
            fat: 16.0,
            carbs: 49,
            protein: 3.9,
             date:' 12/12/2020',
            iron: '16%',
          },
          {
            name: 'Jelly bean',
            calories: 375,
            fat: 0.0,
            carbs: 94,
            protein: 0.0,
             date: '12/12/2020',
            iron: '0%',
          },
          {
            name: 'Lollipop',
            calories: 392,
            fat: 0.2,
            carbs: 98,
            protein: 0,
             date: '12/12/2020',
            iron: '2%',
          },
          {
            name: 'Honeycomb',
            calories: 408,
            fat: 3.2,
            carbs: 87,
            protein: 6.5,
             date: '12/12/2020',
            iron: '45%',
          },
          {
            name: 'Donut',
            calories: 452,
            fat: 25.0,
            carbs: 51,
            protein: 4.9,
             date: '12/12/2020',
            iron: '22%',
          },
          {
            name: 'KitKat',
            calories: 518,
            fat: 26.0,
            carbs: 65,
            protein: 7,
            iron: '6%',
          },
        ],
      }
    },
    methods: {
       getImg (calories) {
        return "https://randomuser.me/api/portraits/women/81.jpg"
      },
      generatePDF(){
        const dox = new jspdf();
        doc.text("heeloo",15,15);
        doc.save("file.pdf");
      },
       createPDF () {
            var source =  this.$refs["myTable"];
            let rows = [];
            let columnHeader = ['Nom','Prenom','Voiture','date de prise','heure de prise','Iron (%)'];
            let pdfName = 'Schedule';
            source.items.forEach(element => {
                var temp = [
                    element.StartTime,
                    element.TERMDESC,
                    element.M1 || '' + element.M4 || '' + element.M2 || '' + element.M3 || '',
                    element.T1 || '' + element.T4 || '' + element.T2 || '' + element.T3 || '',
                    element.W1 || '' + element.W4 || '' + element.W2 || '' + element.W3 || '',
                    element.R1 || '' + element.R4 || '' + element.R2 || '' + element.R3 || '',
                    element.F1 || '' + element.F4 || '' + element.F2 || '' + element.F3 || '',
                    element.S1 || '' + element.S4 || '' + element.S2 || '' + element.S3 || '',
                    element.U1 || '' + element.U4 || '' + element.U2 || '' + element.U3 || '',
                ];
                rows.push(temp);
            });
            var doc = new jsPDF();
           // doc.autoTable(columnHeader, rows, { startY: 10 });
            doc.save(pdfName + '.pdf');
        }
    
      
    },
  }
</script>
<style scoped>
.headerline{
  color:#FAC606;
}
</style>