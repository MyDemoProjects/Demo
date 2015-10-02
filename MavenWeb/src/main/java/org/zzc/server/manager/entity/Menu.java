package org.zzc.server.manager.entity;

import org.zzc.base.model.entity.BaseEntity;

import java.util.List;

public class Menu extends BaseEntity{
    private String menuName;

    private String menuUrl;

    private Integer degree;

    private Integer subMenuCount;

    private Integer parentId;

    private Integer status;

    private List<Menu> subMenus;

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public Integer getSubMenuCount() {
        return subMenuCount;
    }

    public void setSubMenuCount(Integer subMenuCount) {
        this.subMenuCount = subMenuCount;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}