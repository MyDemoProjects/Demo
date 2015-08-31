/** */
package org.zzc.base.model.entity;

import org.zzc.base.model.util.JsonTool;

/**
 * @功能:用于消息传递
 * @项目名:bdfarm
 * @作者:wangjz
 * @日期:2015年7月7日下午2:59:17
 */
public class MsgInfo {
	/** 消息状态id,大于0表示正确，小于等于0表示错误 */
	private Integer id = new Integer(0);
	/** 消息内容 */
	private String msg;
	/** 用于返回额外的信息 */
	private String remark;

	/**
	 * 
	 */
	public MsgInfo() {
		super();
	}

	/**
	 * @param msg
	 */
	public MsgInfo(String msg) {
		super();
		this.msg = msg;
	}

	/**
	 * @param id
	 * @param msg
	 */
	public MsgInfo(Integer id, String msg) {
		super();
		this.id = id;
		this.msg = msg;
	}

	/**
	 * @param id
	 * @param msg
	 */
	public MsgInfo(Integer id, String msg, String remark) {
		super();
		this.id = id;
		this.msg = msg;
		this.remark = remark;
	}

	/**
	 * @取得 消息状态id,大于0表示正确，小于等于0表示错误
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @设置 消息状态id,大于0表示正确，小于等于0表示错误
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @取得 消息内容
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @设置 消息内容
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @取得 用于返回额外的信息
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @设置 用于返回额外的信息
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 重写toString方法，用json转成字符串
	 */
	@Override
	public String toString() {
		return JsonTool.getJsonString(this);
	}

}
