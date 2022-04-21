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
		// servlet�� �� ���� ������� �˱� ���� hidden���� command ���� �༭ ������ - Command����
		if(cmd.equals("CHK")) {
			Hashtable<String, BookDTO> ht = new Hashtable<>();
			// key ������ ������������ ���, value������ DTO�� �־��ְڴ�.
			for(BookDTO dto : list) {
				if(ht.containsKey(dto.getTitle())) {
					BookDTO cartDTO = ht.get(dto.getTitle()); // ������ ��ٱ��Ͽ� �ִ� DTO
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
		pw.println("�Ѿ�� ������ : " + data + "���� : " + qty);
		*/
				
	}
	
	public BookDTO getBook(HttpServletRequest req) {
		String data = req.getParameter("book");
		String qty = req.getParameter("qty");
		BookDTO dto = new BookDTO();
		// �����͸� dto ��ü�� �־��ֱ�
		// StringTokenizer, StringŬ������ split(), Scanner
		// StringTokenizer �� ���� Ŭ���� ������ �� ���� ���鶧 �̷��� �Ⱦ� 
		
		String[] book = data.split("/"); // /�� �������� �����͸� ������ �ּ���
		//����� / �������丮 / 15000 => book[0] => �����, book[1] => �������丮, book[2] => 15000
		// �̷������� / �������� ����
		dto.setTitle(book[0].trim());
		dto.setAuthor(book[1].trim());
		dto.setPrice(Integer.parseInt(book[2].trim()));
		dto.setQty(Integer.parseInt(qty));
		return dto;
		
	}
	
	
	
	

}
