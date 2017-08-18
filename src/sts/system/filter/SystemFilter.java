package sts.system.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import sts.tools.Tools;

/**
 * Servlet Filter implementation class SystemFilter
 */
public class SystemFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SystemFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String path = ((HttpServletRequest)request).getServletPath();
		if(path.equals("/admin/login/AdminLoginController")){
			chain.doFilter(request, response);
			return;
		}
		if(path.equals("/exam/StudentRegisterController")){
			chain.doFilter(request, response);
			return;
		}
		if(path.contains("ller")&&path.startsWith("/exam")){
			Object o = ((HttpServletRequest)request).getSession().getAttribute("StudentVO");
			if(Tools.objectIsNull(o)){
				return;
			}
		}
		if(path.contains("ller")&&path.startsWith("/admin")){
			Object o = ((HttpServletRequest)request).getSession().getAttribute("adminlogin");
			if(Tools.objectIsNull(o)){
				return;
			}
			
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
