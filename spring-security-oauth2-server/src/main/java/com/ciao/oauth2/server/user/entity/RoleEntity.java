
package com.ciao.oauth2.server.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 角色表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("tb_role")
public class RoleEntity{
	private static final long serialVersionUID = 1L;


    /**
     *
     */
	private Long id;

    /**
     * 父角色
     */
	private Long parentId;

    /**
     * 角色名称
     */
	private String name;

    /**
     * 角色英文名称
     */
	private String enname;

    /**
     * 备注
     */
	private String description;

    /**
     *
     */
	private Date created;

    /**
     *
     */
	private Date updated;
}
