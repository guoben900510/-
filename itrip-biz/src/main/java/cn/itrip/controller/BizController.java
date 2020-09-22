package cn.itrip.controller;

import cn.itrip.beans.dto.Dto;
import cn.itrip.beans.pojo.User;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.Page;
import cn.itrip.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BizController {

    @Resource
    UserService UserService;

    @RequestMapping("/display")
    public Dto display(
            @RequestParam(value="page" ,defaultValue = "1") int pageIndex,
            @RequestParam(value="userName" ,defaultValue = "",required = false) String userName){
        Page<User> pageUsers = UserService.getUsersByParams( userName,pageIndex);

        return  DtoUtil.returnDataSuccess(pageUsers);
    }


}
