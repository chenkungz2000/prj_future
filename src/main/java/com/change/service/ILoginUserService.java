package com.change.service;

import com.change.entity.LoginUser;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ck
 * @since 2018-01-06
 */
public interface ILoginUserService extends IService<LoginUser> {

	List<LoginUser> getLoginUserListiByEqId(Integer id);

}
