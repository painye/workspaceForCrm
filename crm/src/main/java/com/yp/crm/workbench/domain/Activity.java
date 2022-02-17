package com.yp.crm.workbench.domain;
/**
 * @author pan
 * @date 2022/2/17 15:45
 */

import lombok.Data;

/**
 * @ClassName : com.yp.crm.workbench.domain.Activity
 * @Description : 市场活动的实体表
 * @author pan
 * @date 2022/2/17 15:45
 */

@Data
public class Activity {
    private String id;
    private String owner;
    private String name;
    private String startDate;
    private String endDate;
    private String cost;
    private String description;
    private String createTime;
    private String createBy;
    private String editTime;
    private String editBy;

}
