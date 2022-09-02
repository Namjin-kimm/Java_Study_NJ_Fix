package com.iu.start.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.util.DBConnector;

@Repository
public class BankBookDAO implements BookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.bankbook.BankBookDAO.";
	
	@Override
	public int setDelete(BankBookDTO bankBookDTO)throws Exception{
//		Connection con = DBConnector.getConnection();
//		String sql = "DELETE BANKBOOK WHERE BOOKNUM = ?";
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setLong(1, bankBookDTO.getBookNum());
//		int result = st.executeUpdate();
//		DBConnector.disConnection(st, con);
		
		return sqlSession.delete(NAMESPACE + "setDelete" , bankBookDTO);
	}
	
	@Override
	public int setUpdate(BankBookDTO bankBookDTO)throws Exception{
//		Connection con = DBConnector.getConnection();
//		String sql = "UPDATE BANKBOOK SET BOOKNAME = ?,BOOKRATE = ? WHERE BOOKNUM = ?";
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, bankBookDTO.getBookName());
//		st.setDouble(2, bankBookDTO.getBookRate());
//		st.setLong(3, bankBookDTO.getBookNum());
//		int result = st.executeUpdate();
//		
//		DBConnector.disConnection(st, con);
		return sqlSession.update(NAMESPACE + "setUpdate", bankBookDTO);
	}

	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
//		Calendar ca = Calendar.getInstance();	
//		Connection con = DBConnector.getConnection();
//		String sql = "INSERT INTO BANKBOOK VALUES (?, ?, ?, 1)";
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setLong(1, ca.getTimeInMillis());
//		st.setString(2, bankBookDTO.getBookName());
//		st.setDouble(3, bankBookDTO.getBookRate());
//		int result = st.executeUpdate();
//		DBConnector.disConnection(st, con);
//		
		return sqlSession.update(NAMESPACE + "setBankBook", bankBookDTO);
	}

	@Override
	public List<BankBookDTO> getList() throws Exception {
		// TODO Auto-generated method stub
//		Connection con = DBConnector.getConnection();
//		ArrayList<BankBookDTO> arr = new ArrayList<BankBookDTO>();
//		String sql = "SELECT * FROM BANKBOOK ORDER BY BOOKNUM DESC";
//		PreparedStatement st = con.prepareStatement(sql);
//		ResultSet rs = st.executeQuery();
//		while(rs.next()) {
//			BankBookDTO bankBookDTO = new BankBookDTO();
//			bankBookDTO.setBookNum(rs.getLong("BOOKNUM"));
//			bankBookDTO.setBookName(rs.getString("BOOKNAME"));
//			bankBookDTO.setBookRate(rs.getDouble("BOOKRATE"));
//			bankBookDTO.setBookSale(rs.getInt("BOOKSALE"));
//			
//			arr.add(bankBookDTO);
//		}
//		DBConnector.disConnection(rs, st, con);
		
		return sqlSession.selectList(NAMESPACE + "getList");
	}

	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
		int sale=0;
		Connection con = DBConnector.getConnection();
		String sql2 = "SELECT BOOKSALE FROM BANKBOOK WHERE BOOKNUM = ?";
		PreparedStatement st2 = con.prepareStatement(sql2);
		st2.setLong(1, bankBookDTO.getBookNum());
		ResultSet rs = st2.executeQuery();
		if(rs.next()) {
			sale = rs.getInt("BOOKSALE");
		}
		rs.close();
		st2.close();
		
		if(sale == 1) {
			sale = 0;
		} else sale=1;
		
		String sql = "UPDATE BANKBOOK SET BOOKSALE = ? WHERE BOOKNUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, sale);
		st.setLong(2, bankBookDTO.getBookNum());
		int result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
		return result;
	}

	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		// TODO Auto-generated method stub
//		Connection con = DBConnector.getConnection();
//		
//		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUM = ?";
//		
//		PreparedStatement st = con.prepareStatement(sql);
//
//		st.setLong(1, bankBookDTO.getBookNum());
//		
//		ResultSet rs = st.executeQuery();
//		
//		BankBookDTO dto = new BankBookDTO();
//		if(rs.next()) {
//			dto.setBookNum(rs.getLong("BOOKNUM"));
//			dto.setBookName(rs.getString("BOOKNAME"));
//			dto.setBookRate(rs.getDouble("BOOKRATE"));
//			dto.setBookSale(rs.getInt("BOOKSALE"));
//		}
//		DBConnector.disConnection(rs, st, con);
		return sqlSession.selectOne(NAMESPACE + "getDetail", bankBookDTO);
	}

}
