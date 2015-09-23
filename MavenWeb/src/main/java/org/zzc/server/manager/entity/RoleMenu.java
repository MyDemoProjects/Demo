package org.zzc.server.manager.entity;

import org.zzc.base.model.entity.BaseEntity;

public class RoleMenu extends BaseEntity {

    private Integer roleid;

    private Integer menuid;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }
}