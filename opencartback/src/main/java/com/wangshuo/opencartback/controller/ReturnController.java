package com.wangshuo.opencartback.controller;

import com.wangshuo.opencartback.dto.in.ReturnSearchInDTO;
import com.wangshuo.opencartback.dto.in.ReturnUpdateActionInDTO;
import com.wangshuo.opencartback.dto.out.PageOutDTO;
import com.wangshuo.opencartback.dto.out.ReturnListOutDTO;
import com.wangshuo.opencartback.dto.out.ReturnShowOutDTO;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/return")
public class ReturnController {

    @GetMapping("/search")
    public PageOutDTO<ReturnListOutDTO> search(ReturnSearchInDTO returnSearchInDTO,
                                               @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/updateAction")
    public void updateAction(@RequestBody ReturnUpdateActionInDTO returnUpdateActionInDTO){

    }

}
