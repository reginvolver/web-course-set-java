package com.xwz.fullstack.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * @Description: 注册DTO
 * @author: XiaoWenzhuo
 * @date: 2022-05-15 15:15
 */
@Data
@ToString
@ApiModel("登录DTO")
public class RegisterDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("用户昵称")
    @Length(min = 4,message = "昵称长度最小四位")
    private String username;
    @Length(min = 6,message = "密码长度最小六位")
    @ApiModelProperty("用户密码")
    private String password;
}
