
package com.ciao.oauth2.resources.content.entity.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 *
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Data
public class ContentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	private Long id;

	private Long categoryId;


	private String subTitle;

	private String titleDesc;

	private String url;


	private String pic2;

	private String content;

	private Date created;

	private Date updated;

}
