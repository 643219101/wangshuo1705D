package com.wangshuo.opencartstore.controller;

import com.wangshuo.opencartstore.dto.in.ReturnApplyInDTO;
import com.wangshuo.opencartstore.dto.out.PageOutDTO;
import com.wangshuo.opencartstore.dto.out.ReturnListOutDTO;
import com.wangshuo.opencartstore.dto.out.ReturnShowOutDTO;

import com.wangshuo.opencartstore.enumeration.ReturnStatus;
import com.wangshuo.opencartstore.po.Return;
import com.wangshuo.opencartstore.service.OrderService;
import com.wangshuo.opencartstore.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.Date;

@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnController {
@Autowired
private ReturnService returnService;
    @PostMapping("apply")
    public  Integer apply(@RequestBody ReturnApplyInDTO returnApplyInDTO,
                          @RequestAttribute Integer customerId){
        Return aReturn = new Return();
        Integer orderId = returnApplyInDTO.getOrderId();
        Long orderIdd= new Long((long)orderId);
        aReturn.setOrderId(orderIdd);
        aReturn.setCustomerId(customerId);
        aReturn.setOrderTime(new Date(returnApplyInDTO.getOrderTimestamp()));
        aReturn.setCustomerName(returnApplyInDTO.getCustomerName());
        aReturn.setMobile(returnApplyInDTO.getMobile());
        aReturn.setEmail(returnApplyInDTO.getEmail());
        aReturn.setQuantity(returnApplyInDTO.getQuantity());
        aReturn.setStatus((byte) ReturnStatus.ToProcess.ordinal());
        aReturn.setProductCode(returnApplyInDTO.getProductCode());
        aReturn.setProductName(returnApplyInDTO.getProductName());
        aReturn.setOpened(returnApplyInDTO.getOpened());
        aReturn.setComment(returnApplyInDTO.getComment());
        aReturn.setReason(returnApplyInDTO.getReason());
        Date date = new Date();
        aReturn.setCreateTime(date);
        aReturn.setUpdateTime(date);
        returnService.create(aReturn);
        Integer returnId = aReturn.getReturnId();

        return  returnId;


    }


    @GetMapping("/getList")
    public PageOutDTO<ReturnListOutDTO> getList(@RequestAttribute Integer customerId,
                                                @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/cancel")
    public void cancel(@RequestBody Integer returnId){

    }

}
