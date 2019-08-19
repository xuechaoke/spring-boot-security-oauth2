package com.ciao.oauth2.server.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ciao.oauth2.server.constant.Constant;
import com.ciao.oauth2.server.mp.service.impl.BaseServiceImpl;
import com.ciao.oauth2.server.mp.tool.page.PageData;
import com.ciao.oauth2.server.mp.utils.ConvertUtils;
import com.ciao.oauth2.server.user.dao.RoleDao;
import com.ciao.oauth2.server.user.entity.RoleEntity;
import com.ciao.oauth2.server.user.entity.dto.RoleDTO;
import com.ciao.oauth2.server.user.service.RoleService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 角色表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleDao, RoleEntity> implements RoleService {

    @Override
    public PageData<RoleDTO> page(Map<String, Object> params) {
        IPage<RoleEntity> page = baseDao.selectPage(
                getPage(params, Constant.CREATE_DATE, false),
                getWrapper(params)
        );

        return getPageData(page, RoleDTO.class);
    }

    @Override
    public List<RoleDTO> list(Map<String, Object> params) {
        List<RoleEntity> entityList = baseDao.selectList(getWrapper(params));

        return ConvertUtils.sourceToTarget(entityList, RoleDTO.class);
    }

    private QueryWrapper<RoleEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<RoleEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        //wrapper.eq(Constant.DEL_FLAG, DelFlagEnum.NORMAL.value());

        return wrapper;
    }

    @Override
    public RoleDTO get(String id) {
        RoleEntity entity = baseDao.selectById(id);

        return ConvertUtils.sourceToTarget(entity, RoleDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(RoleDTO dto) {
        RoleEntity entity = ConvertUtils.sourceToTarget(dto, RoleEntity.class);

        insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(RoleDTO dto) {
        RoleEntity entity = ConvertUtils.sourceToTarget(dto, RoleEntity.class);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String[] ids) {
        //逻辑删除
        //logicDelete(ids, RoleEntity.class);

        //物理删除
        baseDao.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public boolean logicDelete(Long[] ids, Class<RoleEntity> entity) {
        return false;
    }
}
