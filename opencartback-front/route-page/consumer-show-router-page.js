const consumershowrouterpage = {
    template: `<div id="app">
    <el-button type="primary" @click="shangyijiclick"><<<<<<<<返回上一级</el-button>

    客户用户名：{{username}} <br>
    客户姓名：{{realName}} <br>
    客户头像：{{avatarUrl}} <br>
    手机：{{mobile}} <br>
    邮箱：{{email}} <br>
    状态：{{status}} <br>
    注册时间：{{createTimestamp}} <br>
    订阅新闻：{{newsSubscribed}} <br>
    积分：{{rewordPoints}} <br>
    默认地址：{{defaultAddress}} <br>
</div>`,
data(){
    return{
        customerId: '',
        username: '',
        realName: '',
        avatarUrl: '',
        mobile: '',
        email: '',
        status: '',
        createTimestamp: '',
        newsSubscribed: '',
        rewordPoints: '',
        defaultAddressId: '',
        defaultAddress: ''
    
    }
  
},
mounted(){
    this.customerId = this.$route.params.customerId;
      if (!this.customerId) {
            alert('productId is null');
            return;
        }

    this.getCustomerById();
},
methods: {
    shangyijiclick(){
        this.$router.push('/customer/search');

     },
    getCustomerById() {
        axios.get('/customer/getById', {
            params: {
                customerId: this.customerId
            }
        })
            .then( (response)=> {
                console.log(response);
                var customer = response.data;
                this.username = customer.username;
                this.realName = customer.realName;
                this.avatarUrl = customer.avatarUrl;
                this.mobile = customer.mobile;
                this.email = customer.email;
                this.status = customer.status;
                this.createTimestamp = customer.createTimestamp;
                this.newsSubscribed = customer.newsSubscribed;
                this.rewordPoints = customer.rewordPoints;
                this.defaultAddressId = customer.defaultAddressId;
                this.defaultAddress = customer.defaultAddress;
            })
            .catch(function (error) {
                console.log(error);
            });
    }
}

}