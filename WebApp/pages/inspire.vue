<template>
  <div>
   
      
      <v-btn
        color="primary"
        class="ma-2"
        dark
        @click="dialog3 = true"
      >
        Open Dialog 3
      </v-btn>
      
     
      <v-dialog
        v-model="dialog3"
        max-width="500px"
      >
        <v-card>
          <v-card-title>
            <span>Dialog 3</span>
            <v-spacer></v-spacer>
           
          </v-card-title>
          <v-card-actions>
            <v-btn
              color="primary"
              text
              @click="dialog3 = false"
            >
              Close
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>

  </div>
</template>
<script>
  export default {
    data () {
      return {
        dialog: false,
        dialog3: false,
        notifications: false,
        sound: true,
        widgets: false,
        items: [
          {
            title: 'Click Me',
          },
          {
            title: 'Click Me',
          },
          {
            title: 'Click Me',
          },
          {
            title: 'Click Me 2',
          },
        ],
        select: [
          { text: 'State 1' },
          { text: 'State 2' },
          { text: 'State 3' },
          { text: 'State 4' },
          { text: 'State 5' },
          { text: 'State 6' },
          { text: 'State 7' },
        ],
      }
    },
  }
</script>