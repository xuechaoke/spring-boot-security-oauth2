
package com.ciao.oauth2.server.user.service;

import com.ciao.oauth2.server.mp.service.BaseService;
import com.ciao.oauth2.server.mp.tool.page.PageData;
import com.ciao.oauth2.server.user.entity.PermissionEntity;
import com.ciao.oauth2.server.user.entity.dto.PermissionDTO;

import java.util.List;
import java.util.Map;

/**
 * 权限表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
public interface PermissionService extends BaseService<PermissionEntity> {

    PageData<PermissionDTO> page(Map<String, Object> params);

    List<PermissionDTO> list(Map<String, Object> params);

    PermissionDTO get(String id);

    void save(PermissionDTO dto);

    void update(PermissionDTO dto);

    void delete(String[] ids);


    List<PermissionEntity> listPermissionByUserId(Long userId);
}
