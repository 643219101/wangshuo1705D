const routes = [
    
    { path: '/product/search', component: ProductSearchRoutePage },
    { path: '/product/update/:productId', component: productlistupdaterouter },
    { path: '/product/create', component: productcreaterouter },

    { path: '/customer/search', component: consumerlistpage },
    { path: '/customer/show/:customerId', component: consumershowrouterpage },


    { path: '/administrator/getList', component: adminlistrouterpage },


];

const router = new VueRouter({
    routes: routes
});