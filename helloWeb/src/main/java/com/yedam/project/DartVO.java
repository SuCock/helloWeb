package com.yedam.project;

public class DartVO {
	// 테이블 값을 담기위한 클래스
	private String memId;
	private String memPass;
	private String memName;
	private String memAddr;
	private String memTel;
	private int memPoint;

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPass() {
		return memPass;
	}

	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemAddr() {
		return memAddr;
	}

	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String i) {
		this.memTel = i;
	}

	public int getMemPoint() {
		return memPoint;
	}

	public void setMemPoint(int memPoint) {
		this.memPoint = memPoint;
	}

	@Override
	public String toString() {
		return "MemVO [memId=" + memId + ", memPass=" + memPass + ", memName=" + memName + ", memAddr=" + memAddr
				+ ", memTel=" + memTel + ", memPoint=" + memPoint + "]";
	}
}
