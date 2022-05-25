package com.xwz.fullstack.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-19
 */
@Data
@TableName("user")
@ApiModel(value = "User对象", description = "用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty("用户id")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty("用户昵称")
    @Length(min = 4,message = "昵称长度最小四位")
    @TableField("username")
    private String username;

    @Length(min = 6,message = "密码长度最小六位")
    @ApiModelProperty("用户密码")
    @TableField("password")

    private String password;



    @ApiModelProperty("账号状态 0正常 1停用")
    @TableField("status")
    private String status;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("用户权限 admin 管理员 user 用户")
    @TableField("role")
    private String role;
}




