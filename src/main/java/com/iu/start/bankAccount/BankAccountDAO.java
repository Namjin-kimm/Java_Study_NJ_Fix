package com.iu.start.bankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.test.members.BankMembersDTO;
import com.iu.start.util.DBConnector;

@Repository
public class BankAccountDAO implements AccountDAO{
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.bankAccount.BankAccountDAO.";

	@Override
	public int add(BankAccountDTO bankAccountDTO) throws Exception {
//		Connection con = DBConnector.getConnection();
//		
//		String sql = "INSERT INTO BANKACCOUNT VALUES (ACCOUNT_SEQ.NEXTVAL,?,?,SYSDATE)";
//		
//		PreparedStatement st = con.prepareStatement(sql);
//		
//		st.setString(1, bankAccountDTO.getUserName());
//		st.setLong(2, bankAccountDTO.getBookNum());
//		
//		int result = st.executeUpdate();
//		
//		DBConnector.disConnection(st, con);
		
		return sqlSession.insert(NAMESPACE + "add", bankAccountDTO);
	}
	
	public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO)throws Exception{
		
		return sqlSession.selectList(NAMESPACE + "getListByUserName", bankMembersDTO);
	}
	
	

}
