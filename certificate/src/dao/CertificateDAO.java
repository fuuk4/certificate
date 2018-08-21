package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.CertificateDTO;

public class CertificateDAO {
	public static void addCertificate(String val){
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs = 0;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/certificatedb?useSSL=false",
					"root",
					"jvxstaichi1");
			String sql = "insert into certificate(certificateName) values(?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, val);
			rs = pstmt.executeUpdate();
		}catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		} finally {
			if( rs == 0){
				throw new NullPointerException("おかしいよ？");
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
	}

	public static void addCertificateVal(CertificateDTO addVal){
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs = 0;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/certificatedb?useSSL=false",
					"root",
					"jvxstaichi1");
			String sql = "INSERT INTO status(stuId,certificateId,testDay,acceptance) VALUES (?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, addVal.getId());
			pstmt.setInt(2, addVal.getCertiId());
			pstmt.setDate(3, addVal.getDate());
			pstmt.setBoolean(4, addVal.isStats());
			rs = pstmt.executeUpdate();
		}catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		} finally {
			if( rs == 0){
				throw new NullPointerException("おかしいよ？");
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
	}

	public static ArrayList<CertificateDTO> getCertificate(){
		ArrayList<CertificateDTO> result = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/certificatedb?useSSL=false",
					"root",
					"jvxstaichi1");
			String sql = "SELECT * FROM certificate";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				result.add(new CertificateDTO(rs.getInt("certificateId"), rs.getString("certificateName")));
			}

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

	public static ArrayList<CertificateDTO> getAllCertificateVal(){
		ArrayList<CertificateDTO> result = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/certificatedb?useSSL=false",
					"root",
					"jvxstaichi1");
			String sql = "SELECT s.stuName, c.certificateName, testDay,acceptance FROM "
					+ "status st,certificate c, student s "
					+ "where s.stuId = st.stuId and c.certificateId = st.certificateId";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String name = rs.getString("stuName");
				String certifiName = rs.getString("certificateName");
				Date date = rs.getDate("testDay");
				Boolean stats = rs.getBoolean("acceptance");

				result.add(new CertificateDTO(certifiName, name, date, stats));
			}

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
