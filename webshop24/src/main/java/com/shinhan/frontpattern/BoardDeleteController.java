package com.shinhan.frontpattern;
import java.util.Map;
import com.shinhan.model.BoardService;
public class BoardDeleteController implements CommonControllerInterface{
	@Override
	public String execute(Map<String, Object> dataMap) {
		int bno = (Integer)dataMap.get("bno");
		System.out.println(bno);
		int result = new BoardService().deleteBoard(bno);
		System.out.println(result + "건 삭제됨");
		return "redirect:selectAll.do";
	}
}