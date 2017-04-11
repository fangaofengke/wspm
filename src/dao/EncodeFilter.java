package dao;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter {

	private String encode = null;

	public void destroy() {
		encode = null;

	}

	/**
	 * 对所有页面设置字符集编码
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		response.setCharacterEncoding("utf-8"); // 过滤器中需要添加response的转换编码格式

		if (null == request.getCharacterEncoding()) {

			request.setCharacterEncoding(encode);
		}
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String encode = filterConfig.getInitParameter("encode");

		if (this.encode == null) {

			this.encode = encode; // 查找配置文件中欲设的字符集编码
		}

	}

}
