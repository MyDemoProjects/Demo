package org.zzc.server.manager.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzc.base.model.service.BaseService;
import org.zzc.server.manager.dao.idao.IMenuDao;
import org.zzc.server.manager.entity.Menu;
import org.zzc.server.manager.service.iservice.IMenuService;

import java.util.List;

/**
 * Created by Administrator on 2015/9/9 0009.
 */
@Service
public class MenuService extends BaseService<Menu> implements IMenuService {
    @Autowired
    private IMenuDao MenuDao;

    public Menu getRecordById(Menu entity) {
        return MenuDao.getRecordById(entity);
    }

    public List<Menu> getRecordList(Menu entity) {
        return MenuDao.getRecordList(entity);
    }

    public Menu addRecord(Menu entity) {
        return MenuDao.addRecord(entity);
    }

    public Menu updateRecord(Menu entity) {
        return MenuDao.updateRecord(entity);
    }

    public Menu deleteRecord(Menu entity) {
        return MenuDao.deleteRecord(entity);
    }
}
