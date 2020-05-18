package com.jd.springboot.controller;

import com.jd.springboot.annotation.LineConvertHump;
import com.jd.springboot.domain.JobInfo;
import com.jd.springboot.response.Result;
import com.jd.springboot.response.SuccessResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2020/5/18 10:36 上午
 */
@RestController
@RequestMapping("line")
public class LineConvertHumpTestController {

    Logger logger = LoggerFactory.getLogger(LineConvertHumpTestController.class);

    @RequestMapping(value="/addJobInfo", method= RequestMethod.POST)
    public Result addJobInfo(@LineConvertHump JobInfo jobInfo){
        logger.info("#LineConvertHumpTestController.addJobInfo# jobInfo:{}", jobInfo);
        return new SuccessResult();
    }
}
