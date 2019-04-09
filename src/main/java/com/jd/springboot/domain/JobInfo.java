package com.jd.springboot.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "job_info")
public class JobInfo {

    /**
     * 自增
     * //    @GeneratedValue(strategy = GenerationType.IDENTITY)
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * job名称
     */
    @Column(name = "job_name")
    private String jobName;

    /**
     * 应用项目名称
     */
    @Column(name = "app_name")
    private String appName;

    /**
     * 说明
     */
    private String description;

    /**
     * 责任人pin
     */
    private String pin;

    /**
     * 杰夫接口的全路径名
     */
    @Column(name = "service_full_path")
    private String serviceFullPath;

    /**
     * 调用方法名称
     */
    @Column(name = "method_name")
    private String methodName;

    /**
     * 方法参数类型
     */
    @Column(name = "method_param_type")
    private String methodParamType;

    /**
     * 方法参数值
     */
    @Column(name = "method_param_value")
    private String methodParamValue;

    /**
     * 杰夫分组别名
     */
    private String alias;

    /**
     * 杰夫分组token
     */
    private String token;

    /**
     * 杰夫协议
     */
    private String protocol;

    /**
     * 调用超时毫秒数
     */
    private Integer timeout;

    /**
     * 0 jsf 同步调用，1 jsf异步调用
     */
    @Column(name = "jsf_async")
    private Integer jsfAsync;

    /**
     * 分片数量
     */
    @Column(name = "sharding_num")
    private Integer shardingNum;

    /**
     * 定时cron表达式
     */
    @Column(name = "job_cron")
    private String jobCron;

    /**
     * 接口参数
     */
    @Column(name = "sharding_param")
    private String shardingParam;

    /**
     * job运行状态。1 未分派 2就绪
     */
    @Column(name = "job_status")
    private Integer jobStatus;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 最新修改时间
     */
    private Date modified;

    /**
     * 是否有效
     */
    private Integer status;

    /**
     * 1:预发环境，2:线上环境
     */
    @Column(name = "job_environment")
    private Integer jobEnvironment;

    /**
     * 获取自增
     *
     * @return id - 自增
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增
     *
     * @param id 自增
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取job名称
     *
     * @return job_name - job名称
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 设置job名称
     *
     * @param jobName job名称
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * 获取应用项目名称
     *
     * @return app_name - 应用项目名称
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 设置应用项目名称
     *
     * @param appName 应用项目名称
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * 获取说明
     *
     * @return description - 说明
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置说明
     *
     * @param description 说明
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取责任人pin
     *
     * @return pin - 责任人pin
     */
    public String getPin() {
        return pin;
    }

    /**
     * 设置责任人pin
     *
     * @param pin 责任人pin
     */
    public void setPin(String pin) {
        this.pin = pin;
    }

    /**
     * 获取杰夫接口的全路径名
     *
     * @return service_full_path - 杰夫接口的全路径名
     */
    public String getServiceFullPath() {
        return serviceFullPath;
    }

    /**
     * 设置杰夫接口的全路径名
     *
     * @param serviceFullPath 杰夫接口的全路径名
     */
    public void setServiceFullPath(String serviceFullPath) {
        this.serviceFullPath = serviceFullPath;
    }

    /**
     * 获取调用方法名称
     *
     * @return method_name - 调用方法名称
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * 设置调用方法名称
     *
     * @param methodName 调用方法名称
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * 获取方法参数类型
     *
     * @return method_param_type - 方法参数类型
     */
    public String getMethodParamType() {
        return methodParamType;
    }

    /**
     * 设置方法参数类型
     *
     * @param methodParamType 方法参数类型
     */
    public void setMethodParamType(String methodParamType) {
        this.methodParamType = methodParamType;
    }

    /**
     * 获取方法参数值
     *
     * @return method_param_value - 方法参数值
     */
    public String getMethodParamValue() {
        return methodParamValue;
    }

    /**
     * 设置方法参数值
     *
     * @param methodParamValue 方法参数值
     */
    public void setMethodParamValue(String methodParamValue) {
        this.methodParamValue = methodParamValue;
    }

