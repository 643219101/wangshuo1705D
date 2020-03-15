const routes = [
    
    { path: '/product/search', component: ProductSearchRoutePage },
    { path: '/customer/search', component: consumerlistpage },
    { path: '/administrator/getList', component: adminlistrouterpage },


];

const router = new VueRouter({
    routes: routes
});