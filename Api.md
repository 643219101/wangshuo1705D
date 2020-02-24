## 2.1 商品后端

URL: /pruductHou/pruductlist?productname={productname}&model={model}&price={price}&quantity={quantity}
Method：GET  

ResponseBody:  
```json
[
    {
        "image":"http://a4.att.hudong.com/21/09/01200000026352136359091694357.jpg",
        "productname": "华为",
        "model": "pruduct 15",
        "price":6666,
        "quantity": 99,
        "status": 1
    },
     {
        "image":"http://a4.att.hudong.com/21/09/01200000026352136359091694357.jpg",
        "productname": "苹果",
        "model": "xsmax",
        "price":6666,
        "quantity": 99,
        "status": 1
    },
]

```

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| productname   | String   | 姓名    |
| model   | String   | 样式    |
| price   | double   | 价格    |
| quantity   | int   | 个数    |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| image   | Integer   | 面试Id    |
| productname   | String   | 姓名    |
| model   | String   | 样式    |
| price   | double   | 价格    |
| quantity   | int   | 个数    |
| status   | byte   | 状态0：未上架 1：上架    |


## 2.2 商品添加

URL: /pruductHou/addpruduct  
Request Content-Type: application/json(默认)  
Method：POST  

RequestBody:  
```json
{
    "productname": "苹果",
    "productAbstract": "内容",
    "image":"http://a4.att.hudong.com/21/09/01200000026352136359091694357.jpg",
    "model": "xsmax",
    "price":6666,
    "quantity": 99,
    "status": 1,
  
}

```

ResponseBody:  
```json
123456
```


Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| image   | Integer   | 面试Id    |
| productname   | String   | 姓名    |
| productAbstract   | String   | 商品描述    |
| model   | String   | 样式    |
| price   | double   | 价格    |
| quantity   | int   | 个数    |
| status   | byte   | 状态0：未上架 1：上架    |


## 3.1 商品前端展示

URL: /pruductQian/qianPruductlist
Method：GET  

ResponseBody:  
```json
[
    {
        "image":"http://a4.att.hudong.com/21/09/01200000026352136359091694357.jpg",
        "productname": "华为",
        "model": "pruduct 15",
        "price":6666,
        "quantity": 99,
         "productAbstract": "内容",
    },
     {
        "image":"http://a4.att.hudong.com/21/09/01200000026352136359091694357.jpg",
        "productname": "苹果",
        "model": "xsmax",
        "price":6666,
        "quantity": 99,
         "productAbstract": "内容",
    },
]


```

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| image   | Integer   | 照片    |
| productname   | String   | 姓名    |
| model   | String   | 样式    |
| price   | double   | 价格    |
| quantity   | int   | 个数    |
| productAbstract   | String   | 商品描述    |

## 3.1 后台客户列表

URL: /customerHou/customerHoulist?customerName={customerName}&email={email}&customerGroup={customerGroup}&status={status}
Method：GET  

ResponseBody:  
```json
[
    {
        "customerName": "小王",
        "email": "64329101@qq.com",
        "customerGroup":1,
        "ip": "192.168.32.1",
        "status": 1,
         "dateAdded": 1575448390345,
    },
     {
         "customerName": "小汪",
        "email": "64329101@qq.com",
        "customerGroup":1,
        "ip": "192.168.32.1",
        "status": 1,
         "dateAdded": 1575448390345,
    },
]

```

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| customerName   | String   | 姓名    |
| email   | String   | 邮箱    |
| customerGroup   | byte   | 状态0：高级 1：中等    |
| status   | byte   | 状态0：用户 1：商家    |


Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| customerName   | String   | 姓名    |
| email   | String   | 邮箱    |
| customerGroup   | byte   | 状态0：高级 1：中等    |
| ip   | spring   | ip地址    |
| status   | byte   | 状态0：用户 1：商家    |
| dateAdded   | long   | 添加时间    |

## 3.1 前端用户注册


URL: /customerHou/addCustomer  
Request Content-Type: application/json(默认)  
Method：POST  

RequestBody:  
```json
{
    "username": "admin",
    "email": "643219101@qq.com",
    "telephone":13228725698,
    "password": "123456",
    "passwordConfirm":"123456",
}

```

ResponseBody:  
```json
123456
```


