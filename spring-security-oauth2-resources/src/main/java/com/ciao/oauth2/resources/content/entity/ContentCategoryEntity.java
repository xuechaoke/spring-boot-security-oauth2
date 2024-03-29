
package com.ciao.oauth2.resources.content.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 内容分类
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ContentCategoryEntity{
	private static final long serialVersionUID = 1L;


    /**
     * 类目ID
     */
	private Long id;

    /**
     * 父类目ID=0时，代表的是一级的类目
     */
	private Long parentId;

    /**
     * 分类名称
     */
	private String name;

    /**
     * 状态。可选值:1(正常),2(删除)
     */
	private Integer status;

    /**
     * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
     */
	private Integer sortOrder;

    /**
     * 该类目是否为父类目，1为true，0为false
     */
	private Integer isParent;

    /**
     * 创建时间
     */
	private Date created;

    /**
     * 创建时间
     */
	private Date updated;
}
