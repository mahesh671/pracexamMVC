package pracexamMVC.DAL;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	Connection con = null;

	public DbConnection() {
		try {
			Class.forName("org.postgresql.Driver");

			this.con = DriverManager.getConnection(
					"jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection returnCon() {
		return this.con;
	}
}
