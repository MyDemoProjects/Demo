package org.zzc.base.model.dao;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * 基础类
 * Created by zhoumeiqin on 15/8/25.
 */
public class BaseDaoSupport extends SqlSessionDaoSupport {
    /**
     * 日志对象
     */
    protected Logger logger = Logger.getLogger(this.getClass());
    /**
     * SqlSessionTemplate在批处理时使用
     */
    private SqlSessionTemplate sessionTemplate;

    /***
     * 取得fullMapperId
     *
     * @param mapperId sqlMap's id
     * @param entity bean
     * @return bean
     */
    public <E> String getFullMapperId(String mapperId, E entity) {
        return getFullMapperId(mapperId, entity.getClass());
    }

    /***
     * 取得fullMapperId
     *
     * @param mapperId sqlMap's id
     * @param c clazz
     * @return bean
     */
    public <E> String getFullMapperId(String mapperId, Class<E> c) {
        logger.info("      ====执行sql：" + c.getName() + "." + mapperId);
        return c.getName() + "." + mapperId;
    }

    /**
     * 根据id得到记录
     *
     * @param mapperId sqlMap's id
     * @param entity bean
     * @return bean
     */
    public <E> E getEntityById(String mapperId, E entity) {
        return this.getSqlSession().selectOne(getFullMapperId(mapperId, entity), entity);
    }

    /**
     * 得到记录列表
     *
     * @param mapperId sqlMap's id
     * @param entity bean
     * @return list<bean>
     */
    public <E> List<E> getEntityList(String mapperId, E entity) {
        return this.getSqlSession().selectList(getFullMapperId(mapperId, entity), entity);
    }

    /**
     * 新增记录
     *
     * @param mapperId sqlMap's id
     * @param entity bean
     * @return 影响的行数
     */
    public <E> int addEntity(String mapperId, E entity) {
        return this.getSqlSession().insert(getFullMapperId(mapperId, entity), entity);
    }

    /**
     * 新增记录
     *
     * @param mapperId sqlMap's id
     * @param entityList list<bean>
     * @return 影响的行数
     */
    public <E> int addEntity(String mapperId, List<E> entityList) {
        SqlSession session = this.sessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        String fullMapperId = null;
        int i = 0;
        for (E entity : entityList) {
            if (fullMapperId != null) {
                session.insert(fullMapperId, entity);
            } else {
                fullMapperId = getFullMapperId(mapperId, entity);
                session.insert(fullMapperId, entity);
            }
            i++;
            if (i % 100 == 0) {
                session.flushStatements();
            }
        }
        session.flushStatements();
        // session.close();在spring事务开启后失效
        return entityList.size();
    }

    /**
     * 修改记录
     *
     * @param mapperId sqlMap's id
     * @param entity bean
     * @return 影响的行数
     */
    public <E> int updateEntity(String mapperId, E entity) {
        return this.getSqlSession().update(getFullMapperId(mapperId, entity), entity);
    }

    /**
     * 修改记录
     *
     * @param mapperId sqlMap's id
     * @param entityList list bean
     * @return 影响的行数
     */
    public <E> int updateEntity(String mapperId, List<E> entityList) {
        SqlSession session = this.sessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        String fullMapperId = null;
        int i = 0;
        for (E entity : entityList) {
            if (fullMapperId != null) {
                session.update(fullMapperId, entity);
            } else {
                fullMapperId = getFullMapperId(mapperId, entity);
                session.update(fullMapperId, entity);
            }
            i++;
            if (i % 100 == 0) {
                session.flushStatements();
            }
        }
        session.flushStatements();
        // session.close();在spring事务开启后失效
        return entityList.size();
    }

    /**
     * 删除记录
     *
     * @param mapperId sqlMap's id
     * @param entity bean
     * @return 影响的行数
     */
    public <E> int deleteEntity(String mapperId, E entity) {
        return this.getSqlSession().delete(getFullMapperId(mapperId, entity), entity);
    }

    /**
     *  SqlSessionTemplate在批处理时使用
     */
    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }
}
