var app = new Vue({
    el: '#app',
    data: {
        myShoppingCart:[]

    },
    mounted(){
               console.log('shopping  cart')
               var myShoppingCartJson = localStorage['myShoppingCartJson'];
               this.myShoppingCart = myShoppingCartJson ? JSON.parse(myShoppingCartJson) : [];

    }
})