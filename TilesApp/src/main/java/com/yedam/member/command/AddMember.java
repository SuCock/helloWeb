package com.yedam.member.command;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Command;
import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceMybatis;
import com.yedam.member.vo.MemberVO;

public class AddMember implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// service addMember mapper addMember
		// {"retCode": "Success"}, {"retCode": "Fail"}
			String savePath = req.getServletContext().getRealPath("/upload");
			int maxSize = (1024 * 1024 * 10);
			String encoding = "utf-8";

				// 파일업로드 서블릿.
				MultipartRequest multi = new MultipartRequest(req, savePath, maxSize, encoding,
						new DefaultFileRenamePolicy());

				String id = multi.getParameter("id");
				String name = multi.getParameter("name");
				String phone = multi.getParameter("phone");
				String addr = multi.getParameter("addr");
				String fileName = "";

				Enumeration<?> files = multi.getFileNames();
				while (files.hasMoreElements()) {
					String file = (String) files.nextElement();
					System.out.println(file);
					fileName = multi.getFilesystemName(file); // 같은 이미지 파일을 바뀐이름으로 읽어옴.
				}
				// MemberVO 생성.
				MemberVO vo = new MemberVO();
				vo.setMemberPw(id);
				vo.setMemberId(id);
				vo.setMemberName(name);
				vo.setMemberPhone(phone);
				vo.setMemberAddr(addr);
				vo.setResponsibility("user");
				vo.setImage(fileName);
				// 결과값으로 map타입에 저장.
				Map<String, Object> resultMap = new HashMap<>();
				resultMap.put("member", vo);
				
				Gson gson = new GsonBuilder().create(); // 자바의 객체를 json으로 바꿔준다. 등록데이터를 json으로 바꿔줘야한다.
				MemberService service = new MemberServiceMybatis();
				
				
				
				if(service.addMember(vo)>0) {
					resultMap.put("retCode", "Success");
					//return "{\"retCode\": \"Success\"}.json";
				}else {
					resultMap.put("retCode", "Fail");
					//return "{\"retCode\": \"Fail\"}.json";
				}
				return gson.toJson(resultMap)+".json";
			
	}

}
