package com.iu.start.board.notice;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardFileDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.FileManager;
import com.iu.start.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeDAO noticeDAO;
//	@Autowired
//	private ServletContext servletContext;
	
	@Autowired
	private FileManager fileManager;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		Long totalCount = noticeDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
//		System.out.println("Service Page : " + page);
//		Long perPage = 10L; //한 페이지에 출력할 목록의 갯수
////		page		startRow		lastRow
////		1			1				10
////		2			11				20
////		3			21				30
//		
//		Long startRow = (page - 1)*perPage + 1;
//		Long lastRow = page*perPage;
//		
//		System.out.println("StartRow : " + startRow);
//		System.out.println("LastRow : " + lastRow);
//		Map<String, Long> map = new HashMap<String, Long>();
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
//		
////		JSP에 페이지번호를 출력 1 - ?
////		 1. 글의 총 갯수
//		Long totalCount = noticeDAO.getCount();
//		
////		 2. 글의 총 갯수를 이용해서 총 페이지 수 구하기
//		 Long totalPage = totalCount/perPage;
//		if(totalCount%perPage != 0) {
////			totalPage += 1;
//			totalPage++;
//		}
//		
////		3. 글의 총 페이지 수로 totalBlock 갯수 구하기
////		Block	 : 
////		perBlock : 한 페이지에 출력할 번호의 수
//		
//		long perBlock = 5L;
//		long totalBlock = totalPage/perBlock;
//		if(totalPage%perBlock != 0) {
//			totalBlock++;
//		}
//		
////		4. page로 현재 Block 번호 찾기
////		page		curBlock
////		1			1
////		2			1
////		3			1
////		4			1
////		5			1
////		6			2
////		7			2
//		
//		Long curBlock = page/perBlock;
//		if(page%perBlock !=0) {
//			curBlock++;
//		}
//		
////		5. curBlock으로 시작번호와 끝번호 알아 오기
////		curBlock	startNum	latNum
////		1			1			5
////		2			6			10
////		3			11			15
//		
//		Long startNum = (curBlock - 1)*perBlock + 1;
//		Long lastNum = curBlock*perBlock; 
//		
//		System.out.println("TotalPage : " + totalPage);
//		System.out.println("TotalBlock : " + totalBlock);
//		System.out.println("curBlock : " + curBlock);
//		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files, ServletContext servletContext) throws Exception {
		
		int result = noticeDAO.setAdd(boardDTO);
		String path = "resources/upload/notice";
		for(MultipartFile multipartFile: files) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fileName = fileManager.saveFile(servletContext, path, multipartFile);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			noticeDAO.setAddFile(boardFileDTO);
	}
		return result;
}
	
//	오버로딩
//	public int setAdd(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
//			
//			int result = noticeDAO.setAdd(boardDTO);
//			//먼저 notice가 등록이 되어야 파일이 notice table의 num을 참조할 수 있다
//			//사실 여기 boardDTO는 처음에는 num이 없지만
////			<selectKey keyProperty="num" order="BEFORE" resultType="Long">
////			SELECT BOARD_SEQ.NEXTVAL FROM DUAL
////			</selectKey>
////			이 코드를 통해 시퀀스에서 하나 뽑은 값을 boardDTO의 num에 저장한다.
////			그럼 매개면수로 받는 저 boardDTO의 num에 그 시퀀스 값이 넘어올 것이다
////			String realpath = servletContext.getRealPath("/resources/upload/notice");
////			
////			
////			for(int i = 0; i < files.length; i++) {
////				File file = new File(realpath);
////				if(files[i].isEmpty()) {
////	
////					if(file.exists()) {
////						file.mkdirs();
////					}
////					//file = new File(realpath)
////					
////					//저장하는 코드
////					String fileName = UUID.randomUUID().toString();
////					fileName = fileName + "_" + files[i].getOriginalFilename();
////					
////					file = new File(file, fileName);
////					files[i].transferTo(file);
//					
//					BoardFileDTO boardFileDTO = new BoardFileDTO();
//					boardFileDTO.setFileName(fileName);
//					boardFileDTO.setOriName(files[i].getOriginalFilename());
//					
//					return 0; 
//				}		
	
	

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}
	
	public int setReply(NoticeDTO noticeDTO)throws Exception{
		BoardDTO boardDTO = noticeDAO.getDetail(noticeDTO);
		NoticeDTO parent = (NoticeDTO)boardDTO;
		noticeDAO.setStepUpdate(parent);
		
		System.out.println(parent.getRef());
		
		noticeDTO.setRef(parent.getRef());
		noticeDTO.setStep(parent.getStep() + 1);
		noticeDTO.setDepth(parent.getDepth() + 1);
		
		int result = noticeDAO.setReplyAdd(noticeDTO);
		return result;
	}
	

	
}



