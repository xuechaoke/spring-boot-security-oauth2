package com.ciao.oauth2.server.user.controller;

import com.ciao.oauth2.server.mp.tool.page.PageData;
import com.ciao.oauth2.server.mp.utils.Result;
import com.ciao.oauth2.server.user.entity.dto.RolePermissionDTO;
import com.ciao.oauth2.server.user.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 角色权限表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@RestController
@RequestMapping("/rolepermission")
public class RolePermissionController {
    @Autowired
    private RolePermissionService rolePermissionService;

    @GetMapping("page")
    public Result<PageData<RolePermissionDTO>> page(  @RequestParam Map<String, Object> params){
        PageData<RolePermissionDTO> page = rolePermissionService.page(params);

        return new Result<PageData<RolePermissionDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<RolePermissionDTO> get(@PathVariable("id") String id){
        RolePermissionDTO data = rolePermissionService.get(id);

        return new Result<RolePermissionDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody RolePermissionDTO dto){

        rolePermissionService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody RolePermissionDTO dto){

        rolePermissionService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody String[] ids){

        rolePermissionService.delete(ids);

        return new Result();
    }



}
