var app = new Vue({
    el: '#app',
    data: {
        pageInfo:'',
        pageNum:1,
        statuses: [
            { value: 0, label: '禁用' },
            { value: 1, label: '启用' },
            { value: 2, label: '不安全' }
        ]

    },
    mounted(){
         this.searchCutomer();
    },
    methods:{
        pageChange(val){
          this.pageNum=val;
          this.searchCutomer();

        },
        handleUpdateStatus(index,row){
          this.updateCustomerStatus(row.customerId, row.status);

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
         
         },
         updateCustomerStatus(customerId, status) {
          axios.post('/customer/setStatus', {
              customerId: customerId,
              status: status
          })
              .then(function (response) {
                  console.log(response);
                  alert('状态更新成功');
              })
              .catch(function (error) {
                  console.log(error);
              });
      }
    }
})