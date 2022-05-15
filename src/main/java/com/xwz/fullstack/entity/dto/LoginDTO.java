package com.xwz.fullstack.entity.dto;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

/**
 * @Description: 登录DTO
 * @author: XiaoWenzhuo
 * @date: 2022-05-10 16:50
 */
@Data
@ToString
@ApiModel("登录DTO")
public class LoginDTO {
    private String username;
    private String password;
}
