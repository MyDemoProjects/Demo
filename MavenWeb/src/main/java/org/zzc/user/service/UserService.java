package org.zzc.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzc.base.model.service.BaseService;
import org.zzc.user.dao.idao.IUserDao;
import org.zzc.user.entity.User;
import org.zzc.user.service.iservice.IUserService;

/**
 * user service implements class
 * Created by Administrator on 2015/8/26 0026.
 */
@Service
public class UserService extends BaseService<User> implements IUserService {
    /** user dao */
    @Autowired
    private IUserDao userDao;

    /**
     * get record by query conditions
     * @param entity query conditions
     * @return resultSet
     */
    public User getRecordById(User entity) {
        System.out.println(entity);
        return userDao.getRecordById(entity);
    }

    /**
     * get record list  by query conditions
     * @param entity query conditions
     * @return entity list
     */
    public List<User> getRecordList(User entity) {
        return userDao.getRecordList(entity);
    }

    /**
     * add record
     * @param entity information
     * @return information(include affect the number of rows)
     */
    public User addRecord(User entity) {
        return userDao.addRecord(entity);
    }

    /**
     * modify record by query conditions
     * @param entity query conditions
     * @return entity(include affect the number of rows)
     */
    public User updateRecord(User entity) {
        return userDao.updateRecord(entity);
    }

    /**
     * delete record by query conditions
     * @param entity query conditions
     * @return entity(include affect the number of rows)
     */
    public User deleteRecord(User entity) {
        return userDao.deleteRecord(entity);
    }

   /* *//**
     * set iUserDao
     * @param userDao iUserDao
     *//*
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }*/
}
