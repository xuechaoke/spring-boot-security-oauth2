package com.ciao.oauth2.resources.content.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ciao.oauth2.resources.constant.Constant;
import com.ciao.oauth2.resources.content.dao.ContentDao;
import com.ciao.oauth2.resources.content.entity.ContentEntity;
import com.ciao.oauth2.resources.content.entity.dto.ContentDTO;
import com.ciao.oauth2.resources.content.service.ContentService;
import com.ciao.oauth2.resources.mp.service.impl.BaseServiceImpl;
import com.ciao.oauth2.resources.mp.tool.page.PageData;
import com.ciao.oauth2.resources.mp.utils.ConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Service
public class ContentServiceImpl extends BaseServiceImpl<ContentDao, ContentEntity> implements ContentService {

    @Override
    public PageData<ContentDTO> page(Map<String, Object> params) {
        IPage<ContentEntity> page = baseDao.selectPage(
                getPage(params, Constant.CREATE_DATE, false),
                getWrapper(params)
        );

        return getPageData(page, ContentDTO.class);
    }

    @Override
    public List<ContentDTO> list(Map<String, Object> params) {
        List<ContentEntity> entityList = baseDao.selectList(getWrapper(params));

        return ConvertUtils.sourceToTarget(entityList, ContentDTO.class);
    }

    private QueryWrapper<ContentEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<ContentEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);
        //wrapper.eq(Constant.DEL_FLAG, DelFlagEnum.NORMAL.value());

        return wrapper;
    }

    @Override
    public ContentDTO get(String id) {
        ContentEntity entity = baseDao.selectById(id);

        return ConvertUtils.sourceToTarget(entity, ContentDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ContentDTO dto) {
        ContentEntity entity = ConvertUtils.sourceToTarget(dto, ContentEntity.class);

        insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ContentDTO dto) {
        ContentEntity entity = ConvertUtils.sourceToTarget(dto, ContentEntity.class);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String[] ids) {
        //逻辑删除
        //logicDelete(ids, ContentEntity.class);

        //物理删除
        baseDao.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public boolean logicDelete(Long[] ids, Class<ContentEntity> entity) {
        return false;
    }
}
