package org.wowtools.sqlmanagementes.sqlparser.visitor.helper;

import java.util.HashMap;
import java.util.List;

import net.sf.jsqlparser.schema.Column;

import org.json.JSONObject;
import org.wowtools.sqlmanagementes.sqlparser.visitor.update.UpdateColumnsExpressionVisitor;

public class Columns2JsonHelper {
	private List<Column> columns;

	private UpdateColumnsExpressionVisitor[] updateColumnsEVs;

	public Columns2JsonHelper(List<Column> columns, UpdateColumnsExpressionVisitor[] updateColumnsEVs) {
		this.columns = columns;
		this.updateColumnsEVs = updateColumnsEVs;
	}

	public JSONObject getJson() {
		JSONObject joSource = new JSONObject();
		int i = 0;
		PropertyInfo pif = new PropertyInfo(joSource);
		for(Column column : columns) {
			pif.setValue(column.getColumnName(), updateColumnsEVs[i].getValueGeter().get());
			i++;
		}
		return joSource;
	}

	private static final class PropertyInfo {
		private HashMap<String, PropertyInfo> subs = new HashMap<String, Columns2JsonHelper.PropertyInfo>();

		private JSONObject jo;

		public PropertyInfo(JSONObject jo) {
			this.jo = jo;
		}

		public void setValue(String columnName, Object value) {
			String[] columnNameSplit = columnName.split("_");
			setValue(columnNameSplit, 0, value);
		}

		private void setValue(String[] columnNameSplit, int start, Object value) {
			if(start == columnNameSplit.length - 1) {
				jo.put(columnNameSplit[start], value);
				return;
			}
			String subName = columnNameSplit[start];
			PropertyInfo sub = subs.get(subName);
			if(null == sub) {
				JSONObject subJo = new JSONObject();
				jo.put(subName, subJo);
				sub = new PropertyInfo(subJo);
				subs.put(subName, sub);
			}
			start++;
			sub.setValue(columnNameSplit, start, value);
		}
	}

}
