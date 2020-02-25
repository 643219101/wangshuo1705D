package com.wangshuo.opencartback.controller;

import com.wangshuo.opencartback.dto.in.*;
import com.wangshuo.opencartback.dto.out.AdministratorGetProfileOutDTO;
import com.wangshuo.opencartback.dto.out.AdministratorListOutDTO;
import com.wangshuo.opencartback.dto.out.AdministratorShowOutDTO;
import com.wangshuo.opencartback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @GetMapping("/login")
    public  String login(AdministratorLoginInDTO administratorLoginInDTO){


        return  null;
    }

    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfile(@RequestParam(required = false) Integer adminstratorId){
        return null;
    }

    @PostMapping("/updateProdfile")
    public  void updateProdfile(@RequestBody AdministratorUpdateProfileInDTO administratorUpdateProfileInDTO){

    }
    @GetMapping("getPwdResetCode")
    public  String getPwdResetCode(String  email){
        return  null;
    }

    @PostMapping("/resetPwd")
     public  void resetPwd(@RequestBody AdministratorResetPwdInDTO administratorResetPwdInDTO){

    }

   @GetMapping("/getlist")
      public PageOutDTO<AdministratorListOutDTO> getlist(@RequestParam Integer pageNum){
        return  null;
      }

      @GetMapping("/getById")
    public AdministratorShowOutDTO getById(@RequestParam  Integer administratorId){
            return  null;
      }
      @PostMapping("/create")
      public  Integer create(@RequestBody AdministratorCreateInDTO administratorCreateInDTO){
            return  null;
      }

      @PostMapping("/update")
    public  void update(@RequestBody AdministratorUpdateInDTO administratorUpdateInDTO){

      }


}
