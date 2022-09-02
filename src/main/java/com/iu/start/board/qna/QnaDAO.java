package com.iu.start.board.qna;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.board.impl.BoardDAO;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardFileDTO;
import com.iu.start.util.Pager;

@Repository
public class QnaDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.board.qna.QnaDAO.";
	
	public int setReplyAdd(QnaDTO qnaDTO) {
		return sqlSession.insert(NAMESPACE + "setReplyAdd", qnaDTO);
	}
	
	public int setStepUpdate(QnaDTO qnaDTO) {
		return sqlSession.update(NAMESPACE + "setStepUpdate", qnaDTO);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getDetail", boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "setAdd", boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "setUpdate", boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "setDelete", boardDTO);
	}
	
	public int setReply()throws Exception{
		return 0;
	}

	@Override
	public long getCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getCount");
	}

	@Override
	public int setAddFile(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "setAddFile", boardFileDTO);
	}
	
	
	

}
