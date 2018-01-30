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

	public boolean updateValue(LoginUser user);

	boolean insert(LoginUser user);

	void update(Integer id, String name, String password, String phone);

	boolean delete(Integer id);
	
	List<LoginUser> getData(LoginUser user);
	
	List<LoginUser> getLoginUserListById(Integer id);

	List<LoginUser> getListBySQL();

	LoginUser getLoginUserByPhoneAndName(String phone, String name);

	LoginUser getLoginUserByPhoneAndPassword(String phone, String password);

	LoginUser getLoginUserByNameAndPassword(String name, String password);

	LoginUser getLoginUserById(Integer id);

	List<LoginUser> getLoginUserListiByEqId(Integer id);

	List<LoginUser> getLoginUserListiByWhereId(Integer id);

	List<LoginUser> getLoginUserListiByAndId(Integer id);

	LoginUser getLoginUserByandName(String name);

	LoginUser getLoginUserByandPhone(String phone);


}
