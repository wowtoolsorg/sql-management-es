package org.wowtools.sqlmanagementes.sqlparser;

import java.io.StringReader;
import java.util.List;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.update.Update;

import org.json.JSONObject;
import org.wowtools.sqlmanagementes.esmanagement.EsCommand;
import org.wowtools.sqlmanagementes.sqlparser.visitor.helper.Columns2JsonHelper;
import org.wowtools.sqlmanagementes.sqlparser.visitor.update.UpdateColumnsExpressionVisitor;
import org.wowtools.sqlmanagementes.sqlparser.visitor.update.UpdateWhereExpressionVisitor;

/**
 * 将sql解析为EsCommand
 *
 * @author liuyu
 *
 */
public class ParseSql2EsCommand {

	public static EsCommand parse(String sql,String idxName,String typeName) {
		CCJSqlParserManager pm = new CCJSqlParserManager();
		net.sf.jsqlparser.statement.Statement statement = null;
		try {
			statement = pm.parse(new StringReader(sql));
		} catch(JSQLParserException e) {
			throw new RuntimeException("sql解析异常",e);
		}
		if(statement instanceof Update) {
			return parseUpdate((Update) statement,idxName,typeName);
		}
		throw new RuntimeException("sql解析异常,不支持的操作类型:"+statement.getClass().getSimpleName());
	}
	@SuppressWarnings("unchecked")
	private static EsCommand parseUpdate(Update updateStatement,String idxName,String typeName) {
		EsCommand esCommand = new EsCommand();
		esCommand.setType(EsCommand.Type_Post);
		//解析param
		List<Column> columns = updateStatement.getColumns();
		List<Expression> expressions = updateStatement.getExpressions();
		UpdateColumnsExpressionVisitor[] updateColumnsEVs = new UpdateColumnsExpressionVisitor[expressions.size()];
		int i = 0;
		for(Expression expression:expressions){
			UpdateColumnsExpressionVisitor updateColumnsEV = new UpdateColumnsExpressionVisitor();
			expression.accept(updateColumnsEV);
			updateColumnsEVs[i] = updateColumnsEV;
			i++;
		}
		Columns2JsonHelper columns2JsonHelper = new Columns2JsonHelper(columns, updateColumnsEVs);
		JSONObject joSource = columns2JsonHelper.getJson();
		JSONObject joDoc = new JSONObject();
		joDoc.put("doc", joSource);
		esCommand.setParam(joDoc.toString());
		//解析id
		Expression where = updateStatement.getWhere();
		UpdateWhereExpressionVisitor updateWhereEV = new UpdateWhereExpressionVisitor();
		where.accept(updateWhereEV);
		String id = updateWhereEV.getValueGeter().get().toString();
		String commandUrl = "/"+idxName+"/"+typeName+"/"+id+"/_update";
		esCommand.setCommandUrl(commandUrl );
		return esCommand;
	}

}
