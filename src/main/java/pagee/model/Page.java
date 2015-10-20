package pagee.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import pagee.util.PageUtils;

/**
 * Interface für den Zugriff auf Pages
 */
public interface Page {

    public static final String self = "self";

    /**
     * Gibt den relativen Pfad zu der JSP, der von einem
     * {@link HttpServletRequest#getRequestDispatcher(String)} verarbeitet
     * werden kann.
     * 
     * @return Relativer Pfad zu der entsprechenden JSP
     */
    public String getPath();

    /**
     * Leitet eine Anfrage an diese Seite weiter. Es wird ein Attribut (
     * {@link #self} ) gesetzt, über das die Seite ansprechbar ist.
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @see RequestDispatcher#forward(ServletRequest, ServletResponse)
     * @see PageUtils#forward(AbstractPage, ServletRequest, ServletResponse)
     */
    public void forward(ServletRequest request, ServletResponse response) throws ServletException, IOException;

    /**
     * Inkludiert diese Seite. Es wird ein Attribut ( {@link #self} ) gesetzt,
     * über das die Seite ansprechbar ist.<br>
     * Sollte in JSPs mit bedacht benutzt werden.
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @see RequestDispatcher#include(ServletRequest, ServletResponse)
     * @see PageUtils#include(AbstractPage, ServletRequest, ServletResponse)
     */
    public void include(ServletRequest request, ServletResponse response) throws ServletException, IOException;

    /**
     * Gibt das Ergebnis dieser Seite als String zurück. Es wird ein Attribut (
     * {@link #self} ) gesetzt, über das die Seite ansprechbar ist.<br>
     * In JSPs kann somit ein sicherer Include umgesetzt werden.
     * 
     * @param request
     * @param response
     * @return Das render Ergebnis als String
     * @throws ServletException
     * @throws IOException
     * @see PageUtils#render(AbstractPage, ServletRequest, ServletResponse)
     */
    public String render(ServletRequest request, ServletResponse response) throws ServletException, IOException;
}
