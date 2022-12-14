package com.iu.start.bankbook;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iu.start.util.CommentPager;

@Service
public class BankBookService {
	@Autowired
	private BankBookDAO bankBookDAO;
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager)throws Exception{
//		Long totalCount = bankBookCommentDAO.getCommentListTotalCount(commentPager);
		Long totalCount = bankBookCommentDAO.getCommentListTotalCount(commentPager);
		commentPager.getRowNum();
		commentPager.makePage(totalCount);
		return bankBookCommentDAO.getCommentList(commentPager);
	}
	
	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		return bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
	}
	
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		return bankBookCommentDAO.setCommentDelete(bankBookCommentDTO);
	}
	
	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		return bankBookCommentDAO.setCommentUpdate(bankBookCommentDTO);
	}
	
	public int setDelete(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.setDelete(bankBookDTO);
	};
	
	public int setUpdate(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.setUpdate(bankBookDTO);
	};
	
	// bankbook table에 insert
	// 일련번호는 현재 시간을 밀리세컨드로 바꿔서 입력
	// 판매여부는 1로 시작
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setBankBook(bankBookDTO);
	};
	
	// BankBook에 있는 모든 데이터 조회 최신순 정렬
	public List<BankBookDTO> getList() throws Exception{
		return bankBookDAO.getList();
	};
	
	//판매여부 변경
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setChangeSale(bankBookDTO);
	};
	
	// BOOKNUM의 값으로 조회 
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getDetail(bankBookDTO);
	};

}
