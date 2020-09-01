<template>
    <div>
         <v-list two-line subheader>
                
                <v-list-item
                  v-for="item in items"
                  :key="item.title"
                >
                  <v-list-item-avatar>
                    <v-icon
                      class="light-blue lighten-1 white--text"
                      v-text="item.icon"
                    />
                  </v-list-item-avatar>
          
                  <v-list-item-content>
                    <v-list-item-title>{{ item.title }}</v-list-item-title>
                    <v-list-item-subtitle>{{ item.subtitle }}</v-list-item-subtitle>
                  </v-list-item-content>
          
                  <v-list-item-action>
                    <v-btn icon>
                      <v-icon color="grey lighten-1">
mdi-information
</v-icon>
                    </v-btn>
                  </v-list-item-action>
                </v-list-item>
                
                <v-divider inset />
                <v-subheader>未知眼镜</v-subheader>
                <v-list-item
                  v-for="item in items"
                  :key="item.subtitle"
                >
                  <v-list-item-avatar>
                    
                    <v-icon
                    class="grey lighten-1 white--text"
                      v-text="item.icon"
                    />
                  </v-list-item-avatar>
                          
                  <v-list-item-content>
                    <v-list-item-title>{{ item.title }}</v-list-item-title>
                    <v-list-item-subtitle>{{ item.subtitle }}</v-list-item-subtitle>
                  </v-list-item-content>
                          
                  <v-list-item-action>
                    <v-btn icon>
                      <v-icon color="grey lighten-1">
mdi-information
</v-icon>
                    </v-btn>
                  </v-list-item-action>
                </v-list-item>
              </v-list>
    </div>
</template>

<script>
    export default {
    
      name: '',
    
      components: {},
    
      mixins: [],
    
      props: {},
    
      data() {return {
          items: [
                { icon: 'mdi-usb', title: 'Photos', subtitle: 'Jan 9, 2014' },
                { icon: 'mdi-usb',  title: 'Recipes', subtitle: 'Jan 17, 2014' },
                { icon: 'mdi-usb',  title: 'Work', subtitle: 'Jan 28, 2014' },
              ]
      }},
    
      computed: {},
    
      watch: {},
    
      created() {
          window.JL.changeUsb=this.changeUsb;
      },
    
      mounted() {},
    
      destroyed() {},
    
      methods: {
          changeUsb(val){
              console.log(val)
          }
      },
    
    };
</script>

<style>
</style>
