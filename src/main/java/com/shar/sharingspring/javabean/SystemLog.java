package com.shar.sharingspring.javabean;

/**
 * 日志实体
 * 
 * @author zx
 * 
 */
public class SystemLog {
	private int logid;

	private String operuser;//操作用户

	private String opertype;//操作类型

	private String operdetail;//操作内容

	private String operdate;//操作日期

	private String operresult;//操作结果

	private String operip;//操作ip

	public SystemLog() {
	}

	public SystemLog(Integer logid, String operuser, String opertype, String operdetail, String operdate, String operresult, String operip) {
		this.logid = logid;
		this.operuser = operuser;
		this.opertype = opertype;
		this.operdetail = operdetail;
		this.operdate = operdate;
		this.operresult = operresult;
		this.operip = operip;
	}

	public int getLogid() {
		return logid;
	}

	public void setLogid(int logid) {
		this.logid = logid;
	}

	public String getOperuser() {
		return operuser;
	}

	public void setOperuser(String operuser) {
		this.operuser = operuser;
	}

	public String getOpertype() {
		return opertype;
	}

	public void setOpertype(String opertype) {
		this.opertype = opertype;
	}

	public String getOperdetail() {
		return operdetail;
	}

	public void setOperdetail(String operdetail) {
		this.operdetail = operdetail;
	}

	public String getOperdate() {
		return operdate;
	}

	public void setOperdate(String operdate) {
		this.operdate = operdate;
	}

	public String getOperresult() {
		return operresult;
	}

	public void setOperresult(String operresult) {
		this.operresult = operresult;
	}

	public String getOperip() {
		return operip;
	}

	public void setOperip(String operip) {
		this.operip = operip;
	}

	@Override
	public String toString() {
		return "SystemLog{" +
				"logid=" + logid +
				", operuser='" + operuser + '\'' +
				", opertype='" + opertype + '\'' +
				", operdetail='" + operdetail + '\'' +
				", operdate='" + operdate + '\'' +
				", operresult='" + operresult + '\'' +
				", operip='" + operip + '\'' +
				'}';
	}
}
