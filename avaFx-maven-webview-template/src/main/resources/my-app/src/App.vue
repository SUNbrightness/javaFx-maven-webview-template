<template>
  <v-app>
            <v-app-bar
              app
              color="light-blue"
              dark
>
              <v-toolbar-title>A922备份</v-toolbar-title>
              <v-spacer />
              <v-row justify="space-around">
                  <v-switch v-model="autoBackUp" class="pt-5" label="自动备份" @change="change" />
               </v-row>
              
            </v-app-bar>
    <v-main>
      <index />
    </v-main>
  </v-app>
</template>

<script>
import Index from './view/Index';

export default {
  name: 'App',

  components: {
    Index,
  },
  data: () => ({
    autoBackUp:true
  }),
  methods:{
      change(any){
          window.JC.setAutoBackUp(any);
      }
  }
};
</script>
<style>
    
</style>
