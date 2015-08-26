package org.zzc.base.model.dao;

import org.apache.log4j.Logger;
import org.zzc.base.model.entity.BaseEntity;

import java.util.List;

/**
 * Base Dao
 * Created by Administrator on 2015/8/26 0026.
 */
public class BaseDao<E extends BaseEntity> {
    /** log object */
    protected Logger logger = Logger.getLogger(this.getClass());
    /** baseDaoSupport Class */
    protected BaseDaoSupport baseDaoSupport;

    /**
     * get Record by Id(mappid is determine)
     * @param entity query conditions
     * @return resultSet
     */
    protected E getEntityById(E entity) {
        return this.baseDaoSupport.getEntityById("getRecordById", entity);
    }

    /**
     *get Record by Id(note: mappId is not sure)
     * @param mapperId mappId
     * @param entity query conditions
     * @return resultSet
     */
    protected E getEntityById(String mapperId, E entity) {
        return this.baseDaoSupport.getEntityById(mapperId, entity);
    }

    /**
     * get Record List by query conditions(note: mappId is determine)
     * @param entity query conditions
     * @return resultSet
     */
    protected List<E> getEntityList(E entity) {
        /*if (entity.getSplitPage().getIsSplitPage()) {// 如果分页

            int count = this.baseDaoSupport.getSqlSession().selectOne(this.baseDaoSupport.getFullMapperId("getRecordListCount", entity.getClass()), entity);
            entity.getSplitPage().setTotalRows(count);
        }*/
        return this.baseDaoSupport.getEntityList("getRecordList", entity);
    }

    /**
     * get Record List by query conditions(note: mappId is not sure)
     * @param mapperId mappId
     * @param entity query conditions
     * @return resultSet
     */
    protected List<E> getEntityList(String mapperId, E entity) {
        return this.baseDaoSupport.getEntityList(mapperId, entity);

    }

    /**
     * add Record(note: mappId is determine)
     * @param entity add information
     * @return information(include affect the number of rows)
     */
    protected E addEntity(E entity) {
        int rowCount = this.baseDaoSupport.addEntity("addRecord", entity);
        entity.setRowCount(rowCount);
        return entity;
    }

    /**
     * add Record(note: mappId is not sure)
     * @param mapperId mappId
     * @param entity information
     * @return information(include affect the number of rows)
     */
    protected E addEntity(String mapperId, E entity) {
        int rowCount = this.baseDaoSupport.addEntity(mapperId, entity);
        entity.setRowCount(rowCount);
        return entity;
    }

    /**
     * add Records to the batch(note: mappId is determine)
     * @param entityList records list
     * @return list size
     */
    protected int addEntity(List<E> entityList) {
        return this.baseDaoSupport.addEntity("addRecord", entityList);
    }

    /**
     * add Records to the batch(note: mappId is not sure)
     * @param mapperId mappId
     * @param entityList records list
     * @return list size
     */
    protected int addEntity(String mapperId, List<E> entityList) {
        return this.baseDaoSupport.addEntity(mapperId, entityList);
    }

    /**
     * modify Record by query conditions(note: mappId is determine)
     * @param entity query conditions
     * @return entity(include affect the number of rows)
     */
    protected E updateEntity(E entity) {
        int rowCount = this.baseDaoSupport.updateEntity("updateRecord", entity);
        entity.setRowCount(rowCount);
        return entity;
    }

    /**
     * modify Record by query conditions(note: mappId is not sure)
     * @param mapperId mappId
     * @param entity query conditions
     * @return entity(include affect the number of rows)
     */
    protected E updateEntity(String mapperId, E entity) {
        int rowCount = this.baseDaoSupport.updateEntity(mapperId, entity);
        entity.setRowCount(rowCount);
        return entity;
    }

    /**
     * modify Records by entity list to the batch(note: mappId is determine)
     * @param entityList entity list
     * @return list size
     */
    protected int updateEntity(List<E> entityList) {
        return this.baseDaoSupport.updateEntity("updateRecord", entityList);
    }

    /**
     * modify Records by entity list to the batch(note: mappId is not sure)
     * @param mapperId mappId
     * @param entityList entity list
     * @return list size
     */
    protected int updateEntity(String mapperId, List<E> entityList) {
        return this.baseDaoSupport.updateEntity(mapperId, entityList);
    }

    /**
     * delete Record by query conditions(note: mappId is determine)
     * @param entity query conditions
     * @return entity(include affect the number of rows)
     */
    protected E deleteEntity(E entity) {
        int rowCount = this.baseDaoSupport.deleteEntity("deleteRecord", entity);
        entity.setRowCount(rowCount);
        return entity;

    }

    /**
     * delete Record by query conditions(note: mappId is not sure)
     * @param mapperId mappId
     * @param entity query conditions
     * @return entity(include affect the number of rows)
     */
    protected E deleteEntity(String mapperId, E entity) {
        int rowCount = this.baseDaoSupport.deleteEntity(mapperId, entity);
        entity.setRowCount(rowCount);
        return entity;

    }

    /**
     * set BaseDaoSupport property
     */
    public void setBaseDaoSupport(BaseDaoSupport baseDaoSupport) {
        this.baseDaoSupport = baseDaoSupport;
    }
}
