
package com.ciao.oauth2.resources.content.service;


import com.ciao.oauth2.resources.content.entity.ContentEntity;
import com.ciao.oauth2.resources.content.entity.dto.ContentDTO;
import com.ciao.oauth2.resources.mp.service.BaseService;
import com.ciao.oauth2.resources.mp.tool.page.PageData;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
public interface ContentService extends BaseService<ContentEntity> {

    PageData<ContentDTO> page(Map<String, Object> params);

    List<ContentDTO> list(Map<String, Object> params);

    ContentDTO get(String id);

    void save(ContentDTO dto);

    void update(ContentDTO dto);

    void delete(String[] ids);
}
