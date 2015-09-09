package org.zzc.base.model.entity;

import org.zzc.base.model.util.JsonTool;

import java.sql.Timestamp;

/**
 * 实体类的公共部分属性
 * Created by Administrator on 2015/8/26 0026.
 */
public class BaseEntity {
    private Long id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer rowCount;
    /** 分页信息 */
    private SplitPage splitPage = new SplitPage();

    public Timestamp getCreateTime() {
        return createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
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

    public SplitPage getSplitPage() {
        return splitPage;
    }

    public void setSplitPage(SplitPage splitPage) {
        this.splitPage = splitPage;
    }

    @Override
    public String toString() {
        return JsonTool.getJsonString(this);
    }
}
