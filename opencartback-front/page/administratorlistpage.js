Vue.component('wangshuo-administrator-list-page', {
    template: `
    <div id="app">
        <el-button type="danger" @click="handleBatchDeleteClick">批量删除</el-button>

        <el-table :data="pageInfo.list" style="width: 100%" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55">
            </el-table-column>
            <el-table-column prop="administratorId" label="Id">
            </el-table-column>
            <el-table-column prop="username" label="用户名">
            </el-table-column>
            <el-table-column prop="realName" label="姓名">
            </el-table-column>
            <el-table-column prop="status" label="状态">
            </el-table-column>
            <el-table-column prop="createTimestamp" label="创建时间">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-pagination layout="prev, pager, next" :total="pageInfo.total" @current-change="handlePageChange">
        </el-pagination>
     

    </div>
    `,
    data() {
        return{
             pageInfo:'',
        pageNum:1,
        selectedadminIds:[],


        }
       

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
              .then( (response)=> {
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
              .then((response)=> {
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
              .then((response)=> {
                  console.log(response);
                  this.pageInfo = response.data;
              })
              .catch(function (error) {
                  console.log(error);
              });
      }

  }
})