package basic.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import info.model.InfoDAOImpl;

public class ConnectDAOImpl {
	
	private static ConnectDAOImpl connenctDAOImpl = null;
	
    private String driver = null;
    private String url = null;
    private String username = null;
    private String password = null;
    private DataSource ds = null;
    
    private ConnectDAOImpl() {
        
        try{
            Context context = new InitialContext();
            ds = (DataSource)context.lookup("java:/comp/env/jdbc/mydbcp");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static ConnectDAOImpl getInstance() {
    	if (connenctDAOImpl == null) {
    		connenctDAOImpl = new ConnectDAOImpl();
    	}
    	return connenctDAOImpl;
    }
    
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    
    public void dbClose(PreparedStatement ps, Connection cn) {
        if (ps != null) try{ps.close();}catch(Exception e){}
        if (cn != null) try{cn.close();}catch(Exception e){}
    }
    
    public void dbClose(ResultSet rs, PreparedStatement ps, Connection cn) {
        if (rs != null) try{rs.close();} catch(Exception e){}
        if (ps != null) try{ps.close();} catch(Exception e){}
        if (cn != null) try{cn.close();} catch(Exception e){}
    }

} //end class
