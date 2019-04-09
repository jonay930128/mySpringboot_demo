package com.jd.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jd.springboot.domain.JobInfo;
import com.jd.springboot.mapper.JobInfoMapper;
import com.jd.springboot.service.JobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-04-10 19:58
 */
@Service
public class JobInfoServiceImpl implements JobInfoService {

    @Autowired
    private JobInfoMapper jobInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addJobInfo(JobInfo jobInfo) {
        return jobInfoMapper.insert(jobInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteJobInfo(Long id) {
        return jobInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<JobInfo> findJobInfo(String jobName, String appName) {
        Example example = new Example(JobInfo.class);
        Example.Criteria criteria = example.createCriteria();
        example.selectProperties("jobName");
        if (StringUtil.isNotEmpty(jobName)) {
            criteria.andLike("jobName","%" + jobName + "%");
        }
        if (StringUtil.isNotEmpty(appName)) {
            criteria.andLike("appName","%" + appName + "%");
        }
        List<JobInfo> jobInfos = jobInfoMapper.selectByExample(example);
        return jobInfos;
    }

    @Override
    public PageInfo<JobInfo> findJobInfoByPage(String jobName, String appName, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(JobInfo.class);
        Example.Criteria criteria = example.createCriteria();
        example.selectProperties("jobName");
        if (StringUtil.isNotEmpty(jobName)) {
            criteria.andLike("jobName","%" + jobName + "%");
        }
        if (StringUtil.isNotEmpty(appName)) {
            criteria.andLike("appName","%" + appName + "%");
        }
        List<JobInfo> jobInfos = jobInfoMapper.selectByExample(example);

//        List<JobInfo> jobInfos = jobInfoMapper.customQuery(jobName,appName);

        PageInfo<JobInfo> page = new PageInfo<>(jobInfos);
        return page;
    }
}
