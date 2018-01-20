package com.change.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.change.entity.LoginUser;
import com.change.service.ILoginUserService;
import com.change.service.impl.LoginUserServiceImpl;
import com.change.swagger.result.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import redis.clients.jedis.Jedis;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ck
 * @since 2018-01-06
 */
@Controller
@RequestMapping("/test")
@Api(value = "测试api", description = "用户测试")
public class TestLoginUserController {
	final static Logger logger = LoggerFactory.getLogger(TestLoginUserController.class);
    @Autowired
    ILoginUserService service;

    @ApiOperation(value = "获取个人信息")
    @ApiResponse(code = 200, message = "success", response = Result.class)
    @GetMapping(value="/get/{id}")
    @ResponseBody
	public Map<String, Object> get( @ApiParam(required = true, value = "唯一标识") @PathVariable Integer id) throws Exception {
    	TestRedisFlag();
    	logger.info("查询开始");
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		try {
			List<LoginUser> list = service.getLoginUserListiByEqId(id);
			logger.info("list="+list);
			flag=true;
			map.put("list", list);
		} catch (Exception e) {
			map.put("flag", flag);
			map.put("msg", e.getMessage());
		}
		logger.info("查询结束 状态："+flag+"");
		return map;
	}
    public void TestRedisFlag(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        logger.info("连接成功");
        //查看服务是否运行
        logger.info("服务正在运行: "+jedis.ping()+"");
	}
    
}
