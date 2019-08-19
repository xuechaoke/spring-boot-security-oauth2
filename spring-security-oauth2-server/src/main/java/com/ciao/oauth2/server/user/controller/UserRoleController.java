package com.ciao.oauth2.server.user.controller;

import com.ciao.oauth2.server.mp.tool.page.PageData;
import com.ciao.oauth2.server.mp.utils.Result;
import com.ciao.oauth2.server.user.entity.dto.UserRoleDTO;
import com.ciao.oauth2.server.user.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 用户角色表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@RestController
@RequestMapping("/userrole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("page")
    public Result<PageData<UserRoleDTO>> page( @RequestParam Map<String, Object> params){
        PageData<UserRoleDTO> page = userRoleService.page(params);

        return new Result<PageData<UserRoleDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<UserRoleDTO> get(@PathVariable("id") String id){
        UserRoleDTO data = userRoleService.get(id);

        return new Result<UserRoleDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody UserRoleDTO dto){

        userRoleService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody UserRoleDTO dto){

        userRoleService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody String[] ids){

        userRoleService.delete(ids);

        return new Result();
    }



}
