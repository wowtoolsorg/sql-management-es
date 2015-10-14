package org.wowtools.sqlmanagementes.sqlparser.visitor.valuegeter;
/**
 * 常量值获取器 ，如：从update test set name = 'hi'中提取name的值为hi
 * @author liuyu
 *
 */
public class ConstantValueGeter implements ValueGeter {

	private Object constant;

	public ConstantValueGeter(Object constant){
		this.constant = constant;
	}

	public void setValue(Object constant){
		this.constant = constant;
	}

	public Object get() {
		return constant;
	}

}
