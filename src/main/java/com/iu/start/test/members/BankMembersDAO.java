package com.iu.start.test.members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public class BankMembersDAO implements MembersDAO{

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.test.members.BankMembersDAO.";
	
	public int setAddFile(BankMembersFileDTO bankMembersFileDTO)throws Exception {
		return sqlSession.insert(NAMESPACE + "setAddFile", bankMembersFileDTO);
	}
	
	@Override
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
		bankMembersDTO = sqlSession.selectOne(NAMESPACE + "getMyPage", bankMembersDTO);
		return bankMembersDTO;
	}
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"getLogin", bankMembersDTO);
	}

	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
//		//1. DB연결
//		Connection con = DBConnector.getConnection();
//		//2. SQL문 생성
//		String sql = "INSERT INTO MEMBERS VALUES (?, ?, ?, ?, ?)";
//		//3. 쿼리문 미리 보내기
//		PreparedStatement st = con.prepareStatement(sql);
//		//4. ?값 세팅
//		st.setString(1, bankMembersDTO.getUsername());
//		st.setString(2, bankMembersDTO.getPassword());
//		st.setString(3, bankMembersDTO.getName());
//		st.setString(4, bankMembersDTO.getEmail());
//		st.setString(5, bankMembersDTO.getPhone());
//		//5. 최종 전송 후 결과 처리
//		int result = st.executeUpdate();
//		//6. 자원 해제
//		st.close();
//		con.close();
		
		return sqlSession.insert(NAMESPACE+"setJoin", bankMembersDTO);
	}

	@Override
	public List<BankMembersDTO> getSearchById(String search) throws Exception {
//		ArrayList<BankMembersDTO> ar = new ArrayList<BankMembersDTO>();
//		
//		//1. DB연결
//		Connection con = DBConnector.getConnection();
//		//2. 쿼리문 작성
//		String sql = "SELECT * FROM MEMBERS WHERE USERNAME LIKE ? ORDER BY USERNAME ASC";
//		//3. 쿼리문 미리 보내기
//		PreparedStatement st = con.prepareStatement(sql);
//		//4. ? 값 세팅
//		st.setString(1, "%" + search + "%");
//		//5. 최종 전송 후 결과 처리
//		ResultSet rs = st.executeQuery();
//		while(rs.next()) {
//			BankMembersDTO bankMembersDTO = new BankMembersDTO();
//			bankMembersDTO.setUsername(rs.getString(1));
//			bankMembersDTO.setPassword(rs.getString(2));
//			bankMembersDTO.setName(rs.getString(3));
//			bankMembersDTO.setEmail(rs.getString(4));
//			bankMembersDTO.setPhone(rs.getString(5));
//			ar.add(bankMembersDTO);
//		}
//		6. 자원 해제
//		rs.close();
//		st.close();
//		con.close();
//		DBConnector.disConnection(rs, st, con);
		
		return sqlSession.selectList(NAMESPACE+"getSearchById", search);
	}

	

}
