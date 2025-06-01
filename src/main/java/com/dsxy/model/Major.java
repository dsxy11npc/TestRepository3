package com.dsxy.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 专业实体类
 */
@Getter
@Setter
public class Major {
    /** 主键id */
    private Long id;
    /** 专业编号 */
    private String majorNo;
    /** 专业名 */
    private String majorName;
    /** 所属院系ID */
    private Long departmentId;
    /** 创建时间 */
    private LocalDateTime createTime;
    /** 更新时间 */
    private LocalDateTime updateTime;

}
