package com.wangshuo.opencartstore.controller;

import com.github.pagehelper.Page;
import com.wangshuo.opencartstore.dto.in.ReturnApplyInDTO;
import com.wangshuo.opencartstore.dto.out.PageOutDTO;
import com.wangshuo.opencartstore.dto.out.ReturnHistoryListOutDTO;
import com.wangshuo.opencartstore.dto.out.ReturnListOutDTO;
import com.wangshuo.opencartstore.dto.out.ReturnShowOutDTO;

import com.wangshuo.opencartstore.enumeration.ReturnStatus;
import com.wangshuo.opencartstore.po.Return;
import com.wangshuo.opencartstore.po.ReturnHistory;
import com.wangshuo.opencartstore.service.OrderService;
import com.wangshuo.opencartstore.service.ReturnHistoryService;
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

    @Autowired
    private ReturnHistoryService returnHistoryService;

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
        Return aReturn = returnService.getById(returnId);

        ReturnShowOutDTO returnShowOutDTO = new ReturnShowOutDTO();
        returnShowOutDTO.setReturnId(aReturn.getReturnId());
        Long orderId = aReturn.getOrderId();
        int ii = Integer.parseInt(String.valueOf(orderId));
        returnShowOutDTO.setOrderId(ii);
        returnShowOutDTO.setOrderTimestamp(aReturn.getOrderTime().getTime());
        returnShowOutDTO.setCustomerName(aReturn.getCustomerName());
        returnShowOutDTO.setMobile(aReturn.getMobile());
        returnShowOutDTO.setEmail(aReturn.getEmail());
        returnShowOutDTO.setStatus(aReturn.getStatus());
        returnShowOutDTO.setAction(aReturn.getAction());
        returnShowOutDTO.setProductCode(aReturn.getProductCode());
        returnShowOutDTO.setProductName(aReturn.getProductName());
        returnShowOutDTO.setQuantity(aReturn.getQuantity());
        returnShowOutDTO.setReason(aReturn.getReason());
        returnShowOutDTO.setComment(aReturn.getComment());
        returnShowOutDTO.setOpened(aReturn.getOpened());
        returnShowOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
        returnShowOutDTO.setUpdateTimestamp(aReturn.getUpdateTime().getTime());

        List<ReturnHistory> returnId1 = returnHistoryService.getReturnId(returnId);
        List<ReturnHistoryListOutDTO> collect = returnId1.stream().map(returnHistory -> {
            ReturnHistoryListOutDTO returnHistoryListOutDTO = new ReturnHistoryListOutDTO();
            returnHistoryListOutDTO.setTimestamp(returnHistory.getTime().getTime());
            returnHistoryListOutDTO.setReturnStatus(returnHistory.getReturnStatus());
            returnHistoryListOutDTO.setComment(returnHistory.getComment());
            return returnHistoryListOutDTO;
        }).collect(Collectors.toList());
        returnShowOutDTO.setReturnHistories(collect);
        return returnShowOutDTO;
    }

    @PostMapping("/cancel")
    public void cancel(@RequestBody Integer returnId){

    }

}
