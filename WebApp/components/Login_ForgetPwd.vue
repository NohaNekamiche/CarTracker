<template>
  <v-stepper v-model="e1">
    <v-stepper-items>
      <v-stepper-content step="1">     
          <v-card
          width="800px"
            color="#f2f2f2"
            height="500px"
          >
          <v-form
                        ref="form"
                        v-model="valid"
                        lazy-validation
                      >
                    <v-text-field
                      v-model="email"
                      :rules="emailRules"
                      label="E-mail"
                      required
                      outlined
                    ></v-text-field>
                    <v-text-field
                      v-model="password"
                      :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
                      :rules="[rules.required, rules.min]"
                      :type="show1 ? 'text' : 'password'"
                      name="input-10-1"
                      label="Normal with hint text"
                      hint="At least 8 characters"
                      counter
                      @click:append="show1 = !show1"
                      outlined
                    ></v-text-field>
                    </v-form>
             
                <v-card-actions>
                  <v-btn
                    outlined
                    rounded
                    text
                  >
                    Button
                  </v-btn>
                </v-card-actions>
              </v-card>
            <v-card-actions>  
              <v-btn
              color="primary"
              @click="e1 = 2"
            >
              Continue
            </v-btn>

            <v-btn
              color="primary"
              to="/carstable"
            >
              login
            </v-btn>
            </v-card-actions>
    
        
      </v-stepper-content>

      <v-stepper-content step="2">
        <v-card
          class="mb-12"
          color="grey lighten-1"
          height="500px"
        >
        <v-card-text>
           <v-btn
          color="primary"
          @click="e1 = 1"
        >
          Continue
        </v-btn>
        <v-btn text>
          Cancel
        </v-btn>
        </v-card-text>
        
        
        </v-card>

       
      </v-stepper-content>

    </v-stepper-items>
  </v-stepper>
</template>

<script>
  export default {
    data () {
      return {
        e1: 1,
        show1:false,
        email: '',
         password: 'Password',
        rules: {
          required: value => !!value || 'Required.',
          min: v => v.length >= 8 || 'Min 8 characters',
          emailMatch: () => (`The email and password you entered don't match`),
        },
        emailRules: [
        v => !!v || 'E-mail is required',
        v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
        ],
        items: [
         {
         
          to: '/DriversTable'
        },]
      }
    },
  }
</script>