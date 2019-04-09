package com.jd.springboot.domain;

import java.util.List;
import java.util.Set;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-05-15 17:14
 */
public class QueryParam {
	Set<Long> idList;
	List<String> jobNameList;

	private JobInfo jobInfo;

	public JobInfo getJobInfo() {
		return jobInfo;
	}

	public void setJobInfo(JobInfo jobInfo) {
		this.jobInfo = jobInfo;
	}

	public Set<Long> getIdList() {
		return idList;
	}

	public void setIdList(Set<Long> idList) {
		this.idList = idList;
	}

	public List<String> getJobNameList() {
		return jobNameList;
	}

	public void setJobNameList(List<String> jobNameList) {
		this.jobNameList = jobNameList;
	}
}
