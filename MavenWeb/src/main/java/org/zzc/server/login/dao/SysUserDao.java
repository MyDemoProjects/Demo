package org.zzc.server.login.dao;

import org.springframework.stereotype.Repository;
import org.zzc.base.model.dao.BaseDao;
import org.zzc.server.login.dao.idao.ISysUserDao;
import org.zzc.server.login.entity.SysUser;

import java.util.List;

/**
 * Created by Administrator on 2015/9/9 0009.
 */
@Repository
public class SysUserDao extends BaseDao<SysUser> implements ISysUserDao {

    public SysUser getRecordById(SysUser entity) {
        return this.getEntityById(entity);
    }

    public List<SysUser> getRecordList(SysUser entity) {
        return this.getEntityList(entity);
    }

    public SysUser addRecord(SysUser entity) {
        return this.addEntity(entity);
    }

    public SysUser updateRecord(SysUser entity) {
        return this.updateEntity(entity);
    }

    public SysUser deleteRecord(SysUser entity) {
        return this.deleteEntity(entity);
    }
}
