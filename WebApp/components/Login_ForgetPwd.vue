<template>
  <v-stepper v-model="e1">
    <v-stepper-items>
      <v-stepper-content step="1">   
          <v-row>
      <v-col
          cols="12"
          md="6"
        >  
          <v-card
          class="rounded-card1"
          width="600px"
            color="#333333"
            height="500px"
          >
          <v-card-title> <h3 style="text-align:center;">Bienvenue</h3></v-card-title>
          <v-card-text>
            <div>
          <v-form
          
                        ref="form"
                        v-model="valid"
                        lazy-validation
                        
                      >
                      <v-icon color="white"> mdi-user</v-icon>
                    <v-text-field
                      v-model="email"
                      :rules="emailRules"
                      label="E-mail"
                      required
                     solo
                     
                     
                    >
                    </v-text-field>
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
                      solo
                    ></v-text-field>
                    </v-form>
                    </div>
                        <v-btn
              color="#FAC606"
             
              rounded
              to="/home"
            >
              Se Connecter
            </v-btn>
            <v-btn text
            color="#FAC606"
            @click="e1 =2"
              rounded>
              Changer Mot De passe
            </v-btn>
       
          </v-card-text>
                <v-card-actions>
    
                </v-card-actions>
              </v-card>
  
      </v-col>
        <v-col
          cols="12"
          md="6"
        > 
        <v-img src="/carPic.png"></v-img>
        </v-col>
      </v-row>
      </v-stepper-content>

      <v-stepper-content step="2">
        <v-row>
          <v-col
          cols="12"
          md="6"
        > 
        <v-img src="/carPic.png"></v-img>
        </v-col>
          <v-col
          cols="12"
          md="6"
        > 
        <v-card
          width="800px"
            color="#333333"
            height="500px"
            class="rounded-card2"
        >
         <v-card-title> <h3 style="text-align:center;">Bienvenue</h3></v-card-title>
        <v-card-text>
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
                     solo
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
                      solo
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
                      solo
                    ></v-text-field>
                    </v-form>
  
           <v-btn
          color="#FAC606"
          @click="e1 = 1"
          rounded
        >
          Continue
        </v-btn>
        <v-btn text
        color="#FAC606"
         @click="e1 = 1"
          rounded>
          Cancel
        </v-btn>
        </v-card-text>
        
        
        </v-card>
          </v-col>
        </v-row>
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
<style scoped>
h3{
  font: bold;
  color:#FAC606 ;
  text-align: center;
  margin-top: 20%;
  align-content: center;
}
.v-form{
max-width: 400px;
align-items: center;
}
.rounded-card1{
    border-bottom-right-radius: 50px;
    border-top-right-radius: 50px;
}
.rounded-card2
{
  border-bottom-left-radius: 50px;
    border-top-left-radius: 50px;
}
</style>