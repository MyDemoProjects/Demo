package org.zzc.base.model.entity;

import java.sql.Timestamp;

/**
 * 实体类的公共部分属性
 * Created by Administrator on 2015/8/26 0026.
 */
public class BaseEntity {
    private Timestamp createTime;
    private Integer rowCount;

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }
}
