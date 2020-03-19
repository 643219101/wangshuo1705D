var app = new Vue({
    el: '#app',
    data: {
           username:'',
           password:'',
           counter:60,
           buttonEnabled: false,

 
    },
    methods:{
       handleLoginClick(){
                     console.log('login click');
                     this.loginAdministrator();
                    
                     

                     setInterval(function () {
                      console.log('count down');
                      app.counter--;
                      app.buttonEnabled = true;
                     
                  }, 1000);
              },

           loginAdministrator(){
              axios.get('/administrator/login', {
                     params: {
                       username:this.username,
                       password:this.password
                     }
                   })
                   .then(function (response) {
                     console.log(response);
                     var dto=response.data;
                     localStorage['jcartToken'] = dto.token;
                     localStorage['expireTimestamp'] = dto.expireTimestamp;
                     alert('登陆成功');

                   })
                   .catch(function (error) {
                     console.log(error);
                   })
           }

    }
})