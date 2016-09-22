package com.github.brunothg.pagee.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.github.brunothg.pagee.util.PageUtils;

/**
 * Interface for {@link Page} access
 */
public interface Page
{

	/**
	 * Attribute name for the page itself
	 */
	public static final String self = "self";

	/**
	 * Get relative path to a jsp page, which can be processed by an
	 * {@link HttpServletRequest#getRequestDispatcher(String)}.
	 * 
	 * @return Relative path to corresponding jsp.
	 * 
	 */
	public String getPath();

	/**
	 * Get the page's title
	 * 
	 * @return The page's title
	 */
	public String getTitle();

	/**
	 * Redirect a request to this page. The attribute ( {@link #self} ) is set, so that the page
	 * itself is accessable.
	 * 
	 * @param request The {@link ServletRequest}
	 * @param response The {@link ServletResponse}
	 * @throws ServletException
	 * @throws IOException
	 * @see RequestDispatcher#forward(ServletRequest, ServletResponse)
	 * @see PageUtils#forward(Page, ServletRequest, ServletResponse)
	 */
	public void forward(ServletRequest request, ServletResponse response) throws ServletException, IOException;

	/**
	 * Includes this page. The attribute ( {@link #self} ) is set, so that the page itself is
	 * accessible. <br>
	 * Be careful when using this in a jsp.
	 * 
	 * @param request The {@link ServletRequest}
	 * @param response The {@link ServletResponse}
	 * @throws ServletException
	 * @throws IOException
	 * @see RequestDispatcher#include(ServletRequest, ServletResponse)
	 * @see PageUtils#include(Page, ServletRequest, ServletResponse)
	 */
	public void include(ServletRequest request, ServletResponse response) throws ServletException, IOException;

	/**
	 * Get the rendering result of this page as a {@link String}. The attribute ( {@link #self} ) is
	 * set, so that the page itself is accessable. <br>
	 * For save include in a jsp.
	 * 
	 * @param request
	 * @param response
	 * @return Das render Ergebnis als String
	 * @throws ServletException
	 * @throws IOException
	 * @see PageUtils#render(Page, ServletRequest, ServletResponse)
	 */
	public String render(ServletRequest request, ServletResponse response) throws ServletException, IOException;
}
