package com.jd.springboot.mapper;

import com.jd.springboot.domain.JobInfo;
import com.jd.springboot.baseMapper.MyMapper;
import com.jd.springboot.domain.QueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface JobInfoMapper extends MyMapper<JobInfo> {
    /**
     * 自定义查询
     * @param jobName
     * @param appName
     * @return
     */
    List<JobInfo> customQuery(@Param("jobName") String jobName, @Param("appName") String appName);

    @Select("select * from job_info")
    List<JobInfo> getAll();

    List<JobInfo> testQueryList(@Param("query") QueryParam queryParam);
}