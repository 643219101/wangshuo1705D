var app = new Vue({
    el: '#app',
    data: {
           myProducts:[]

    },
    mounted(){
               console.log('shopping  cart')
               var myShoppingCartJson = localStorage['myShoppingCartJson'];
               this.myProducts = myShoppingCartJson ? JSON.parse(myShoppingCartJson) : [];

    }
})