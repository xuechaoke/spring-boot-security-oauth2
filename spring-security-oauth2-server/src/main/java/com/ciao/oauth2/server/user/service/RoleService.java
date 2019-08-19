
package com.ciao.oauth2.server.user.service;

import com.ciao.oauth2.server.mp.service.BaseService;
import com.ciao.oauth2.server.mp.tool.page.PageData;
import com.ciao.oauth2.server.user.entity.RoleEntity;
import com.ciao.oauth2.server.user.entity.dto.RoleDTO;

import java.util.List;
import java.util.Map;

/**
 * 角色表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
public interface RoleService extends BaseService<RoleEntity> {

    PageData<RoleDTO> page(Map<String, Object> params);

    List<RoleDTO> list(Map<String, Object> params);

    RoleDTO get(String id);

    void save(RoleDTO dto);

    void update(RoleDTO dto);

    void delete(String[] ids);
}
