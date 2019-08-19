
package com.ciao.oauth2.server.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色权限表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("tb_role_permission")
public class RolePermissionEntity{
	private static final long serialVersionUID = 1L;


    /**
     *
     */
	private Long id;

    /**
     * 角色 ID
     */
	private Long roleId;

    /**
     * 权限 ID
     */
	private Long permissionId;
}
