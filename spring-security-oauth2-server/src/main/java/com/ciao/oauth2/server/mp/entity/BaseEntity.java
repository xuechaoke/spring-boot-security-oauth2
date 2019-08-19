
package com.ciao.oauth2.server.mp.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类，所有实体都需要继承
 *
 * @author huangbin 694968711@qq.com
 * @since 1.0.0
 */
@Data
public abstract class BaseEntity implements Serializable {
    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 创建者
     */
    @TableField(fill = FieldFill.DEFAULT,exist = false)
    private Long creator;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.DEFAULT,exist = false)
    private Date createDate;

}
