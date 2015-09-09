package org.zzc.user.dao;

import org.springframework.stereotype.Repository;
import org.zzc.base.model.dao.BaseDao;
import org.zzc.user.dao.idao.IUserDao;
import org.zzc.user.entity.User;

import java.util.List;

/**
 * user info dao
 * Created by Administrator on 2015/8/26 0026.
 */
@Repository
public class UserDao extends BaseDao<User> implements IUserDao {

    /**
     * get Record
     * @param entity query conditions
     * @return resultSet
     */
    public User getRecordById(User entity) {
        return this.getEntityById(entity);
    }

    /**
     * @param entity query conditions
     * @return result list
     */
    public List<User> getRecordList(User entity) {
        return this.getEntityList(entity);
    }

    /**
     * @param entity add information
     * @return information(include affect the number of rows)
     */
    public User addRecord(User entity) {
        return this.addEntity(entity);
    }

    /**
     * @param entity modify information
     * @return information(include affect the number of rows)
     */
    public User updateRecord(User entity) {
        return this.updateEntity(entity);
    }

    /**
     * @param entity query conditions
     * @return information(include affect the number of rows)
     */
    public User deleteRecord(User entity) {
        return this.deleteEntity(entity);
    }
}
