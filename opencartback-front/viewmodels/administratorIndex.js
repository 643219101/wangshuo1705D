var app = new Vue({
    el: '#app',
    data: {
          pageInfo:'',
          pageNum:1,
          selectedadminIds:[],

    },

    computed:{
      selectAdminIda(){
          return this.selectedadminIds.map(a=>a.administratorId);
      }
    },
      mounted(){
          console.log('view mounted')
            this.getAdministrators();
      },
 
    methods:{
        handleSelectionChange(val){
            console.log('duo xuan kuang change',val);
            this.selectedadminIds=val;

        },
        handleBatchDeleteClick(){
            axios.post('/administrator/batchDelete', this.selectAdminIda)
                .then(function (response) {
                    console.log(response);
                    alert('批删成功');
                    location.reload();
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
          
        handleDelete(index,row){
            console.log('delete one  click')
            if (confirm("确认删除？")) {
                this.deleteAdministrator(row.administratorId);
            }

        },
        deleteAdministrator(administratorId) {
            axios.post('/administrator/delete', administratorId, {
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(function (response) {
                    console.log(response);
                    alert('删除成功');
                    location.reload();
                })
                .catch(function (error) {
                    console.log(error);
                });
        },




        handlePageChange(val){
       console.log('page change',val);
       this.pageNum=val; 
       this.getAdministrators();
        },
        getAdministrators() {
            axios.get('/administrator/getList', {
                params: {
                    pageNum: this.pageNum
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.pageInfo = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }

    }
})