package org.zzc.server.login.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzc.base.model.service.BaseService;
import org.zzc.server.login.dao.SysUserDao;
import org.zzc.server.login.dao.idao.ISysUserDao;
import org.zzc.server.login.entity.SysUser;
import org.zzc.server.login.service.iservice.ISysUserService;

import java.util.List;

/**
 * Created by Administrator on 2015/9/9 0009.
 */
@Service
public class SysUserService extends BaseService<SysUser> implements ISysUserService {
    @Autowired
    private ISysUserDao sysUserDao;

    public SysUser getRecordById(SysUser entity) {
        return sysUserDao.getRecordById(entity);
    }

    public List<SysUser> getRecordList(SysUser entity) {
        return sysUserDao.getRecordList(entity);
    }

    public SysUser addRecord(SysUser entity) {
        return sysUserDao.addRecord(entity);
    }

    public SysUser updateRecord(SysUser entity) {
        return sysUserDao.updateRecord(entity);
    }

    public SysUser deleteRecord(SysUser entity) {
        return sysUserDao.deleteRecord(entity);
    }
}
