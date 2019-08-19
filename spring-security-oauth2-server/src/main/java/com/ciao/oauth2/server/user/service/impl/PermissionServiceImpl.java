package com.ciao.oauth2.server.user.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ciao.oauth2.server.constant.Constant;
import com.ciao.oauth2.server.mp.service.impl.BaseServiceImpl;
import com.ciao.oauth2.server.mp.tool.page.PageData;
import com.ciao.oauth2.server.mp.utils.ConvertUtils;
import com.ciao.oauth2.server.user.dao.PermissionDao;
import com.ciao.oauth2.server.user.entity.PermissionEntity;
import com.ciao.oauth2.server.user.entity.dto.PermissionDTO;
import com.ciao.oauth2.server.user.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 权限表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<PermissionDao, PermissionEntity> implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public PageData<PermissionDTO> page(Map<String, Object> params) {
        IPage<PermissionEntity> page = baseDao.selectPage(
                getPage(params, Constant.CREATE_DATE, false),
                getWrapper(params)
        );

        return getPageData(page, PermissionDTO.class);
    }

    @Override
    public List<PermissionDTO> list(Map<String, Object> params) {
        List<PermissionEntity> entityList = baseDao.selectList(getWrapper(params));

        return ConvertUtils.sourceToTarget(entityList, PermissionDTO.class);
    }

    private QueryWrapper<PermissionEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PermissionEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);
        //wrapper.eq(Constant.DEL_FLAG, DelFlagEnum.NORMAL.value());

        return wrapper;
    }

    @Override
    public PermissionDTO get(String id) {
        PermissionEntity entity = baseDao.selectById(id);

        return ConvertUtils.sourceToTarget(entity, PermissionDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PermissionDTO dto) {
        PermissionEntity entity = ConvertUtils.sourceToTarget(dto, PermissionEntity.class);

        insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(PermissionDTO dto) {
        PermissionEntity entity = ConvertUtils.sourceToTarget(dto, PermissionEntity.class);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String[] ids) {
        //逻辑删除
        //logicDelete(ids, PermissionEntity.class);

        //物理删除
        baseDao.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public List<PermissionEntity> listPermissionByUserId(Long userId) {

        return permissionDao.listPermissionByUserId(userId);
    }

    @Override
    public boolean logicDelete(Long[] ids, Class<PermissionEntity> entity) {
        return false;
    }
}
