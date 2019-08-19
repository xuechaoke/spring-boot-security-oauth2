
package com.ciao.oauth2.resources.content.service;

import com.ciao.oauth2.resources.content.entity.ContentCategoryEntity;
import com.ciao.oauth2.resources.content.entity.dto.ContentCategoryDTO;
import com.ciao.oauth2.resources.mp.service.BaseService;
import com.ciao.oauth2.resources.mp.tool.page.PageData;

import java.util.List;
import java.util.Map;

/**
 * 内容分类
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
public interface ContentCategoryService extends BaseService<ContentCategoryEntity> {

    PageData<ContentCategoryDTO> page(Map<String, Object> params);

    List<ContentCategoryDTO> list(Map<String, Object> params);

    ContentCategoryDTO get(String id);

    void save(ContentCategoryDTO dto);

    void update(ContentCategoryDTO dto);

    void delete(String[] ids);
}
