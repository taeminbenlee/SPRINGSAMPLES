package bit.com.a.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;
import bit.com.a.dto.PdsDto;
import bit.com.a.dto.PdsParam;
import bit.com.a.service.PdsService;
import bit.com.a.util.PdsUtil;

@Controller
public class PdsController {
	@Autowired
	PdsService service;
	
	@RequestMapping(value = "pdslist.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pdslist(Model model) {
		model.addAttribute("doc_title", "자료실");
		List<PdsDto> list = service.getPdsList();
		model.addAttribute("pdslist", list);
		return "pdslist.tiles";
	}
	
	@RequestMapping(value = "pdswrite.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pdswrite(Model model) {
		model.addAttribute("doc_title", "자료 업로드");
		
		return "pdswrite.tiles";
	}
	@RequestMapping(value = "pdsupload.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pdsupload(PdsDto pdsdto, 
				@RequestParam(value="fileload", required = false)MultipartFile fileload, HttpServletRequest req) {
		// filename 취득
		String filename = fileload.getOriginalFilename();
		pdsdto.setFilename(filename); //원본명
		
		//업로드 경로설정
		//server(tomcat)
		String fupload = req.getServletContext().getRealPath("/upload");
		//directory(folder)
		//String fupload = "d:\\tmp";
		
		System.out.println("fupload:" + fupload);
		//유틸에서 작성한 파일명변경함수를 써서 뉴파일네임을 디티오에 셋 해준다
		String newfilename = PdsUtil.getNewFileName(pdsdto.getFilename());
		pdsdto.setNewfilename(newfilename);
		//파일 객체 담아준다
		File file = new File(fupload + "/" + newfilename);
		try {
			//실제로 업로드 되는 부분
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			
			//디비에 저장
			service.uploadPds(pdsdto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/pdsSearch.do";
	}
	
	@RequestMapping(value="pdsdetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pdsdetail(int seq, Model model) {
		model.addAttribute("doc_title", "상세내용");
		PdsDto dto = service.getDetail(seq);
		model.addAttribute("pdsdetail", dto); 
        return "pdsdetail.tiles";
	}
	
	@RequestMapping(value="fileDownload.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String fileDownload(String newfilename, int seq, HttpServletRequest req, Model model) {
		//경로
		//server
		String fupload = req.getServletContext().getRealPath("/upload");
		//폴더
		//String fupload = "d:\\tmp";
		
		File downloadFile = new File(fupload+ "/" +newfilename);
		System.out.println("downloadFile:" + downloadFile);
		model.addAttribute("downloadFile", downloadFile);
		model.addAttribute("seq", seq);
		
		return "downloadView";
	}
	
	@RequestMapping(value = "pdsDelete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String deletePds(int seq) {
		boolean b = service.deletePds(seq);
		  
		if(b) {
			
			return "redirect:/pdsSearch.do";
		}else {
			
			 return "redirect:/pdsSearch.do";
		}		  
	}
	
	@RequestMapping(value = "pdsUpdate.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String updatePds(int seq, Model model) {
		model.addAttribute("doc_title", "자료실수정");
		PdsDto dto = service.getDetail(seq);
		model.addAttribute("pdsdetail", dto); 
        return "pdsupdate.tiles";
	}
	
	@RequestMapping(value = "pdsupdateAf.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pdsupdateAf(String oldfilename, String oldnewfilename, PdsDto pdsdto, @RequestParam(value="fileload", required = false)MultipartFile fileload, HttpServletRequest req) {
		System.out.println("title:" + pdsdto.getTitle());
		
		
		String filename = fileload.getOriginalFilename();
		
		if(filename == null || filename.equals("")){
			filename = oldfilename;
			String newfilename = oldnewfilename;
			System.out.println("filename= "+filename);
			pdsdto.setFilename(filename);
			pdsdto.setNewfilename(newfilename);
		} else {
			
		
		pdsdto.setFilename(filename); //원본명
		String fupload = req.getServletContext().getRealPath("/upload");
		
		String newfilename = PdsUtil.getNewFileName(pdsdto.getFilename());
		pdsdto.setNewfilename(newfilename);
		
		
		
		File file = new File(fupload + "/" + newfilename);
		try {
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		
		service.updateAf(pdsdto);
		
		
		
		return "redirect:/pdsSearch.do";
	}

	
	
	@RequestMapping(value="pdsSearch.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pdsSearch(PdsParam param, Model model) {
		model.addAttribute("doc_title", "자료실");
		// paging 처리
		System.out.println("search:" + param.getSearch());
		System.out.println("choice:" +param.getChoice());
		System.out.println("page: "+ param.getPage());
		
		int start = param.getPage() * 10 + 1;	// 1 	11
		int end = (param.getPage() + 1) * 10; 	// 10   20
		
		param.setStart(start);
		param.setEnd(end);
		
		List<PdsDto> list = service.getPdslist(param);
		int pdsPage = service.getPdsCount(param);
		//System.out.println("searchedlist:"+list.toString());
		model.addAttribute("pdslist", list);
		model.addAttribute("pageNumber", param.getPage());
		model.addAttribute("pNumber", pdsPage);
		model.addAttribute("search", param.getSearch());
		return "pdslist.tiles";
	}
	
	
}
