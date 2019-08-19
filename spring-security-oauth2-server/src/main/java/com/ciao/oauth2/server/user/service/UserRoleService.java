
package com.ciao.oauth2.server.user.service;

import com.ciao.oauth2.server.mp.service.BaseService;
import com.ciao.oauth2.server.mp.tool.page.PageData;
import com.ciao.oauth2.server.user.entity.UserRoleEntity;
import com.ciao.oauth2.server.user.entity.dto.UserRoleDTO;

import java.util.List;
import java.util.Map;

/**
 * 用户角色表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
public interface UserRoleService extends BaseService<UserRoleEntity> {

    PageData<UserRoleDTO> page(Map<String, Object> params);

    List<UserRoleDTO> list(Map<String, Object> params);

    UserRoleDTO get(String id);

    void save(UserRoleDTO dto);

    void update(UserRoleDTO dto);

    void delete(String[] ids);
}
