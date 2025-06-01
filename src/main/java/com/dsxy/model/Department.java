package com.dsxy.model;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 院系实体类
 */
@Getter
@Setter
public class Department {
    /** 主键id */
    private Long id;
    /** 院系编号 */
    private String departmentNo;
    /** 院系名 */
    private String departmentName;
    /** 创建时间 */
    private LocalDateTime createTime;
    /** 更新时间 */
    private LocalDateTime updateTime;

}
