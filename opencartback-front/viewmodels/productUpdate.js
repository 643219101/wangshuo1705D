var app = new Vue({
    el: '#app',
    data: {
        productId: '',
        productCode: '',
        productName: '',
        price: '',
        discount: '',
        stockQuantity: '',
        rewordPoints: '',
        productAbstract:'',
        sortOrder: '',
        description: '',
        selectedStatus:'',
        selectedMainPic:'',
        mainPicUrl:'',
        selectedOtherPics:[],
        otherPicUrls:[],
        statuses:[
            {
                value: 0,
                label: '下架'
              }, {
                value: 1,
                label: '上架'
              }, {
                value: 2,
                label: '审核'
              }

        ],
        mainFileList:[],
        otherFileList:[]
    },
    mounted(){
       console.log('view mounted');
       var url = new URL(location.href);
       this.productId = url.searchParams.get("productId");
       if (!this.productId) {
           alert('productId is null');
           return;
       }

       this.getByID();
       tinymce.init({
        selector: '#mytextarea'
    });
    },
    methods:{
        getByID(){
            axios.get('/product/getById', {
                params: {
                    productId:this.productId
                }
              })
              .then(function (response) {
                console.log(response);
                var product = response.data;
                    app.productId = product.productId;
                    app.productCode = product.productCode;
                    app.productName = product.productName;
                    app.price = product.price;
                    app.discount = product.discount;
                    app.stockQuantity = product.stockQuantity;
                    app.selectedStatus = product.status;
                    app.rewordPoints = product.rewordPoints;
                    app.sortOrder = product.sortOrder;
                    app.mainPicUrl = product.mainPicUrl;
                    app.description = product.description;
                    app.otherPicUrls = product.otherPicUrls;
                    app.productAbstract=product.productAbstract;
              })
              .catch(function (error) {
                console.log(error);
              })
        },


        createClick(){
           console.log('click create')
           this.description = tinyMCE.activeEditor.getContent();
           this.updateProduct();
        },
        handleOnMainChange(val) {
          this.selectedMainPic = val.raw;
      },
      handleUploadMainClick() {
          console.log('upload main pic click');
          this.uploadMainImage();
      },
        uploadMainImage() {
          var formData = new FormData();
        formData.append("image", this.selectedMainPic);

        axios.post('/image/upload', formData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        })
            .then(function (response) {
                console.log(response);
                app.mainPicUrl = response.data;
                alert('上传成功');
            })
            .catch(function (error) {
                console.log(error);
               
            });


      },
    
      handleOnOtherChange(file,fileList){
         this.selectedOtherPics=fileList;
      },
      handleOnOtherRemove(file,fileList){
        this.selectedOtherPics=fileList;

      },
      handleUploadOtherClick(){
         console.log('other pic pic click  ');
         this.uploadOtherImage();
      },
    
      uploadOtherImage(){
        this.selectedOtherPics.forEach(pic => {
          var formData = new FormData();
          formData.append("image", pic.raw);

          axios.post('/image/upload', formData, {
              headers: {
                  'Content-Type': 'multipart/form-data'
              }
          })
              .then(function (response) {
                  console.log(response);
                  var url = response.data;
                  app.otherPicUrls.push(url);
              })
              .catch(function (error) {
                  console.log(error);
                  alert('上传失败');
              });
      });

      },
       updateProduct(){
        axios.post('/product/update', {
          productId:this.productId,
            productCode: this.productCode,
            productName: this.productName,
            price: this.price,
            discount: this.discount,
            stockQuantity: this.stockQuantity,
            status: this.selectedStatus,
            mainPicUrl: this.mainPicUrl,
            rewordPoints: this.rewordPoints,
            sortOrder: this.sortOrder,
            description: this.description,
            otherPicUrls: this.otherPicUrls,
            productAbstract:this.productAbstract

        })
        .then(function (response) {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error);
        });


       }


}

 
  

})