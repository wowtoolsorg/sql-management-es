package org.wowtools.sqlmanagementes.esmanagement;

/**
 * 执行处理的es命令
 *
 * @author liuyu
 *
 */
public class EsCommand {

	/**
	 * Put类型
	 */
	public static final byte Type_Put = 0;

	/**
	 * Post类型
	 */
	public static final byte Type_Post = 1;

	/**
	 * Delete类型
	 */
	public static final byte Type_Delete = 2;

	private byte type;

	private String baseUrl;

	private String commandUrl;

	private String param;

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		String typeName;
		if(Type_Put == type) {
			typeName = "PUT";
		} else if(Type_Post == type) {
			typeName = "POST";
		} else {
			typeName = "DELETE";
		}
		sb.append(typeName);
		sb.append(" ").append(commandUrl);
		if(null != param) {
			sb.append("\n").append(param);
		}
		return sb.toString();
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		if(type != Type_Put && type != Type_Post && type != Type_Delete) {
			throw new RuntimeException("错误的type:" + type);
		}
		this.type = type;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getCommandUrl() {
		return commandUrl;
	}

	public void setCommandUrl(String commandUrl) {
		this.commandUrl = commandUrl;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

}
