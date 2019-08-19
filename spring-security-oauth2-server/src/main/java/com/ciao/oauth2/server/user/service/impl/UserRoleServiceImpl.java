package com.ciao.oauth2.server.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ciao.oauth2.server.constant.Constant;
import com.ciao.oauth2.server.mp.service.impl.BaseServiceImpl;
import com.ciao.oauth2.server.mp.tool.page.PageData;
import com.ciao.oauth2.server.mp.utils.ConvertUtils;
import com.ciao.oauth2.server.user.dao.UserRoleDao;
import com.ciao.oauth2.server.user.entity.UserRoleEntity;
import com.ciao.oauth2.server.user.entity.dto.UserRoleDTO;
import com.ciao.oauth2.server.user.service.UserRoleService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 用户角色表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleDao, UserRoleEntity> implements UserRoleService {

    @Override
    public PageData<UserRoleDTO> page(Map<String, Object> params) {
        IPage<UserRoleEntity> page = baseDao.selectPage(
                getPage(params, Constant.CREATE_DATE, false),
                getWrapper(params)
        );

        return getPageData(page, UserRoleDTO.class);
    }

    @Override
    public List<UserRoleDTO> list(Map<String, Object> params) {
        List<UserRoleEntity> entityList = baseDao.selectList(getWrapper(params));

        return ConvertUtils.sourceToTarget(entityList, UserRoleDTO.class);
    }

    private QueryWrapper<UserRoleEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<UserRoleEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        //wrapper.eq(Constant.DEL_FLAG, DelFlagEnum.NORMAL.value());

        return wrapper;
    }

    @Override
    public UserRoleDTO get(String id) {
        UserRoleEntity entity = baseDao.selectById(id);

        return ConvertUtils.sourceToTarget(entity, UserRoleDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(UserRoleDTO dto) {
        UserRoleEntity entity = ConvertUtils.sourceToTarget(dto, UserRoleEntity.class);

        insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(UserRoleDTO dto) {
        UserRoleEntity entity = ConvertUtils.sourceToTarget(dto, UserRoleEntity.class);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String[] ids) {
        //逻辑删除
        //logicDelete(ids, UserRoleEntity.class);

        //物理删除
        baseDao.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public boolean logicDelete(Long[] ids, Class<UserRoleEntity> entity) {
        return false;
    }
}
