
package com.ciao.oauth2.resources.content.entity.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 内容分类
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Data
public class ContentCategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long parentId;

	private String name;

	private Integer status;

	private Integer sortOrder;

	private Integer isParent;

	private Date created;

	private Date updated;

}
