package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlMetadataHandler;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountDaoTest {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/sample?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "yusuke.mysql"; // パスワードを"pass"→""(空)に修正→caching_sha2_passwordを使用して"yusuke.mysql"に変更
    private static final String SCHEMA = "sample";

    private static IDatabaseTester dbTester;

    @BeforeAll
    public static void before() throws Exception {

        // ☆ MySQLの設定を反映させるためにgetConnectionメソッドをオーバーライド
        dbTester = new JdbcDatabaseTester(
                DRIVER_NAME, CONNECTION_URL, USER, PASSWORD, SCHEMA) {
            @Override
            public IDatabaseConnection getConnection() throws Exception {
                IDatabaseConnection con = super.getConnection();
                con.getConfig().setProperty(DatabaseConfig.PROPERTY_METADATA_HANDLER, new MySqlMetadataHandler());
                return con;
            }
        };

        //テーブルに初期化用のデータを投入する処理を記述する
        IDataSet dataSet =
                new FlatXmlDataSetBuilder().build(new File("src/test/resources/data/init.xml"));

        dbTester.setDataSet(dataSet);
        dbTester.setSetUpOperation(DatabaseOperation.REFRESH);

        dbTester.onSetup();
    }

    @AfterAll
    public static void after() throws Exception {
        dbTester.setTearDownOperation(DatabaseOperation.NONE);
        dbTester.onTearDown();
    }

    @Test
    @Order(1)
    public void searchTest(){

        //ID"1"を指定してsearchメソッドを呼び出し、テストを実行する
    	AccountDao dao = new AccountDao();

    	Account account = dao.search("1");
    	assertNotNull(account);

    	String expected = "pass1";
    	String actual = account.getPass();

    	assertEquals(expected, actual);

    }

    @Test
    public void insertTest() throws Exception {

        //ID"3",PASS"pass3"でオブジェクトを生成して、insertするテスト
    	Account account = new Account("3", "pass3");
    	AccountDao dao = new AccountDao();
    	dao.insert(account);

    	IDataSet databaseDataSet = dbTester.getConnection().createDataSet();
    	ITable actualTable = databaseDataSet.getTable("account");

    	IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/test/resources/data/expected.xml"));
    	ITable expectedTable = expectedDataSet.getTable("account");

    	assertEquals(expectedTable.getRowCount(), actualTable.getRowCount());
    }
}
