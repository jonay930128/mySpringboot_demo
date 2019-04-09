package com.jd.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.jd.springboot.domain.JobInfo;
import com.jd.springboot.domain.QueryParam;
import com.jd.springboot.response.Result;
import com.jd.springboot.response.SuccessResult;
import com.jd.springboot.service.JobInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 请填写类的描述
 * job端controller
 * @author wangruxing
 * @date 2018-04-10 19:56
 */
@RestController
@RequestMapping("/jobInfo")
public class JobInfoController {
    @Autowired
    private JobInfoService jobInfoService;

    @ApiOperation(value="新建job", notes="增加jobInfo接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "jobInfo", value = "job详细实体jobInfo", required = true, dataType = "JobInfo"),
			@ApiImplicitParam(name = "param", value = "job详细实体jobInfo", required = true, dataType = "QueryParam"),
			@ApiImplicitParam(name = "jobName", value = "job名称", required = false, dataType = "String" ,paramType = "query")
	})
    @RequestMapping(value="/addJobInfo", method=RequestMethod.POST)
    public Result addJobInfo(@RequestBody JobInfo jobInfo,String jobName,@RequestBody QueryParam param){
        int i = jobInfoService.addJobInfo(jobInfo);
        return new SuccessResult(i);
    }

    @ApiOperation(value="删除job", notes="根据id删除job")
    @ApiImplicitParam(name = "id", value = "job的ID", required = true, dataType = "Long",defaultValue = "1",paramType = "query")
    @RequestMapping(value="/deleteJobInfo", method=RequestMethod.DELETE)
    public Result deleteJobInfo(Long id){
        int i = jobInfoService.deleteJobInfo(id);
        return new SuccessResult(i);
    }

    @ApiOperation(value="查询job", notes="根据条件筛选job")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jobName", value = "job名称", required = false, dataType = "String" ,paramType = "query"),
            @ApiImplicitParam(name = "appName", value = "app名称", required = false, dataType = "String",paramType = "query")
    })
    @RequestMapping(value="/findJobInfo", method=RequestMethod.POST)
    public Result findJobInfo(String jobName,String appName){
        List<JobInfo> data = jobInfoService.findJobInfo(jobName,appName);
        return new SuccessResult(data);
    }


	@ApiOperation(value="分页查询job", notes="根据条件分页筛选job")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "jobName", value = "job名称", required = false, dataType = "String" ,paramType = "query"),
			@ApiImplicitParam(name = "appName", value = "app名称", required = false, dataType = "String",paramType = "query"),
			@ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "int",paramType = "query",defaultValue = "1"),
			@ApiImplicitParam(name = "pageSize", value = "每页多少条", required = true, dataType = "int",paramType = "query",defaultValue = "10")
	})
	@RequestMapping(value="/findJobInfoByPage", method=RequestMethod.POST)
	public PageInfo<JobInfo> findJobInfoByPage(String jobName,String appName,Integer pageNum,Integer pageSize) throws Exception{
		PageInfo<JobInfo> data = jobInfoService.findJobInfoByPage(jobName,appName,pageNum,pageSize);
		throw new Exception("ldjfsldfj");
//        return new SuccessResult(data);
	}
}
