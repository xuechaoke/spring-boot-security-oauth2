package com.ciao.oauth2.resources.content.controller;

import com.ciao.oauth2.resources.content.entity.dto.ContentDTO;
import com.ciao.oauth2.resources.content.service.ContentService;
import com.ciao.oauth2.resources.mp.tool.page.PageData;
import com.ciao.oauth2.resources.mp.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 *
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@RestController
@RequestMapping("content")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @GetMapping("page")
    public Result<PageData<ContentDTO>> page(  @RequestParam Map<String, Object> params){
        PageData<ContentDTO> page = contentService.page(params);

        return new Result<PageData<ContentDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<ContentDTO> get(@PathVariable("id") String id){
        ContentDTO data = contentService.get(id);

        return new Result<ContentDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody ContentDTO dto){

        contentService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody ContentDTO dto){

        contentService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody String[] ids){

        contentService.delete(ids);

        return new Result();
    }



}
