package org.zzc.base.model.service;

import java.util.List;

/**
 * base service interface
 * Created by Administrator on 2015/8/26 0026.
 */
public interface IBaseService<E> {
    
    public E getRecordById(E entity);

    public List<E> getRecordList(E entity);

    public E addRecord(E entity);

    public E updateRecord(E entity);

    public E deleteRecord(E entity);
}
