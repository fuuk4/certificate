package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.StudentDTO;
import dto.TeacherDTO;
import util.SafePass;


public class User {
	public static StudentDTO stuSearch(int id,String pw){
		StudentDTO result = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/certificatedb?useSSL=false",
					"root",
					"jvxstaichi1");
			String sId = String.valueOf(id);
			String hashedPw = SafePass.getSafePass(pw, sId);
			String sql = "SELECT stuId,stuName,Grade,class FROM student where stuId = ? and stuPw = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, hashedPw);

			rs = pstmt.executeQuery();

			rs.next();
			int userid = rs.getInt("stuId");
			String name = rs.getString("stuName");
			int grade = rs.getInt("grade");
			String className = rs.getString("class");
			result = new StudentDTO(userid,name,grade,className);
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (NullPointerException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if( rs != null){
					rs.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return result;
	}

	public static TeacherDTO teachSearch(int id,String pw){
		TeacherDTO result = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/certificatedb?useSSL=false",
					"root",
					"jvxstaichi1");
			String sId = String.valueOf(id);
			String hashedPw = SafePass.getSafePass(pw, sId);
			String sql = "SELECT teachId,teachName,manager FROM teacher where teachId = ? and teachPw = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, hashedPw);

			rs = pstmt.executeQuery();

			rs.next();
			int userid = rs.getInt("teachId");
			String name = rs.getString("teachName");
			boolean manager = rs.getBoolean("manager");
			result = new TeacherDTO(userid,name,manager);
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (NullPointerException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if( rs != null){
					rs.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return result;
	}
}
