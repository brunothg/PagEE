package de.bno.pagee.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import de.bno.pagee.util.PageUtils;

/**
 * Basisklasse für alle verfügbaren Seiten
 */
public abstract class AbstractPage implements Page {

	private String path;
	private String title;

	/**
	 * @see #getPath()
	 * @param path
	 *            Relativer Pfad zu der entsprechenden JSP
	 * @param Titel
	 *            der Seite
	 */
	public AbstractPage(String path, String title) {
		this.setTitle(title);
		setPath(path);
	}

	/**
	 * @see #getPath()
	 * @param path
	 *            Relativer Pfad zu der entsprechenden JSP
	 */
	public AbstractPage(String path) {
		this(path, "");
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private void setPath(String path) {
		if (!path.startsWith("/")) {
			path = "/" + path;
		}
		this.path = path;
	}

	@Override
	public String getPath() {
		return this.path;
	}

	@Override
	public void forward(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PageUtils.forward(this, request, response);
	}

	@Override
	public void include(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PageUtils.include(this, request, response);
	}

	@Override
	public String render(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		return PageUtils.render(this, request, response);
	}

}
