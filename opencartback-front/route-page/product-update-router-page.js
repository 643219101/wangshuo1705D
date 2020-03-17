const productlistupdaterouter = {
    template: `
    <div id="app">
    <el-button type="primary" @click="handleCreateClick">添加商品</el-button>
        <br><br>
      
    <el-button type="primary" @click="shangyijiclick"><<<<<<<<返回上一级</el-button>

        <el-input v-model="productCode" placeholder="请输入商品代码" readonly></el-input>
        <el-input v-model="productName" placeholder="请输入商品名称"></el-input>
        <el-input v-model="price" placeholder="请输入价格"></el-input>
        <el-input v-model="discount" placeholder="请输入打折"></el-input>
        <el-input v-model="stockQuantity" placeholder="请输入库存量"></el-input>
        <el-input v-model="rewordPoints" placeholder="请输入积分"></el-input>
        <el-input v-model="sortOrder" placeholder="请输入排序"></el-input>
        <el-input v-model="productAbstract" type="textarea" placeholder="请输入摘要"></el-input>

        <textarea id="mytextarea">{{description}}</textarea>
        <el-select v-model="selectedStatus" placeholder="请选择状态">
            <el-option v-for="item in statuses" :key="item.value" :label="item.label" :value="item.value">
            </el-option>
        </el-select>
        <el-upload ref="uploadMain" action="" :http-request="uploadMainImage" :limit="1" accept="image/*"
        :auto-upload="false" :on-change="handleOnMainChange" :file-list="mainFileList">
        <el-button slot="trigger" size="small" type="primary">选取主图</el-button>
        <el-button size="small" type="success" @click="handleUploadMainClick">上传</el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件</div>
    </el-upload>
    上传后主图：<el-link type="primary">{{mainPicUrl}}</el-link>
    <el-image style="width: 100px; height: 100px" :src="mainPicUrl" :fit="fit"></el-image>

            <br>
    
    
            <el-upload ref="uploadOther" multiple action="" :http-request="uploadOtherImage" :limit="9" accept="image/*"
            :auto-upload="false" :on-change="handleOnOtherChange" :on-remove="handleOnOtherRemove" :file-list="otherFileList">
            <el-button slot="trigger" size="small" type="primary">选取其他图片</el-button>
            <el-button size="small" type="success" @click="handleUploadOtherClick">上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件</div>
            </el-upload>
            上传后其他图片：
            <br>
            <div v-for="item in otherPicUrls">
                上传后其他图片：
                <el-link type="primary">{{item}}</el-link><br>
                <el-image style="width: 60px; height: 60px" :src="item" :fit="fit" :preview-src-list="item"></el-image>
                <br>
            </div>
            <br>
            <br>
    
        <el-button type="primary" @click="createClick">修改</el-button>
    
    </div>
    `,
    data() {
        return{
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
        }
      
    },

    mounted(){
       console.log('view mounted');
      //  var url = new URL(location.href);
      //  this.productId = url.searchParams.get("productId");
      //  if (!this.productId) {
      //      alert('productId is null');
      //      return; this.$route.params.productId
      //  }
      this.productId = this.$route.params.productId;
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
      handleCreateClick(){
        this.$router.push('/product/create');
    },
    
      shangyijiclick(){
         app.selectMainPage='1-1';
         this.$router.push('/product/search');

      },
        getByID(){
            axios.get('/product/getById', {
                params: {
                    productId:this.productId
                }
              })
              .then((response)=> {
                console.log(response);
                var product = response.data;
                    this.productId = product.productId;
                    this.productCode = product.productCode;
                    this.productName = product.productName;
                    this.price = product.price;
                    this.discount = product.discount;
                    this.stockQuantity = product.stockQuantity;
                    this.selectedStatus = product.status;
                    this.rewordPoints = product.rewordPoints;
                    this.sortOrder = product.sortOrder;
                    this.mainPicUrl = product.mainPicUrl;
                    this.description = product.description;
                    this.otherPicUrls = product.otherPicUrls;
                    this.productAbstract=product.productAbstract;
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
            .then((response)=> {
                console.log(response);
                this.mainPicUrl = response.data;
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
              .then((response)=> {
                  console.log(response);
                  var url = response.data;
                  this.otherPicUrls.push(url);
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
        .then((response)=> {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error);
        });


       }


}
}