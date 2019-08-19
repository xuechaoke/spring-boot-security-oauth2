
package com.ciao.oauth2.server.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 用户表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("tb_user")
public class UserEntity{
	private static final long serialVersionUID = 1L;


    /**
     *
     */
	private Long id;

    /**
     * 用户名
     */
	private String username;

    /**
     * 密码，加密存储
     */
	private String password;

    /**
     * 注册手机号
     */
	private String phone;

    /**
     * 注册邮箱
     */
	private String email;

    /**
     *
     */
	private Date created;

    /**
     *
     */
	private Date updated;
}
