package com.change.service.impl;

import com.change.entity.LoginUser;
import com.change.mapper.LoginUserMapper;
import com.change.service.ILoginUserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ck
 * @since 2018-01-06
 */
@Service
public class LoginUserServiceImpl extends ServiceImpl<LoginUserMapper, LoginUser> implements ILoginUserService {
	
	final static Logger logger = LoggerFactory.getLogger(LoginUserServiceImpl.class);
	
	 @Cacheable(value = "getLoginUserListiByEqId", keyGenerator = "customKeyGenerator")	 
    public List<LoginUser> getLoginUserListiByEqId(Integer id) {
    	 logger.info("无缓存的时候调用这里");
        return baseMapper.selectList(new EntityWrapper<LoginUser>().eq("id", id));
    }

}
