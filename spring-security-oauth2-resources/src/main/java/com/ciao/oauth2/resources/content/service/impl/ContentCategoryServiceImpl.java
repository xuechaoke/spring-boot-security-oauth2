package com.ciao.oauth2.resources.content.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ciao.oauth2.resources.constant.Constant;
import com.ciao.oauth2.resources.content.dao.ContentCategoryDao;
import com.ciao.oauth2.resources.content.entity.ContentCategoryEntity;
import com.ciao.oauth2.resources.content.entity.dto.ContentCategoryDTO;
import com.ciao.oauth2.resources.content.service.ContentCategoryService;
import com.ciao.oauth2.resources.mp.service.impl.BaseServiceImpl;
import com.ciao.oauth2.resources.mp.tool.page.PageData;
import com.ciao.oauth2.resources.mp.utils.ConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 内容分类
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Service
public class ContentCategoryServiceImpl extends BaseServiceImpl<ContentCategoryDao, ContentCategoryEntity> implements ContentCategoryService {

    @Override
    public PageData<ContentCategoryDTO> page(Map<String, Object> params) {
        IPage<ContentCategoryEntity> page = baseDao.selectPage(
                getPage(params, Constant.CREATE_DATE, false),
                getWrapper(params)
        );

        return getPageData(page, ContentCategoryDTO.class);
    }

    @Override
    public List<ContentCategoryDTO> list(Map<String, Object> params) {
        List<ContentCategoryEntity> entityList = baseDao.selectList(getWrapper(params));

        return ConvertUtils.sourceToTarget(entityList, ContentCategoryDTO.class);
    }

    private QueryWrapper<ContentCategoryEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<ContentCategoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);
        //wrapper.eq(Constant.DEL_FLAG, DelFlagEnum.NORMAL.value());

        return wrapper;
    }

    @Override
    public ContentCategoryDTO get(String id) {
        ContentCategoryEntity entity = baseDao.selectById(id);

        return ConvertUtils.sourceToTarget(entity, ContentCategoryDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ContentCategoryDTO dto) {
        ContentCategoryEntity entity = ConvertUtils.sourceToTarget(dto, ContentCategoryEntity.class);

        insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ContentCategoryDTO dto) {
        ContentCategoryEntity entity = ConvertUtils.sourceToTarget(dto, ContentCategoryEntity.class);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String[] ids) {
        //逻辑删除
        //logicDelete(ids, ContentCategoryEntity.class);

        //物理删除
        baseDao.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public boolean logicDelete(Long[] ids, Class<ContentCategoryEntity> entity) {
        return false;
    }
}
