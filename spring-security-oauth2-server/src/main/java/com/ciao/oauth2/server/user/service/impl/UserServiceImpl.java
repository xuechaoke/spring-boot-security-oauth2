package com.ciao.oauth2.server.user.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ciao.oauth2.server.constant.Constant;
import com.ciao.oauth2.server.mp.service.impl.BaseServiceImpl;
import com.ciao.oauth2.server.mp.tool.page.PageData;
import com.ciao.oauth2.server.mp.utils.ConvertUtils;
import com.ciao.oauth2.server.user.dao.UserDao;
import com.ciao.oauth2.server.user.entity.UserEntity;
import com.ciao.oauth2.server.user.entity.dto.UserDTO;
import com.ciao.oauth2.server.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 用户表
 *
 * @author xuechaoke 121960452@qq.com
 * @since v1.0.0 2019-08-19
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public PageData<UserDTO> page(Map<String, Object> params) {
        IPage<UserEntity> page = baseDao.selectPage(
                getPage(params, Constant.CREATE_DATE, false),
                getWrapper(params)
        );

        return getPageData(page, UserDTO.class);
    }

    @Override
    public List<UserDTO> list(Map<String, Object> params) {
        List<UserEntity> entityList = baseDao.selectList(getWrapper(params));

        return ConvertUtils.sourceToTarget(entityList, UserDTO.class);
    }

    private QueryWrapper<UserEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(id), "id", id);

        return wrapper;
    }

    @Override
    public UserDTO get(String id) {
        UserEntity entity = baseDao.selectById(id);

        return ConvertUtils.sourceToTarget(entity, UserDTO.class);
    }

    @Override
    public UserEntity queryByUsername(String username) {
        QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
        userEntityQueryWrapper.eq("username",username);
        return baseDao.selectOne(userEntityQueryWrapper);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(UserDTO dto) {
        UserEntity entity = ConvertUtils.sourceToTarget(dto, UserEntity.class);

        insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(UserDTO dto) {
        UserEntity entity = ConvertUtils.sourceToTarget(dto, UserEntity.class);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String[] ids) {
        //逻辑删除
        //logicDelete(ids, UserEntity.class);

        //物理删除
        baseDao.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public boolean logicDelete(Long[] ids, Class<UserEntity> entity) {
        return false;
    }
}