Request Field  
| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| username   | String   | 用户名    |
| email   | String   | 邮箱    |
| telephone   | long   | 电话    |
| password   | string   | 密码    |
| passwordConfirm   | string   | 确认密码    |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| id   | Integer   | Id    |

## 3.1 前端用户修改

URL: /customerHou/updateCustomer  
Request Content-Type: application/json(默认)  
Method：POST  

RequestBody:  
```json
{
   "password": "123456",
    "passwordConfirm":"123456",
}

```

ResponseBody:  
```json
123456
```


Request Field  
| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| username   | String   | 用户名    |
| email   | String   | 邮箱    |
| telephone   | long   | 电话    |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| id   | Integer   | Id    |


## 3.1 前端密码修改

URL: /customerHou/updateCustomerPassword  
Request Content-Type: application/json(默认)  
Method：POST  

RequestBody:  
```json
{
    "username": "admin",
    "email": "643219101@qq.com",
    "telephone":13228725698,
}

```

ResponseBody:  
```json
123456
```


Request Field  
| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| username   | string   | 用户名    |
| email   | string   | 邮箱    |
| telephone   | long   | 电话    |


Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| id   | Integer   | Id    |


## 3.1 地址添加
URL: /address/addAddress  
Request Content-Type: application/json(默认)  
Method：POST  
RequestBody:  
```json
{
    "username": "admin",
    "content":"江苏省徐州市",
    "email": "643219101@qq.com",
    "telephone":13228725698,
}

```

ResponseBody:  
```json
123456
```


Request Field  
| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| username   | string   | 用户名    |
| email   | string   | 邮箱    |
| telephone   | long   | 电话    |
| content   | string   | 地址    |



Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| id   | Integer   | 地址id    |


## 3.1 修改地址
URL: /address/updateAddress  
Request Content-Type: application/json(默认)  
Method：POST  
RequestBody:  
```json
{
    "username": "admin",
    "content":"江苏省徐州市",
    "email": "643219101@qq.com",
    "telephone":13228725698,
}

```

ResponseBody:  
```json
123456
```


Request Field  
| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| username   | string   | 用户名    |
| email   | string   | 邮箱    |
| telephone   | long   | 电话    |
| content   | string   | 地址    |



Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| id   | Integer   | 地址id    |



## 3.1 后台订单列表
URL: /orderHou/orderList?orderID={orderID}&Customer={Customer}&orderStatus={orderStatus}&total={total}&dateAdded={dateAdded}
Method：GET  

ResponseBody:  
```json
[
    {
       
        "orderID": 1,
        "Customer": "admin",
        "orderStatus":1,
        "total": "66.6",
         "dateAdded": 1575448390345,
        "dateModified": 1575448390345,

    },
     {
          
        "orderID": 2,
        "Customer": "user",
        "orderStatus":2,
        "total": "88.8",
         "dateAdded": 1575448390345,
        "dateModified": 1575448390345,
    },
]

```

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| orderID   | int   | orderid    |
| Customer   | String   | 消费者    |
| orderStatus   | 状态   | 状态0：完成 1：不完成   |
| total   | double   | 价格    |
| dateAdded   | long   | 时间戳    |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| orderID   | int   | orderid    |
| Customer   | String   | 消费者    |
| orderStatus   | 状态   | 状态0：完成 1：不完成   |
| total   | double   | 价格    |
| dateAdded   | long   |添加时间 时间戳    |
| dateModified   | long   | 修改时间 时间戳    |


## 3.1 后台订单详细列表
URL: /orderHou/orderListXiangxi?orderID={orderID}
Method：GET  

ResponseBody:  
```json
[
    {
       
        "email": "643219101@qq.com",
        "Customer": "admin",
        "telephone":13228725698,
        "address": "上海",
        "paymentAddress":"江苏徐州",
        "prductName":"苹果",
        "model":"xsmax",
        "quantity":1,  
         "total": 1,
        "dateAdded": 1575448390345,

    },
     {
          
        "email": "643219101@qq.com",
        "Customer": "admin",
        "telephone":13228725698,
        "address": "上海",
        "paymentAddress":"江苏徐州",
        "prductName":"华为",
        "model":"P30",
        "quantity":1,  
         "total": 1,
        "dateAdded": 1575448390345,
    },
]

```

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| orderID   | int   | orderid    |


Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| Customer   | String   | 消费者    |
| total   | double   | 价格    |
| dateAdded   | long   |添加时间 时间戳    |
| email   | string   | 邮箱    |
| telephone   | long   | 电话    |
| address   | string   | 发货地址    |
| paymentAddress   | string   | 买货地址    |
| prductName   | string   | 商品名称    |
| model   | string   | 商品格式    |
| quantity   | int   | 数量    |


