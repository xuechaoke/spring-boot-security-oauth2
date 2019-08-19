package com.ciao.oauth2.server.user.controller;

import com.ciao.oauth2.server.mp.tool.page.PageData;
import com.ciao.oauth2.server.mp.utils.Result;
import com.ciao.oauth2.server.user.entity.dto.UserDTO;
import com.ciao.oauth2.server.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 用户表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("page")
    public Result<PageData<UserDTO>> page( @RequestParam Map<String, Object> params){
        PageData<UserDTO> page = userService.page(params);

        return new Result<PageData<UserDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<UserDTO> get(@PathVariable("id") String id){
        UserDTO data = userService.get(id);

        return new Result<UserDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody UserDTO dto){

        userService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody UserDTO dto){

        userService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody String[] ids){

        userService.delete(ids);

        return new Result();
    }


}
