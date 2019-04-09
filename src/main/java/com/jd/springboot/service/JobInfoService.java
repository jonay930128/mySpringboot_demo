package com.jd.springboot.service;

import com.github.pagehelper.PageInfo;
import com.jd.springboot.domain.JobInfo;

import java.util.List;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-04-10 19:57
 */
public interface JobInfoService {
    int addJobInfo(JobInfo jobInfo);

    int deleteJobInfo(Long id);

    List<JobInfo> findJobInfo(String jobName, String appName);

    PageInfo<JobInfo> findJobInfoByPage(String jobName, String appName, Integer pageNum, Integer pageSize);
}
