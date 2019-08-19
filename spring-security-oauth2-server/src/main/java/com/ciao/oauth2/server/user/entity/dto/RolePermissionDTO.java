
package com.ciao.oauth2.server.user.entity.dto;


import lombok.Data;

import java.io.Serializable;


/**
 * 角色权限表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Data
public class RolePermissionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long roleId;

	private Long permissionId;

}
