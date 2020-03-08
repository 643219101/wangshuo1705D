package com.wangshuo.opencartstore.controller;

import com.github.pagehelper.Page;
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
import java.util.List;
import java.util.stream.Collectors;

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
                                                @RequestParam(required =false,defaultValue = "1")Integer pageNum){
        Page<Return> page = returnService.getPageByCustomerId(customerId, pageNum);
        List<ReturnListOutDTO> collect = page.stream().map(aReturn -> {
            ReturnListOutDTO returnListOutDTO = new ReturnListOutDTO();
            returnListOutDTO.setReturnId(aReturn.getReturnId());
            returnListOutDTO.setOrderId(aReturn.getOrderId());
            returnListOutDTO.setCustomerId(aReturn.getCustomerId());
            returnListOutDTO.setCustomerName(aReturn.getCustomerName());
            returnListOutDTO.setStatus(aReturn.getStatus());
            returnListOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
            return returnListOutDTO;
        }).collect(Collectors.toList());


        PageOutDTO<ReturnListOutDTO> pageOutDTO = new PageOutDTO<>();
        long total = page.getTotal();
        int a= (int) total;
        pageOutDTO.setTotal(a);
       pageOutDTO.setPageSize(page.getPageSize());
       pageOutDTO.setPageNum(page.getPageNum());
       pageOutDTO.setList(collect);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/cancel")
    public void cancel(@RequestBody Integer returnId){

    }

}
