package de.bno.pagee.util;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import de.bno.pagee.model.Page;

public class PageUtils {

	/**
	 * Leitet eine Anfrage an eine Seite weiter.<br>
	 * Es steht ein Attribute ( {@link Page#self} ) zum Zugriff auf die eigene
	 * {@link Page} zur verfügung.
	 * 
	 * @param page
	 *            Die {@link Page}, die als Ziel des Forwards dienen soll
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @see RequestDispatcher#forward(ServletRequest, ServletResponse)
	 */
	public static void forward(Page page, ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		request.setAttribute(Page.self, page);

		RequestDispatcher dispatcher = request.getRequestDispatcher(page.getPath());
		dispatcher.forward(request, response);
	}

	/**
	 * Inkludiert eine Seite.<br>
	 * Es steht ein Attribute ( {@link Page#self} ) zum Zugriff auf die eigene
	 * {@link Page} zur verfügung.
	 * 
	 * @param page
	 *            Die {@link Page}, die als Ziel des Includes dienen soll
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @see RequestDispatcher#include(ServletRequest, ServletResponse)
	 */
	public static void include(Page page, ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		Object parentSelf = request.getAttribute(Page.self);

		request.setAttribute(Page.self, page);

		RequestDispatcher dispatcher = request.getRequestDispatcher(page.getPath());
		dispatcher.include(request, response);

		// Stelle das self Attribut für den Parent wieder her
		request.setAttribute(Page.self, parentSelf);
	}

	/**
	 * Gibt das Ergebnis eines Includes als String zurück.
	 * 
	 * @param page
	 *            Die zu rendernde {@link Page}
	 * @param request
	 * @param response
	 * @return Gerenderte Seite
	 * @throws IOException
	 * @throws ServletException
	 */
	public static String render(Page page, ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		if (!(response instanceof HttpServletResponse)) {
			response = new HttpServletRequestUpcast(response);
		}

		StringResponseRenderer renderer = new StringResponseRenderer((HttpServletResponse) response);
		include(page, request, renderer);

		return renderer.getRenderResult();
	}

	/**
	 * Benutzt einen Writer um direkt zu schreiben
	 * 
	 * @see #render(Page, ServletRequest, ServletResponse)
	 * @param page
	 *            Die zu rendernde {@link Page}
	 * @param request
	 * @param response
	 * @param out
	 *            Der Writer, der zum schreiben genutt werden soll
	 */
	public static void render(Page page, ServletRequest request, ServletResponse response, Writer out)
			throws ServletException, IOException {
		if (!(response instanceof HttpServletResponse)) {
			response = new HttpServletRequestUpcast(response);
		}

		WriterResponseRenderer renderer = new WriterResponseRenderer((HttpServletResponse) response, out);
		include(page, request, renderer);
	}

}
