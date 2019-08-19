
package com.ciao.oauth2.server.user.service;

import com.ciao.oauth2.server.mp.service.BaseService;
import com.ciao.oauth2.server.mp.tool.page.PageData;
import com.ciao.oauth2.server.user.entity.RolePermissionEntity;
import com.ciao.oauth2.server.user.entity.dto.RolePermissionDTO;

import java.util.List;
import java.util.Map;

/**
 * 角色权限表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
public interface RolePermissionService extends BaseService<RolePermissionEntity> {

    PageData<RolePermissionDTO> page(Map<String, Object> params);

    List<RolePermissionDTO> list(Map<String, Object> params);

    RolePermissionDTO get(String id);

    void save(RolePermissionDTO dto);

    void update(RolePermissionDTO dto);

    void delete(String[] ids);
}