## 3.1 后台订单历史列表
URL: /orderHou/orderListHistory?orderID={orderID}
Method：GET  

ResponseBody:  
```json
[
    {
       
         "dateAdded": 1575448390345,
          "comment": "正在发货",
          "status":0,
        

    },
     {
          
           "dateAdded": 1575448390345,
            "comment": "快递在路上",
            "status":1,
    },
]

```

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| orderID   | int   | orderid    |


Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| dateAdded   | long   |添加时间 时间戳    |
| comment   | String   | 内容    |
| status   | int   | 状态0：完成 1：货发送    |



## 3.1 退货申请
URL: /orderReturn/orderReturnShenQing  
Request Content-Type: application/json(默认)  
Method：POST  
RequestBody:  
```json
{
    "username": "admin",
    "email": "643219101@qq.com",
    "telephone":13228725698,
    "orderId":1,
    "orderDate":1575448390345,
    "productName":"苹果",
    "productModel":"xsmax",

}

```

ResponseBody:  
```json
123456
```


Request Field  
| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| username   | string   | 用户名    |
| email   | string   | 邮箱    |
| telephone   | long   | 电话    |
| productName   | string   | 商品名称    |
| productModel   | string   | 样式    |
| orderDate   | long   |订单id 时间戳    |
| orderId   | int   |orderid   |




Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| id   | Integer   | 退货id    |


## 3.1 后台退货列表
URL: /orderReturn/orderReturnList
Method：GET  

ResponseBody:  
```json
[
    {
       
            "returnID": 1,
            "status": 0,
            "dateAdded":1575448390345,
            "orderId":1,
            "customer":"汪老板",
        

    },
     {
          
            "returnID": 2,
            "status": 0,
            "dateAdded":1575448390345,
            "orderId":1,
            "customer":"王老板",
    },
]

```


Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| returnID   | long   |returnId    |
| dateAdded   | long   | 退货时间戳    |
| orderId   | int   | orderId   |
| customer   | string   | 消费者    |

## 3.1 后台申请退货列表
URL: /orderReturn/orderReturnShenQingList
Method：GET  

ResponseBody:  
```json
[
    {
       
            "returnID": 1,
             "product": "苹果",
             "model":"xsmax",
            "status": 0,
            "dateAdded":1575448390345,
            "orderId":1,
            "customer":"刘强东",
            "dateModified": 1575448390345,

        

    },
     {
          
             "returnID": 2,
             "product": "苹果",
             "model":"xsmax",
            "status": 0,
            "dateAdded":1575448390345,
            "orderId":2,
            "customer":"马云",
            "dateModified": 1575448390345,
            
    },
]

```


Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| returnID   | long   |returnId    |
| dateAdded   | long   | 退货时间戳    |
| orderId   | int   | orderId   |
| customer   | string   | 消费者    |
| dateModified   | long   |修改时间戳    |
| productName   | string   | 商品名称    |
| productModel  | string   | 商品样式    |

## 3.1 后台退货历史列表
URL: /orderReturn/orderReturnHistory?returnId={returnId}
Method：GET  

ResponseBody:  
```json
[
    {
       
         "dateAdded": 1575448390345,
          "comment": "待检验",
          "status":0,
        

    },
     {
          
           "dateAdded": 1575448390345,
            "comment": "已寄送新产品",
            "status":1,
    },
]

```

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| orderID   | int   | orderid    |


Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| dateAdded   | long   |添加时间 时间戳    |
| comment   | String   | 内容    |
| status   | int   | 状态0：待检验  1：已寄送新产品    |

## 3.1 管理员列表


URL: /user/userList
Method：GET  

ResponseBody:  
```json
[
    {
       
         "dateAdded": 1575448390345,
          "username": "马云",
          "status":0,
        

    },
     {
          
           "dateAdded": 1575448390345,
            "username": "王健林",
            "status":1,
    },
]

```




Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| dateAdded   | long   |添加时间 时间戳    |
| comment   | String   | 内容    |
| status   | int   | 状态0：不是管理员  1：是管理员    |

