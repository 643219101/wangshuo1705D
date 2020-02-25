package com.wangshuo.opencartstore.controller;

import com.wangshuo.opencartstore.dto.in.ReturnApplyInDTO;
import com.wangshuo.opencartstore.dto.out.PageOutDTO;
import com.wangshuo.opencartstore.dto.out.ReturnListOutDTO;
import com.wangshuo.opencartstore.dto.out.ReturnShowOutDTO;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/return")
public class ReturnController {

    @PostMapping("/apply")
    public Integer apply(@RequestBody ReturnApplyInDTO returnApplyInDTO,
                         @RequestAttribute Integer customerId){
        return null;
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
