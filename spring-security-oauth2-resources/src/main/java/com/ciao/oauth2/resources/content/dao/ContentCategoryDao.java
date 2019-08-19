
package com.ciao.oauth2.resources.content.dao;


import com.ciao.oauth2.resources.content.entity.ContentCategoryEntity;
import com.ciao.oauth2.resources.mp.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 内容分类
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Mapper
public interface ContentCategoryDao extends BaseDao<ContentCategoryEntity> {

}
