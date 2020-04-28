import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCTestController {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc-mahesh";
		String username = "root";
		String password = "root";
		try {
			// 1.MySQL Driver Registration
			// 2. Driver Loading
			// 3. Get Connection
			// 4. PrepareStatement or create query
			// 5 .Execute query .
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement("update student set last_name='meesala' where id = 1'");
			int noOfRows = ps.executeUpdate();
			System.out.println("inserted data :" + noOfRows);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
