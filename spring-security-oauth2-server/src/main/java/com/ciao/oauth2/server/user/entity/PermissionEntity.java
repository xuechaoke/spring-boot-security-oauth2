
package com.ciao.oauth2.server.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 权限表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("tb_permission")
public class PermissionEntity{
	private static final long serialVersionUID = 1L;


    /**
     *
     */
	private Long id;

    /**
     * 父权限
     */
	private Long parentId;

    /**
     * 权限名称
     */
	private String name;

    /**
     * 权限英文名称
     */
	private String enname;

    /**
     * 授权路径
     */
	private String url;

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
