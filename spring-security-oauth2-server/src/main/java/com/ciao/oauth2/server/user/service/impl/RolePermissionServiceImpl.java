package com.ciao.oauth2.server.user.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ciao.oauth2.server.constant.Constant;
import com.ciao.oauth2.server.mp.service.impl.BaseServiceImpl;
import com.ciao.oauth2.server.mp.tool.page.PageData;
import com.ciao.oauth2.server.mp.utils.ConvertUtils;
import com.ciao.oauth2.server.user.dao.RolePermissionDao;
import com.ciao.oauth2.server.user.entity.RolePermissionEntity;
import com.ciao.oauth2.server.user.entity.dto.RolePermissionDTO;
import com.ciao.oauth2.server.user.service.RolePermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 角色权限表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Service
public class RolePermissionServiceImpl extends BaseServiceImpl<RolePermissionDao, RolePermissionEntity> implements RolePermissionService {

    @Override
    public PageData<RolePermissionDTO> page(Map<String, Object> params) {
        IPage<RolePermissionEntity> page = baseDao.selectPage(
                getPage(params, Constant.CREATE_DATE, false),
                getWrapper(params)
        );

        return getPageData(page, RolePermissionDTO.class);
    }

    @Override
    public List<RolePermissionDTO> list(Map<String, Object> params) {
        List<RolePermissionEntity> entityList = baseDao.selectList(getWrapper(params));

        return ConvertUtils.sourceToTarget(entityList, RolePermissionDTO.class);
    }

    private QueryWrapper<RolePermissionEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<RolePermissionEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);
        //wrapper.eq(Constant.DEL_FLAG, DelFlagEnum.NORMAL.value());

        return wrapper;
    }

    @Override
    public RolePermissionDTO get(String id) {
        RolePermissionEntity entity = baseDao.selectById(id);

        return ConvertUtils.sourceToTarget(entity, RolePermissionDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(RolePermissionDTO dto) {
        RolePermissionEntity entity = ConvertUtils.sourceToTarget(dto, RolePermissionEntity.class);

        insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(RolePermissionDTO dto) {
        RolePermissionEntity entity = ConvertUtils.sourceToTarget(dto, RolePermissionEntity.class);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String[] ids) {
        //逻辑删除
        //logicDelete(ids, RolePermissionEntity.class);

        //物理删除
        baseDao.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public boolean logicDelete(Long[] ids, Class<RolePermissionEntity> entity) {
        return false;
    }
}
