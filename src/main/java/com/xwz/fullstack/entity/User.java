package com.xwz.fullstack.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户昵称
     */
    private String name;

    /**
     * 用户密码

     */
    private String password;

    /**
     * 用户手机号
     */
    private String phoneNumber;

    /**
     * 账号状态 0正常 1停用
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 用户权限 admin 管理员 user 用户
     */
    private String role;


}
