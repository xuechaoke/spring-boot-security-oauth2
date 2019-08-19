package com.ciao.oauth2.server.user.controller;

import com.ciao.oauth2.server.mp.tool.page.PageData;
import com.ciao.oauth2.server.mp.utils.Result;
import com.ciao.oauth2.server.user.entity.dto.RoleDTO;
import com.ciao.oauth2.server.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 角色表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("page")
    public Result<PageData<RoleDTO>> page(@RequestParam Map<String, Object> params){
        PageData<RoleDTO> page = roleService.page(params);

        return new Result<PageData<RoleDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<RoleDTO> get(@PathVariable("id") String id){
        RoleDTO data = roleService.get(id);

        return new Result<RoleDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody RoleDTO dto){

        roleService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody RoleDTO dto){

        roleService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody String[] ids){

        roleService.delete(ids);

        return new Result();
    }



}
