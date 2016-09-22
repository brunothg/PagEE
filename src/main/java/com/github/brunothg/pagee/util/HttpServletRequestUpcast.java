package com.github.brunothg.pagee.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Cast a {@link ServletResponse} to {@link HttpServletResponse}.
 */
public class HttpServletRequestUpcast implements HttpServletResponse
{

	private ServletResponse servletResponse;
	private Map<String, Object> header = new HashMap<String, Object>();
	private int status;

	public HttpServletRequestUpcast(ServletResponse servletResponse)
	{
		this.servletResponse = servletResponse;
	}

	@Override
	public String getCharacterEncoding()
	{
		return servletResponse.getCharacterEncoding();
	}

	@Override
	public String getContentType()
	{
		return servletResponse.getContentType();
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException
	{
		return servletResponse.getOutputStream();
	}

	@Override
	public PrintWriter getWriter() throws IOException
	{
		return servletResponse.getWriter();
	}

	@Override
	public void setCharacterEncoding(String charset)
	{
		servletResponse.setCharacterEncoding(charset);
	}

	@Override
	public void setContentLength(int len)
	{
		servletResponse.setContentLength(len);
	}

	@Override
	public void setContentType(String type)
	{
		servletResponse.setContentType(type);
	}

	@Override
	public void setBufferSize(int size)
	{
		servletResponse.setBufferSize(size);
	}

	@Override
	public int getBufferSize()
	{
		return servletResponse.getBufferSize();
	}

	@Override
	public void flushBuffer() throws IOException
	{
		servletResponse.flushBuffer();
	}

	@Override
	public void resetBuffer()
	{
		servletResponse.resetBuffer();
	}

	@Override
	public boolean isCommitted()
	{
		return servletResponse.isCommitted();
	}

	@Override
	public void reset()
	{
		servletResponse.reset();
	}

	@Override
	public void setLocale(Locale loc)
	{
		servletResponse.setLocale(loc);
	}

	@Override
	public Locale getLocale()
	{
		return servletResponse.getLocale();
	}

	/**
	 * Not supported. Does nothing.
	 */
	public void addCookie(Cookie cookie)
	{
	}

	/**
	 * Not supported. Always returns false.
	 */
	public boolean containsHeader(String name)
	{
		return header.containsKey(name);
	}

	/**
	 * Not supported. Always returns the given url
	 */
	public String encodeURL(String url)
	{
		return url;
	}

	/**
	 * Not supported. Always returns the given url
	 */
	public String encodeRedirectURL(String url)
	{
		return url;
	}

	/**
	 * Not supported. Always returns the given url
	 */
	public String encodeUrl(String url)
	{
		return url;
	}

	/**
	 * Not supported. Always returns the given url
	 */
	public String encodeRedirectUrl(String url)
	{
		return url;
	}

	/**
	 * Not supported. Does nothing.
	 */
	public void sendError(int sc, String msg) throws IOException
	{
	}

	/**
	 * Not supported. Does nothing.
	 */
	public void sendError(int sc) throws IOException
	{

	}

	/**
	 * Not supported. Does nothing.
	 */
	public void sendRedirect(String location) throws IOException
	{
	}

	/**
	 * Not supported. Does nothing.
	 */
	public void setDateHeader(String name, long date)
	{
		header.put(name, date);
	}

	/**
	 * Not supported. Does nothing.
	 */
	public void addDateHeader(String name, long date)
	{
		header.put(name, date);
	}

	/**
	 * Not supported. Does nothing.
	 */
	public void setHeader(String name, String value)
	{
		header.put(name, value);
	}

	/**
	 * Not supported. Does nothing.
	 */
	public void addHeader(String name, String value)
	{
		header.put(name, value);
	}

	/**
	 * Not supported. Does nothing.
	 */
	public void setIntHeader(String name, int value)
	{
		header.put(name, value);
	}

	/**
	 * Not supported. Does nothing.
	 */
	public void addIntHeader(String name, int value)
	{
		header.put(name, value);
	}

	/**
	 * Not supported. Does nothing.
	 */
	public void setStatus(int sc)
	{
		this.status = sc;
	}

	/**
	 * Not supported. Does nothing.
	 */
	public void setStatus(int sc, String sm)
	{
		setStatus(sc);
	}

	/**
	 * Not supported. Does nothing.
	 */
	public void setContentLengthLong(long len)
	{
	}

	/**
	 * Not supported. Does nothing.
	 */
	public int getStatus()
	{
		return this.status;
	}

	/**
	 * Not supported. Does nothing.
	 */
	public String getHeader(String name)
	{
		return header.get(name).toString();
	}

	/**
	 * Not supported. Does nothing.
	 */
	public Collection<String> getHeaders(String name)
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add(header.get(name).toString());

		return list;
	}

	/**
	 * Not supported. Does nothing.
	 */
	public Collection<String> getHeaderNames()
	{
		return header.keySet();
	}

}
