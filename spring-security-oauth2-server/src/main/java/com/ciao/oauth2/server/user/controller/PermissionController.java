package com.ciao.oauth2.server.user.controller;

import com.ciao.oauth2.server.mp.tool.page.PageData;
import com.ciao.oauth2.server.mp.utils.Result;
import com.ciao.oauth2.server.user.entity.dto.PermissionDTO;
import com.ciao.oauth2.server.user.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 权限表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping("page")
    public Result<PageData<PermissionDTO>> page(@RequestParam Map<String, Object> params){
        PageData<PermissionDTO> page = permissionService.page(params);

        return new Result<PageData<PermissionDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<PermissionDTO> get(@PathVariable("id") String id){
        PermissionDTO data = permissionService.get(id);

        return new Result<PermissionDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody PermissionDTO dto){

        permissionService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody PermissionDTO dto){

        permissionService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody String[] ids){

        permissionService.delete(ids);

        return new Result();
    }



}
