package com.iu.start.test.members;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankAccount.BankAccountDAO;
import com.iu.start.bankAccount.BankAccountDTO;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	@Autowired
	private ServletContext servletContext;
//	@Autowired
//	private BankAccountDAO bankAccountDAO;
//	
//	public ModelAndView getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
//		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
//		map.put("list", ar);
//		map.put("dto", bankMembersDTO);
//		mv.addObject("map", map);
//		return mv;
//	}
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}
	
	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo, ServletContext servletContext)throws Exception{
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		//1. HDD에 파일을 저장
		// 파일 저장시에 경로는 OS(운영체제)의 기준으로 설정
		// 1) 파일저장 위치
		// /resources/upload/member
		
		// 2) 저장할 폴더의 실제경로 반환(OS 기준)
		String realpath = servletContext.getRealPath("resources/upload/member");
		System.out.println("RealPath : " + realpath);
		
		// 3) 저장할 폴더의 정보를 가지는 자바 객체 생성
		File file = new File(realpath);
		System.out.println(file.exists());
		
		// *** File 첨부를 안 한 상태로 회원가입을 했을 때
		
//		if(photo.getSize() != 0) {
//			
//		}
		
		if(!photo.isEmpty()) {
			System.out.println("empty");
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		// 4) 중복되지 않는 파일명 생성
		// 		-- 시간 or java api,...
		String fileName = UUID.randomUUID().toString();
		fileName = fileName + "_" +photo.getOriginalFilename();
		System.out.println(fileName);
		
		Calendar ca = Calendar.getInstance();
		Long time = ca.getTimeInMillis();
		System.out.println(time);
		
		// 5) HDD에 파일 저장
		//어느 폴더에 어떤 이름으로 저장할 File 객체를 생성
		file = new File(file, fileName);
		// (1) MultipartFile 클래스의 transferTo 메서드 사용
		photo.transferTo(file);
		
		// (2) FileCopyUtils 클래스의 copy 메서드 사용
		
		
		//2. 저장된 파일정보를 DB에 저장
		BankMembersFileDTO bankMembersFileDTO = new BankMembersFileDTO();
		bankMembersFileDTO.setFileName(fileName);
		bankMembersFileDTO.setOriName(photo.getOriginalFilename());
		bankMembersFileDTO.setUserName(bankMembersDTO.getUsername());
		bankMembersDAO.setAddFile(bankMembersFileDTO);
		
		
		
		
	} //isempty 끝
		
		
		return result;
	};
	
	public List<BankMembersDTO> getSearchById(String search) throws Exception{
		return bankMembersDAO.getSearchById(search);
	};

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getLogin(bankMembersDTO);
	};

}
