var app = new Vue({
    el: '#app',
    data: {
        pageInfo:'',
        pageNum:1 

    },
    mounted(){
         this.searchCutomer();
    },
    methods:{
        pageChange(val){
  this.pageNum=val;
  this.searchCutomer();

        },
         searchCutomer(){
            axios.get('/customer/search')
            .then(function (response) {
              // handle success
              console.log(response);
              app.pageInfo=response.data;
            })
            .catch(function (error) {
              // handle error
              console.log(error);
            })
         
         }
    }
})