    /**
     * 获取杰夫分组别名
     *
     * @return alias - 杰夫分组别名
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 设置杰夫分组别名
     *
     * @param alias 杰夫分组别名
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * 获取杰夫分组token
     *
     * @return token - 杰夫分组token
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置杰夫分组token
     *
     * @param token 杰夫分组token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取杰夫协议
     *
     * @return protocol - 杰夫协议
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * 设置杰夫协议
     *
     * @param protocol 杰夫协议
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * 获取调用超时毫秒数
     *
     * @return timeout - 调用超时毫秒数
     */
    public Integer getTimeout() {
        return timeout;
    }

    /**
     * 设置调用超时毫秒数
     *
     * @param timeout 调用超时毫秒数
     */
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    /**
     * 获取0 jsf 同步调用，1 jsf异步调用
     *
     * @return jsf_async - 0 jsf 同步调用，1 jsf异步调用
     */
    public Integer getJsfAsync() {
        return jsfAsync;
    }

    /**
     * 设置0 jsf 同步调用，1 jsf异步调用
     *
     * @param jsfAsync 0 jsf 同步调用，1 jsf异步调用
     */
    public void setJsfAsync(Integer jsfAsync) {
        this.jsfAsync = jsfAsync;
    }

    /**
     * 获取分片数量
     *
     * @return sharding_num - 分片数量
     */
    public Integer getShardingNum() {
        return shardingNum;
    }

    /**
     * 设置分片数量
     *
     * @param shardingNum 分片数量
     */
    public void setShardingNum(Integer shardingNum) {
        this.shardingNum = shardingNum;
    }

    /**
     * 获取定时cron表达式
     *
     * @return job_cron - 定时cron表达式
     */
    public String getJobCron() {
        return jobCron;
    }

    /**
     * 设置定时cron表达式
     *
     * @param jobCron 定时cron表达式
     */
    public void setJobCron(String jobCron) {
        this.jobCron = jobCron;
    }

    /**
     * 获取接口参数
     *
     * @return sharding_param - 接口参数
     */
    public String getShardingParam() {
        return shardingParam;
    }

    /**
     * 设置接口参数
     *
     * @param shardingParam 接口参数
     */
    public void setShardingParam(String shardingParam) {
        this.shardingParam = shardingParam;
    }

    /**
     * 获取job运行状态。1 未分派 2就绪
     *
     * @return job_status - job运行状态。1 未分派 2就绪
     */
    public Integer getJobStatus() {
        return jobStatus;
    }

    /**
     * 设置job运行状态。1 未分派 2就绪
     *
     * @param jobStatus job运行状态。1 未分派 2就绪
     */
    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }

    /**
     * 获取创建时间
     *
     * @return created - 创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置创建时间
     *
     * @param created 创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取最新修改时间
     *
     * @return modified - 最新修改时间
     */
    public Date getModified() {
        return modified;
    }

    /**
     * 设置最新修改时间
     *
     * @param modified 最新修改时间
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /**
     * 获取是否有效
     *
     * @return status - 是否有效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置是否有效
     *
     * @param status 是否有效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取1:预发环境，2:线上环境
     *
     * @return job_environment - 1:预发环境，2:线上环境
     */
    public Integer getJobEnvironment() {
        return jobEnvironment;
    }

    /**
     * 设置1:预发环境，2:线上环境
     *
     * @param jobEnvironment 1:预发环境，2:线上环境
     */
    public void setJobEnvironment(Integer jobEnvironment) {
        this.jobEnvironment = jobEnvironment;
    }


	@Override
    public String toString() {
        return "JobInfo{" +
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", appName='" + appName + '\'' +
                ", description='" + description + '\'' +
                ", pin='" + pin + '\'' +
                ", serviceFullPath='" + serviceFullPath + '\'' +
                ", methodName='" + methodName + '\'' +
                ", methodParamType='" + methodParamType + '\'' +
                ", methodParamValue='" + methodParamValue + '\'' +
                ", alias='" + alias + '\'' +
                ", token='" + token + '\'' +
                ", protocol='" + protocol + '\'' +
                ", timeout=" + timeout +
                ", jsfAsync=" + jsfAsync +
                ", shardingNum=" + shardingNum +
                ", jobCron='" + jobCron + '\'' +
                ", shardingParam='" + shardingParam + '\'' +
                ", jobStatus=" + jobStatus +
                ", created=" + created +
                ", modified=" + modified +
                ", status=" + status +
                ", jobEnvironment=" + jobEnvironment +
                '}';
    }
}