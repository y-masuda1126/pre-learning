package org.example;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlMetadataHandler;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// ☆ テストの実行順を設定
// @Orderで設定順にテスト実行します
// @TestMethodOrderを指定しないと実行順は保証されません
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountDaoTest {

    /**
     * JDBCドライバー名
     */
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    /**
     * DB接続文字列
     */
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/sample?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    /**
     * 接続ユーザー
     */
    private static final String USER = "root";

    /**
     * 接続パスワード
     */
    private static final String PASSWORD = "pass";

    /**
     * スキーマ名
     */
    private static final String SCHEMA = "sample";

    private static IDatabaseTester dbTester;

    /**
     * 初期化処理
     * JdbcDatabaseTesterの初期化を行います
     */
    @BeforeAll
    public static void setUp() throws Exception {

        // ☆ MySQLの設定を反映させるためにgetConnectionメソッドをオーバーライドします
        dbTester = new JdbcDatabaseTester(DRIVER_NAME, CONNECTION_URL, USER, PASSWORD, SCHEMA) {
            @Override
            public IDatabaseConnection getConnection() throws Exception {
                IDatabaseConnection con = super.getConnection();
                con.getConfig().setProperty(DatabaseConfig.PROPERTY_METADATA_HANDLER, new MySqlMetadataHandler());
                return con;
            }
        };
    }

    /**
     * 終了処理
     * JdbcDatabaseTesterの終了処理を行います
     */
    @AfterAll
    public static void tearDown() throws Exception {
        dbTester.setTearDownOperation(DatabaseOperation.NONE);
        dbTester.onTearDown();
    }

    @Test
    @Order(1) // ☆実行順をセット
    public void searchTest() throws Exception {
        // 初期データを投入
        IDataSet dataSet =
                new FlatXmlDataSetBuilder().build(new File("src/test/resources/data/init_1.xml"));

        dbTester.setDataSet(dataSet);
        dbTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT); // 全てのデータを削除後、INSERT
        dbTester.onSetup();

        //ID "1" を指定してsearchメソッドを呼び出し、テストを実行する

        AccountDao dao = new AccountDao();

        Account account = dao.search("1");
        assertNotNull(account);

        String expected = "pass1";
        String actual = account.getPass();

        assertEquals(expected, actual);
    }

    @Test
    @Order(2)
    public void insertTest() throws Exception {

        // 初期データを投入
        IDataSet dataSet =
                new FlatXmlDataSetBuilder().build(new File("src/test/resources/data/init_2.xml"));

        dbTester.setDataSet(dataSet);
        dbTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        dbTester.onSetup();

        // ID "2_3", PASS "pass2_3" でオブジェクトを生成して、insertするテスト
        Account account = new Account("2_3", "pass2_3");
        AccountDao dao = new AccountDao();
        dao.insert(account);

        // 実際のテーブルのデータセットを取得
        IDataSet databaseDataSet = dbTester.getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("account");

        // 期待値のデータセットを取得
        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/test/resources/data/expected_2.xml"));
        ITable expectedTable = expectedDataSet.getTable("account");

        // 期待値と実際の値の比較を行う
        // dbunitのassertEqualsを使う
        Assertion.assertEquals(expectedTable, actualTable);
    }
}
