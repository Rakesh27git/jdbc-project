package project1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCrud {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userProject", "root", "root");
		return connection;
	}

	public void signUp(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO USER1 VALUES(?,?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setString(5, user.getAddress());
		preparedStatement.setString(6, user.getApp1());
		preparedStatement.setString(7, user.getApp2());
		preparedStatement.setString(8, user.getApp3());
		preparedStatement.setString(9, user.getApp4());

		preparedStatement.execute();

		connection.close();
		System.out.println("inserted");

	}

	public void updateUser(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("UPDATE USER1 SET NAME=? WHERE ID=?");
		prepareStatement.setInt(2, user.getId());
		prepareStatement.setString(1, user.getName());
		prepareStatement.execute();
		System.out.println("UPDATED");
		connection.close();
	}

	public void deleteUser(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM USER1 WHERE ID=?");

		preparedStatement.setInt(1, user.getId());
		preparedStatement.execute();

		connection.close();
		System.out.println("DELETED");
	}

	public void fetchUser() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER1");
		ResultSet resultset = preparedStatement.executeQuery();

		while (resultset.next()) {
			System.out.println(resultset.getInt(1));
			System.out.println(resultset.getString(2));
			System.out.println(resultset.getString(3));
			System.out.println(resultset.getString(4));
			System.out.println(resultset.getString(5));
			System.out.println("============================");

		}
	}

	public boolean loginUser(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER1 WHERE EMAIL=?");
		preparedStatement.setString(1, user.getEmail());
		ResultSet resultset = preparedStatement.executeQuery();

		String password = null;
		while (resultset.next()) {
			password = resultset.getString("password");
		}
		if (password.equals(user.getPassword())) {
			return true;
		}
		return false;
	}

//		public void fetchPassword(User user) throws ClassNotFoundException, SQLException, IOException
//		{
//			Connection connection=getConnection();
//			PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM USER1 WHERE ID>1");
//			
//			
//			ResultSet resultset= preparedStatement.executeQuery();
//			while(resultset.next())
//			{
//				System.out.println(resultset.getInt(1));
//				System.out.println(resultset.getString(2));
//				System.out.println(resultset.getString(3));
//				System.out.println(resultset.getString(4));
//				System.out.println(resultset.getString(5));
//				System.out.println("============================");
//				
//		}
//		}
	public void getFb(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER1 WHERE EMAIL=? ");
		preparedStatement.setString(1, user.getEmail());
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		System.out.println(resultSet.getString(6));

	}

	public void updateFB(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("UPDATE USER1 SET APP1=? WHERE EMAIL=?");
		prepareStatement.setString(2, user.getEmail());
		prepareStatement.setString(1, user.getApp1());
		prepareStatement.execute();
		connection.close();
		System.out.println("UPDATED");
	}

	public void getInsta(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER1 WHERE EMAIL=? ");
		preparedStatement.setString(1, user.getEmail());
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		System.out.println(resultSet.getString(7));

	}

	public void getSnap(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER1 WHERE EMAIL=? ");
		preparedStatement.setString(1, user.getEmail());
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		System.out.println(resultSet.getString(8));

	}

	public void getTweet(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER1 WHERE EMAIL=? ");
		preparedStatement.setString(1, user.getEmail());
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		System.out.println(resultSet.getString(9));

	}

}
