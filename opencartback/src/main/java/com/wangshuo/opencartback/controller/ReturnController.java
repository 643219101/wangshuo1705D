package com.wangshuo.opencartback.controller;

import com.wangshuo.opencartback.dto.in.ReturnApplyInDTO;
import com.wangshuo.opencartback.dto.in.ReturnSearchInDTO;
import com.wangshuo.opencartback.dto.in.ReturnUpdateActionInDTO;
import com.wangshuo.opencartback.dto.out.PageOutDTO;
import com.wangshuo.opencartback.dto.out.ReturnListOutDTO;
import com.wangshuo.opencartback.dto.out.ReturnShowOutDTO;
import com.wangshuo.opencartback.enumeration.ReturnStatus;
import com.wangshuo.opencartback.po.Return;
import com.wangshuo.opencartback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnController {

    @Autowired
    private ReturnService returnService;



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
