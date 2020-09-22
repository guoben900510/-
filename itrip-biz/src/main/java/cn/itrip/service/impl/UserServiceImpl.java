package cn.itrip.service.impl;

import cn.itrip.beans.pojo.User;
import cn.itrip.common.Page;
import cn.itrip.dao.UserMapper;
import cn.itrip.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper UserMapper;

    @Override
    public Page<User> getUsersByParams(String userName, int pageIndex) {
        int pageSize = 5;
        Map<String,Object> params = new HashMap<>();
        params.put("userName",userName);
        int from = (pageIndex - 1) * pageSize;
        params.put("from",from);
        params.put("limit",pageSize);
        //查询满足查询条件的用户集合和个数
        int totalPage = UserMapper.getUsersCount(params);
        List<User> users = UserMapper.getUsersByParams(params);
        //封装插叙结果
        Page<User> pageUsers = new Page<>(pageIndex,pageSize,totalPage,users);
        return pageUsers;
    }
}
