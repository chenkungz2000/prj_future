package com.change.mapper;

import com.change.entity.LoginUser;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ck
 * @since 2018-01-06
 */
public interface LoginUserMapper extends BaseMapper<LoginUser> {
	@Select("select * from login_user")
	List<LoginUser> findListBySQL();

	@Select("select * from login_user where phone=#{phone} and name=#{name}")
	LoginUser findLoginUserByPhoneAndName(String phone, String name);
	
	/**
	 * 关联查询
	 * @param params 参数
	 * @return ids
	 */
	List<LoginUser> select(@Param("cm") Map<String, Object> params);
}
