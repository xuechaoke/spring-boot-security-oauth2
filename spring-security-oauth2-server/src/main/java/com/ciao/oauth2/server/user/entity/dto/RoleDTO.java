
package com.ciao.oauth2.server.user.entity.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 角色表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Data
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long parentId;

	private String name;

	private String enname;

	private String description;

	private Date created;

	private Date updated;

}
