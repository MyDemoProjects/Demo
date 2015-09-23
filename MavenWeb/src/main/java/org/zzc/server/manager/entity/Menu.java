package org.zzc.server.manager.entity;

import org.zzc.base.model.entity.BaseEntity;

public class Menu extends BaseEntity{
    private String menuname;

    private String menuurl;

    private Integer degree;

    private Integer submenucount;

    private Integer parentid;

    private Integer status;

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public String getMenuurl() {
        return menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl == null ? null : menuurl.trim();
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public Integer getSubmenucount() {
        return submenucount;
    }

    public void setSubmenucount(Integer submenucount) {
        this.submenucount = submenucount;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}