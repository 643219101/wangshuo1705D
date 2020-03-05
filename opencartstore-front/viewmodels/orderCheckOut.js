var app = new Vue({
    el: '#app',
    data: {
        shipMethods: [
            { value: 0, label: 'EMS' },
            { value: 1, label: '顺丰' },
            { value: 2, label: '圆通' },
            { value: 3, label: '中通' },
            { value: 4, label: '申通' }
        ],
        payMethods: [
            { value: 0, label: '货到付款' },
            { value: 1, label: '借记卡' },
            { value: 2, label: '信用卡' },
            { value: 3, label: '微信支付' },
            { value: 4, label: '支付宝' }
        ],
        selectedShipAddressId: '',
        selectShipMethod: '',
        selectedInvoiceAddredssId: '',
        selectedPayMethod: '',
   
    }
})