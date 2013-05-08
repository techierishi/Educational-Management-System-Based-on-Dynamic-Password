package cn.edu.hustwb.actions;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter  extends HttpServlet   implements Filter{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse res=(HttpServletResponse) response;
		HttpSession session = req.getSession();
		
        Object user = session.getAttribute("user");;
        if(user==null||"".equals(user)){
            res.sendRedirect(req.getContextPath() + "/login2.jsp");
        }else
        chain.doFilter(request, response);        
		res.setHeader("Cache-Control", "no-store");
		res.setDateHeader("Expires", 0);
		res.setHeader("Pragma", "no-cache");
		res.flushBuffer();
    }
    public void init(FilterConfig arg0) throws ServletException {
        
    }

}
