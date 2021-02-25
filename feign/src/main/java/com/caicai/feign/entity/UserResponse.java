package com.caicai.feign.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: UserResponse
 * @Package: com.caicai.feign.entity
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/22 10:51
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Data
public class UserResponse {
    private String token;
    private String userCode;
    private String partnerCode;
    private Integer registerSource;
    private String username;
    private String nickname;
    private String realName;
    private Integer sex;
    private String headImgUrl;
    private String mobile;
    private Integer status;
    private Integer authStatus;
    private Integer userType;
    private String remark;
    private String createBy;
    private String updateBy;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date createTime;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date updateTime;
    private List<Integer> roleIds;
    private Integer dataId;
    private String partnerUserCode;
    private String partnerUserRank;
    private String partnerUserPost;
    private String orgId;
}
