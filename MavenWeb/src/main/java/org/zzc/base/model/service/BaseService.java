package org.zzc.base.model.service;

import org.apache.log4j.Logger;
import org.zzc.base.model.entity.BaseEntity;

/**
 * base service  implements class
 * Created by Administrator on 2015/8/26 0026.
 */
public class BaseService<E extends BaseEntity> {
    /** Logger Object */
    protected Logger logger = Logger.getLogger(this.getClass());
}
