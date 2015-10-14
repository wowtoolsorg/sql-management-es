package org.wowtools.sqlmanagementes.sqlparser.visitor.valuegeter;
/**
 * 值获取器 ，如：从update test set name = 'hi'中提取name的值为hi
 * @author liuyu
 *
 */
public interface ValueGeter {

	public Object get();

}
