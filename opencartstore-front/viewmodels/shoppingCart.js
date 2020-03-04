var app = new Vue({
    el: '#app',
    data: {
        myShoppingCart:[]

    },
    methods:{ 
        handleUpdate(index, row){
            console.log('update click');
            localStorage['myShoppingCartJson'] = JSON.stringify(this.myShoppingCart);
            this.$message.success('修改购物车成功');
        },
        handleDelete(index, row){
            if (confirm('确定删除？')) {
                //删除localstorage 根据下标 的数据
                this.myShoppingCart.splice(index, 1);
                localStorage['myShoppingCartJson'] = JSON.stringify(this.myShoppingCart);
                this.$message.success('删除购物车成功');
            }

        }
    },
    mounted(){
               console.log('shopping  cart')
               var myShoppingCartJson = localStorage['myShoppingCartJson'];
               this.myShoppingCart = myShoppingCartJson ? JSON.parse(myShoppingCartJson) : [];


    }
    
})