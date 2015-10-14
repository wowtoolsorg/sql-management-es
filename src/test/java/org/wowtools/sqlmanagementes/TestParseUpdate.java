package org.wowtools.sqlmanagementes;

import org.wowtools.sqlmanagementes.esmanagement.EsCommand;
import org.wowtools.sqlmanagementes.sqlparser.ParseSql2EsCommand;


public class TestParseUpdate {

	public static void main(String[] args) {
		String sql = "update test set team_leader_name = 'tom',team_name = 'google',type = 100 where _id = '1'";
		EsCommand cmd = ParseSql2EsCommand.parse(sql,"school","class");
		System.out.println(cmd);
	}

}
