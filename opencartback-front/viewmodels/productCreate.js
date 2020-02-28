var app = new Vue({
    el: '#app',
    data: {
        productCode: '',
        productName: '',
        price: '',
        discount: '',
        stockQuantity: '',
        rewordPoints: '',
        sortOrder: '',
        productAbstract:'',
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
        tinymce.init({
            selector: '#mytextarea'
        });
    },

    methods:{
            createClick(){
               console.log('click create');
               this.description = tinyMCE.activeEditor.getContent();

               this.createProduct();
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
           createProduct(){
            axios.post('/product/create', {
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