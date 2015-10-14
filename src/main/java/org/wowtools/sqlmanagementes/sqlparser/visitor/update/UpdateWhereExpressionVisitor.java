package org.wowtools.sqlmanagementes.sqlparser.visitor.update;

import net.sf.jsqlparser.expression.AllComparisonExpression;
import net.sf.jsqlparser.expression.AnyComparisonExpression;
import net.sf.jsqlparser.expression.CaseExpression;
import net.sf.jsqlparser.expression.DateValue;
import net.sf.jsqlparser.expression.DoubleValue;
import net.sf.jsqlparser.expression.ExpressionVisitor;
import net.sf.jsqlparser.expression.Function;
import net.sf.jsqlparser.expression.InverseExpression;
import net.sf.jsqlparser.expression.JdbcParameter;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.NullValue;
import net.sf.jsqlparser.expression.Parenthesis;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.TimeValue;
import net.sf.jsqlparser.expression.TimestampValue;
import net.sf.jsqlparser.expression.WhenClause;
import net.sf.jsqlparser.expression.operators.arithmetic.Addition;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseAnd;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseOr;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseXor;
import net.sf.jsqlparser.expression.operators.arithmetic.Concat;
import net.sf.jsqlparser.expression.operators.arithmetic.Division;
import net.sf.jsqlparser.expression.operators.arithmetic.Multiplication;
import net.sf.jsqlparser.expression.operators.arithmetic.Subtraction;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.Between;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.ExistsExpression;
import net.sf.jsqlparser.expression.operators.relational.GreaterThan;
import net.sf.jsqlparser.expression.operators.relational.GreaterThanEquals;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.expression.operators.relational.IsNullExpression;
import net.sf.jsqlparser.expression.operators.relational.LikeExpression;
import net.sf.jsqlparser.expression.operators.relational.Matches;
import net.sf.jsqlparser.expression.operators.relational.MinorThan;
import net.sf.jsqlparser.expression.operators.relational.MinorThanEquals;
import net.sf.jsqlparser.expression.operators.relational.NotEqualsTo;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.SubSelect;

import org.wowtools.sqlmanagementes.sqlparser.visitor.valuegeter.ConstantValueGeter;
import org.wowtools.sqlmanagementes.sqlparser.visitor.valuegeter.ValueGeter;
/**
 * update的where条件的表达式访问器
 *
 * @author liuyu
 *
 */
public class UpdateWhereExpressionVisitor implements ExpressionVisitor {

	private ValueGeter valueGeter;

	/**
	 * 获取update的列的值提取器
	 *
	 * @return
	 */
	public ValueGeter getValueGeter() {
		return valueGeter;
	}

	public void visit(NullValue nullValue) {
		// TODO Auto-generated method stub

	}

	public void visit(Function function) {
		// TODO Auto-generated method stub

	}

	public void visit(InverseExpression inverseExpression) {
		// TODO Auto-generated method stub

	}

	public void visit(JdbcParameter jdbcParameter) {
		// TODO Auto-generated method stub

	}

	public void visit(DoubleValue doubleValue) {
		valueGeter = new ConstantValueGeter(doubleValue.getValue());

	}

	public void visit(LongValue longValue) {
		valueGeter = new ConstantValueGeter(longValue.getValue());

	}

	public void visit(DateValue dateValue) {
		// TODO Auto-generated method stub

	}

	public void visit(TimeValue timeValue) {
		// TODO Auto-generated method stub

	}

	public void visit(TimestampValue timestampValue) {
		// TODO Auto-generated method stub

	}

	public void visit(Parenthesis parenthesis) {
		// TODO Auto-generated method stub

	}

	public void visit(StringValue stringValue) {
		valueGeter = new ConstantValueGeter(stringValue.getValue());
	}

	public void visit(Addition addition) {
		// TODO Auto-generated method stub

	}

	public void visit(Division division) {
		// TODO Auto-generated method stub

	}

	public void visit(Multiplication multiplication) {
		// TODO Auto-generated method stub

	}

	public void visit(Subtraction subtraction) {
		// TODO Auto-generated method stub

	}

	public void visit(AndExpression andExpression) {
		// TODO Auto-generated method stub

	}

	public void visit(OrExpression orExpression) {
		// TODO Auto-generated method stub

	}

	public void visit(Between between) {
		// TODO Auto-generated method stub

	}

	public void visit(EqualsTo equalsTo) {
		//TODO 待select的解析代码写完才能递归下面做这里
		String columnName = equalsTo.getLeftExpression().toString();
		if(columnName.equals("_id")){
			valueGeter = new ConstantValueGeter(equalsTo.getRightExpression().toString().replace("'", ""));
		}
	}

	public void visit(GreaterThan greaterThan) {
		// TODO Auto-generated method stub

	}

	public void visit(GreaterThanEquals greaterThanEquals) {
		// TODO Auto-generated method stub

	}

	public void visit(InExpression inExpression) {
		// TODO Auto-generated method stub

	}

	public void visit(IsNullExpression isNullExpression) {
		// TODO Auto-generated method stub

	}

	public void visit(LikeExpression likeExpression) {
		// TODO Auto-generated method stub

	}

	public void visit(MinorThan minorThan) {
		// TODO Auto-generated method stub

	}

	public void visit(MinorThanEquals minorThanEquals) {
		// TODO Auto-generated method stub

	}

	public void visit(NotEqualsTo notEqualsTo) {
		// TODO Auto-generated method stub

	}

	public void visit(Column tableColumn) {
		// TODO Auto-generated method stub

	}

	public void visit(SubSelect subSelect) {
		// TODO Auto-generated method stub

	}

	public void visit(CaseExpression caseExpression) {
		// TODO Auto-generated method stub

	}

	public void visit(WhenClause whenClause) {
		// TODO Auto-generated method stub

	}

	public void visit(ExistsExpression existsExpression) {
		// TODO Auto-generated method stub

	}

	public void visit(AllComparisonExpression allComparisonExpression) {
		// TODO Auto-generated method stub

	}

	public void visit(AnyComparisonExpression anyComparisonExpression) {
		// TODO Auto-generated method stub

	}

	public void visit(Concat concat) {
		// TODO Auto-generated method stub

	}

	public void visit(Matches matches) {
		// TODO Auto-generated method stub

	}

	public void visit(BitwiseAnd bitwiseAnd) {
		// TODO Auto-generated method stub

	}

	public void visit(BitwiseOr bitwiseOr) {
		// TODO Auto-generated method stub

	}

	public void visit(BitwiseXor bitwiseXor) {
		// TODO Auto-generated method stub

	}


}
