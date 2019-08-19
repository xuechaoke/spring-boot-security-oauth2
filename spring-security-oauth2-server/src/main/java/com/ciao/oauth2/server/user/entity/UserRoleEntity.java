
package com.ciao.oauth2.server.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户角色表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("tb_user_role")
public class UserRoleEntity{
	private static final long serialVersionUID = 1L;


    /**
     *
     */
	private Long id;

    /**
     * 用户 ID
     */
	private Long userId;

    /**
     * 角色 ID
     */
	private Long roleId;
}
