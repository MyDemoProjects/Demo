package org.zzc.base.model.dao.idao;

import org.zzc.base.model.entity.BaseEntity;

import java.util.List;

/**
 * baseDao interface
 * Created by Administrator on 2015/8/26 0026.
 */
public interface IBaseDao<E extends BaseEntity> {
    /**
     * get Record
     * @param entity query conditions
     * @return resultSet
     */
    public E getRecordById(E entity);

    /**
     * get Records
     * @param entity query conditions
     * @return resultSet
     */
    public List<E> getRecordList(E entity);

    /**
     * add Record
     * @param entity add information
     * @return entity(include affect the number of rows)
     */
    public E addRecord(E entity);

    /**
     *  modify Record
     * @param entity modify information
     * @return entity(include affect the number of rows)
     */
    public E updateRecord(E entity);

    /**
     * delete Record
     * @param entity query conditions
     * @return entity(include affect the number of rows)
     */
    public E deleteRecord(E entity);
}
