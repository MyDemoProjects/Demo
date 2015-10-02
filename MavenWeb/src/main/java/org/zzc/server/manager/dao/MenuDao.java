package org.zzc.server.manager.dao;

import org.springframework.stereotype.Repository;
import org.zzc.base.model.dao.BaseDao;
import org.zzc.server.manager.dao.idao.IMenuDao;
import org.zzc.server.manager.entity.Menu;

import java.util.List;

/**
 * Created by Administrator on 2015/9/9 0009.
 */
@Repository
public class MenuDao extends BaseDao<Menu> implements IMenuDao {

    public Menu getRecordById(Menu entity) {
        return this.getEntityById(entity);
    }

    public List<Menu> getRecordList(Menu entity) {
        return this.getEntityList(entity);
    }

    public Menu addRecord(Menu entity) {
        return this.addEntity(entity);
    }

    public Menu updateRecord(Menu entity) {
        return this.updateEntity(entity);
    }

    public Menu deleteRecord(Menu entity) {
        return this.deleteEntity(entity);
    }
}
