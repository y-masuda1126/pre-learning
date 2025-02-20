package junit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
	private static final String URL = "jdbc:mysql://localhost:3306/sample?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "pass";

	private static final String SELECT_SQL = "SELECT * FROM account WHERE id = ?;";
	private static final String INSERT_SQL = "INSERT IGNORE INTO account (id, pass) values(?, ?);";

	/**
	 * idを指定し、アカウント情報を取得する。
	 * @param id 一意のID
	 * @return 指定されたIDのアカウント情報、指定されたIDが存在しない場合はnull
	 */
	public Account search(String id) {
		Account account = new Account();

	    try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
	        PreparedStatement ps = conn.prepareStatement(SELECT_SQL)){

	    	ps.setString(1, id);

	        try(ResultSet rs = ps.executeQuery()){
	            while (rs.next()) {
	            	if(rs.getString("id").contentEquals(id)) {
	            		account.setId(id);
	            		account.setPass(rs.getString("pass"));
	            	}
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new RuntimeException("データベース接続エラー", e); // ☆ エラー発生時に例外をスローする
		}
		return account;
	}

	public int insert(Account account) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(INSERT_SQL)){

			ps.setString(1, account.getId());
			ps.setString(2, account.getPass());

			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("データベース接続エラー", e); // ☆ エラー発生時に例外をスローする
		}
	}

}
