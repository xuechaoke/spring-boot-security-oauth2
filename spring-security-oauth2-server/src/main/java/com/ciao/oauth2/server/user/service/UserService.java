
package com.ciao.oauth2.server.user.service;

import com.ciao.oauth2.server.mp.service.BaseService;
import com.ciao.oauth2.server.mp.tool.page.PageData;
import com.ciao.oauth2.server.user.entity.UserEntity;
import com.ciao.oauth2.server.user.entity.dto.UserDTO;

import java.util.List;
import java.util.Map;

/**
 * 用户表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
public interface UserService extends BaseService<UserEntity> {

    PageData<UserDTO> page(Map<String, Object> params);

    List<UserDTO> list(Map<String, Object> params);

    UserDTO get(String id);
    UserEntity queryByUsername(String username);

    void save(UserDTO dto);

    void update(UserDTO dto);

    void delete(String[] ids);
}
