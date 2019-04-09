package com.jd.springboot;

import com.jd.springboot.domain.JobInfo;
import com.jd.springboot.domain.QueryParam;
import com.jd.springboot.mapper.JobInfoMapper;
import com.jd.springboot.util.Jsons;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {
	Logger logger = LoggerFactory.getLogger(SpringbootDemoApplicationTests.class);
	@Autowired
	private JobInfoMapper jobInfoMapper;

	@Test
	public void test() throws Exception{
		QueryParam queryParam = new QueryParam();
		Set<Long> set = new HashSet<Long>(){{
			add(4L);
			add(5L);
			add(6L);
		}};
//		queryParam.setIdList(set);
		logger.info("test...param:{}",Jsons.objToJson(queryParam));
		List<JobInfo> jobInfos = jobInfoMapper.testQueryList(queryParam);
		System.out.println(jobInfos);


		String s = new String("dkkd".getBytes());
	}
}
