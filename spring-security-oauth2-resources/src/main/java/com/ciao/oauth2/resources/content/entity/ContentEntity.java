
package com.ciao.oauth2.resources.content.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 *
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ContentEntity{
	private static final long serialVersionUID = 1L;


    /**
     *
     */
	private Long id;

    /**
     * 内容类目ID
     */
	private Long categoryId;

    /**
     * 内容标题
     */
	private String title;

    /**
     * 子标题
     */
	private String subTitle;

    /**
     * 标题描述
     */
	private String titleDesc;

    /**
     * 链接
     */
	private String url;

    /**
     * 图片绝对路径
     */
	private String pic;

    /**
     * 图片2
     */
	private String pic2;

    /**
     * 内容
     */
	private String content;

    /**
     *
     */
	private Date created;

    /**
     *
     */
	private Date updated;
}
