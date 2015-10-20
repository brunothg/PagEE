package pagee.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import pagee.util.PageUtils;

/**
 * Basisklasse für alle verfügbaren Seiten
 */
public abstract class AbstractPage implements Page {

    private String path;

    /**
     * @see #getPath()
     * @param path
     *            Relativer Pfad zu der entsprechenden JSP
     */
    public AbstractPage(String path) {
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
