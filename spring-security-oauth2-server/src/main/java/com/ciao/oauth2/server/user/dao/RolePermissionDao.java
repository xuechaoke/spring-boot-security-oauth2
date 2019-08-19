
package com.ciao.oauth2.server.user.dao;

import com.ciao.oauth2.server.mp.dao.BaseDao;
import com.ciao.oauth2.server.user.entity.RolePermissionEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色权限表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Mapper
public interface RolePermissionDao extends BaseDao<RolePermissionEntity> {

}
