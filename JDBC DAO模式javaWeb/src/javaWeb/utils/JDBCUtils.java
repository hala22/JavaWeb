package javaWeb.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	// 锟斤拷锟斤拷式
    private static ComboPooledDataSource ds = new ComboPooledDataSource();

    /**
     * 锟斤拷为null锟斤拷示没锟斤拷锟斤拷锟斤拷
     * 锟斤拷锟斤拷为null锟斤拷示锟斤拷锟斤拷锟斤拷
     * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷时锟斤拷锟斤拷要锟斤拷锟斤拷锟斤拷值
     * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷时锟斤拷锟斤拷要锟斤拷锟斤拷锟斤拷值为null
     * 锟斤拷锟斤拷锟节匡拷锟斤拷锟斤拷锟斤拷时锟斤拷锟斤拷dao锟侥讹拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷Connection
     */
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * dao获取链接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        /*
         * 锟斤拷锟斤拷锟斤拷锟斤拷瘢锟斤拷氐锟角帮拷锟斤拷锟斤拷con
         * 锟斤拷锟矫伙拷锟斤拷锟斤拷锟酵拷锟斤拷锟斤拷映胤锟斤拷锟斤拷碌锟絚on
         */
        Connection con = tl.get();//锟斤拷取锟斤拷前锟竭程碉拷锟斤拷锟斤拷锟斤拷锟斤拷
        if(con != null) return con;
        return ds.getConnection();
    }

    /**
     * 锟斤拷锟斤拷锟斤拷锟斤拷
     * @throws SQLException 
     */
    public static void beginTransaction() throws SQLException {
        Connection con = tl.get();//锟斤拷取锟斤拷前锟竭程碉拷锟斤拷锟斤拷锟斤拷锟斤拷
        if(con != null) throw new SQLException("锟窖撅拷锟斤拷锟斤拷锟斤拷锟斤拷锟今，诧拷锟斤拷锟截革拷锟斤拷锟斤拷锟斤拷");
        con = ds.getConnection();//锟斤拷con锟斤拷值锟斤拷锟斤拷示锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
        con.setAutoCommit(false);//锟斤拷锟斤拷为锟街讹拷锟结交
        tl.set(con);//锟窖碉拷前锟斤拷锟斤拷锟斤拷锟接放碉拷tl锟斤拷
    }

    /**
     * 锟结交锟斤拷锟斤拷
     * @throws SQLException 
     */
    public static void commitTransaction() throws SQLException {
        Connection con = tl.get();//锟斤拷取锟斤拷前锟竭程碉拷锟斤拷锟斤拷锟斤拷锟斤拷
        if(con == null) throw new SQLException("没锟斤拷锟斤拷锟斤拷锟斤拷锟结交锟斤拷");
        con.commit();//锟结交锟斤拷锟斤拷
        con.close();//锟截憋拷锟斤拷锟斤拷
        con = null;//锟斤拷示锟斤拷锟斤拷锟斤拷锟斤拷锟�
        tl.remove();
    }

    /**
     * 锟截癸拷锟斤拷锟斤拷
     * @throws SQLException 
     */
    public static void rollbackTransaction() throws SQLException {
        Connection con = tl.get();//锟斤拷取锟斤拷前锟竭程碉拷锟斤拷锟斤拷锟斤拷锟斤拷
        if(con == null) throw new SQLException("没锟斤拷锟斤拷锟斤拷锟杰回癸拷锟斤拷");
        con.rollback();
        con.close();
        con = null;
        tl.remove();
    }

    /**
     * 锟酵凤拷Connection
     * @param con
     * @throws SQLException 
     */
    public static void releaseConnection(Connection connection) throws SQLException {
        Connection con = tl.get();//锟斤拷取锟斤拷前锟竭程碉拷锟斤拷锟斤拷锟斤拷锟斤拷
        if(connection != con) {//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷樱锟斤拷氲鼻帮拷锟斤拷锟斤拷锟斤拷硬锟酵拷锟剿碉拷锟斤拷锟斤拷锟斤拷锟接诧拷锟角碉拷前锟斤拷锟今，匡拷锟皆关闭ｏ拷
            if(connection != null &&!connection.isClosed()) {//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟矫伙拷泄乇眨锟斤拷乇锟街拷锟�
                connection.close();
            }
        }
    }
    
    //这是要使用的
    public static QueryRunner getQueryRunner(){
		try {
//			System.out.println("正在使用连接数："+ds.getNumBusyConnections());
//			System.out.println("空闲连接数："+ds.getNumIdleConnections());
//			System.out.println("总连接数："+ds.getNumConnections());
			return new QueryRunner(ds);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
    
    
}
