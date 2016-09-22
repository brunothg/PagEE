package com.github.brunothg.pagee.util;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.github.brunothg.pagee.model.Page;

public class PageUtils
{

	/**
	 * Redirect a request to another page.<br>
	 * An attribute ( {@link Page#self} ) is provided for accessing the own {@link Page}.
	 * 
	 * @param page The target {@link Page}
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @see RequestDispatcher#forward(ServletRequest, ServletResponse)
	 */
	public static void forward(Page page, ServletRequest request, ServletResponse response)
		throws ServletException, IOException
	{
		request.setAttribute(Page.self, page);

		RequestDispatcher dispatcher = request.getRequestDispatcher(page.getPath());
		dispatcher.forward(request, response);
	}

	/**
	 * Include a page.<br>
	 * An attribute ( {@link Page#self} ) is provided for accessing the own {@link Page}.
	 * 
	 * @param page The target {@link Page}
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @see RequestDispatcher#include(ServletRequest, ServletResponse)
	 */
	public static void include(Page page, ServletRequest request, ServletResponse response)
		throws ServletException, IOException
	{
		Object parentSelf = request.getAttribute(Page.self);

		request.setAttribute(Page.self, page);

		RequestDispatcher dispatcher = request.getRequestDispatcher(page.getPath());
		dispatcher.include(request, response);

		// Recreate self attribute for parent
		request.setAttribute(Page.self, parentSelf);
	}

	/**
	 * Get the result of an include
	 * 
	 * @param page The {@link Page} for rendering
	 * @param request
	 * @param response
	 * @return Rendered page
	 * @throws IOException
	 * @throws ServletException
	 */
	public static String render(Page page, ServletRequest request, ServletResponse response)
		throws ServletException, IOException
	{
		if (!(response instanceof HttpServletResponse))
		{
			response = new HttpServletRequestUpcast(response);
		}

		StringResponseRenderer renderer = new StringResponseRenderer((HttpServletResponse) response);
		include(page, request, renderer);

		return renderer.getRenderResult();
	}

	/**
	 * Uses a writer for direct writing
	 * 
	 * @see #render(Page, ServletRequest, ServletResponse)
	 * @param page The {@link Page} for rendering
	 * @param request
	 * @param response
	 * @param out The writer used for output
	 */
	public static void render(Page page, ServletRequest request, ServletResponse response, Writer out)
		throws ServletException, IOException
	{
		if (!(response instanceof HttpServletResponse))
		{
			response = new HttpServletRequestUpcast(response);
		}

		WriterResponseRenderer renderer = new WriterResponseRenderer((HttpServletResponse) response, out);
		include(page, request, renderer);
	}

}
