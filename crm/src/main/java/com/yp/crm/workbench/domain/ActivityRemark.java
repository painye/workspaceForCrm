package com.yp.crm.workbench.domain;
/**
 * @author pan
 * @date 2022/2/17 15:47
 */

import lombok.Data;

/**
 * @ClassName : com.yp.crm.workbench.domain.ActivityRemark
 * @Description : 市场活动标记的实体表
 * @author pan
 * @date 2022/2/17 15:47
 */

@Data
public class ActivityRemark {
    private String id;
    private String noteContent;
    private String createTime;
    private String createBy;
    private String editTime ;
    private String editBy;
    private String editFlag;
    private String activityId;

}
