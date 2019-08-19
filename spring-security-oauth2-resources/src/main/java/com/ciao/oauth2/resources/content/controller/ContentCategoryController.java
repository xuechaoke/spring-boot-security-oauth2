package com.ciao.oauth2.resources.content.controller;

import com.ciao.oauth2.resources.content.entity.dto.ContentCategoryDTO;
import com.ciao.oauth2.resources.content.service.ContentCategoryService;
import com.ciao.oauth2.resources.mp.tool.page.PageData;
import com.ciao.oauth2.resources.mp.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 内容分类
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@RestController
@RequestMapping("content/category")
public class ContentCategoryController {
    @Autowired
    private ContentCategoryService contentCategoryService;

    @GetMapping("page")
    public Result<PageData<ContentCategoryDTO>> page( @RequestParam Map<String, Object> params){
        PageData<ContentCategoryDTO> page = contentCategoryService.page(params);

        return new Result<PageData<ContentCategoryDTO>>().ok(page);
    }

    @GetMapping("{id}")
    public Result<ContentCategoryDTO> get(@PathVariable("id") String id){
        ContentCategoryDTO data = contentCategoryService.get(id);

        return new Result<ContentCategoryDTO>().ok(data);
    }

    @PostMapping
    public Result save(@RequestBody ContentCategoryDTO dto){

        contentCategoryService.save(dto);

        return new Result();
    }

    @PutMapping
    public Result update(@RequestBody ContentCategoryDTO dto){

        contentCategoryService.update(dto);

        return new Result();
    }

    @DeleteMapping
    public Result delete(@RequestBody String[] ids){

        contentCategoryService.delete(ids);

        return new Result();
    }


}
