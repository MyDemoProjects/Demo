package org.zzc.base.model.service.iservice;

import java.util.List;

/**
 * base service interface
 * Created by Administrator on 2015/8/26 0026.
 */
public interface IBaseService<E> {

    /**
     *  get Record by query conditions
     * @param entity query conditions
     * @return resultSet
     */
    public E getRecordById(E entity);

    /**
     * get Records by query conditions
     * @param entity query conditions
     * @return entity list
     */
    public List<E> getRecordList(E entity);

    /**
     * add Record
     * @param entity information
     * @return entity(include affect the number of rows)
     */
    public E addRecord(E entity);

    /**
     * modify Record by query conditions
     * @param entity query conditions
     * @return entity(include affect the number of rows)
     */
    public E updateRecord(E entity);

    /**
     * delete Record by query conditions
     * @param entity query conditions
     * @return entity(include affect the number of rows)
     */
    public E deleteRecord(E entity);
}
