package book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BookServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			                                            throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		resp.setContentType("text/html; charset=EUC-KR");
			
		HttpSession session = req.getSession();
		ArrayList<BookDTO> list = (ArrayList)session.getAttribute("cart");
		
		String cmd = req.getParameter("command");
		// servlet에 온 곳이 어디인지 알기 위해 hidden으로 command 값을 줘서 보낸다 - Command패턴
		if(cmd.equals("CHK")) {
			Hashtable<String, BookDTO> ht = new Hashtable<>();
			// key 값으로 도서제목으로 삼고, value값으로 DTO를 넣어주겠다.
			for(BookDTO dto : list) {
				if(ht.containsKey(dto.getTitle())) {
					BookDTO cartDTO = ht.get(dto.getTitle()); // 기존의 장바구니에 있는 DTO
					cartDTO.setQty(cartDTO.getQty() + dto.getQty());
				}else {
					ht.put(dto.getTitle(), dto);
				}
			}
			req.setAttribute("check", ht);
			RequestDispatcher view = req.getRequestDispatcher("result.jsp");
			view.forward(req, resp);
		}else {
			if(cmd.equals("ADD")) {
				if(list == null) {
					list = new ArrayList<>();
				}
				BookDTO dto = getBook(req);
				list.add(dto);
			}else if(cmd.equals("DEL")) {
				String idx = req.getParameter("index");
				list.remove(Integer.parseInt(idx));
			}
			session.setAttribute("cart", list);
			RequestDispatcher view = req.getRequestDispatcher("bookShop.jsp");
			view.forward(req, resp);
		}
		
		
	
		
				
		/*
		String data = req.getParameter("book");
		String qty = req.getParameter("qty");
		PrintWriter pw = resp.getWriter();
		pw.println("넘어온 데이터 : " + data + "수량 : " + qty);
		*/
				
	}
	
	public BookDTO getBook(HttpServletRequest req) {
		String data = req.getParameter("book");
		String qty = req.getParameter("qty");
		BookDTO dto = new BookDTO();
		// 데이터를 dto 객체에 넣어주기
		// StringTokenizer, String클래스의 split(), Scanner
		// StringTokenizer 은 유산 클래스 과거의 것 새로 만들때 이런거 안씀 
		
		String[] book = data.split("/"); // /를 기준으로 데이터를 나누어 주세요
		//어린왕자 / 생떽쥐페리 / 15000 => book[0] => 어린왕자, book[1] => 생떽쥐페리, book[2] => 15000
		// 이런식으로 / 기준으로 들어간다
		dto.setTitle(book[0].trim());
		dto.setAuthor(book[1].trim());
		dto.setPrice(Integer.parseInt(book[2].trim()));
		dto.setQty(Integer.parseInt(qty));
		return dto;
		
	}
	
	
	
	

}
