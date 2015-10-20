package pagee.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Lässt alle Methoden, die nicht über ein {@link ServletResponse} erreichbar
 * sind fallen.
 */
public class HttpServletRequestUpcast implements HttpServletResponse {

    private ServletResponse servletResponse;
    private Set<String> header = new HashSet<String>();

    public HttpServletRequestUpcast(ServletResponse servletResponse) {
	this.servletResponse = servletResponse;
    }

    @Override
    public String getCharacterEncoding() {
	return servletResponse.getCharacterEncoding();
    }

    @Override
    public String getContentType() {
	return servletResponse.getContentType();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
	return servletResponse.getOutputStream();
    }

    @Override
    public PrintWriter getWriter() throws IOException {
	return servletResponse.getWriter();
    }

    @Override
    public void setCharacterEncoding(String charset) {
	servletResponse.setCharacterEncoding(charset);
    }

    @Override
    public void setContentLength(int len) {
	servletResponse.setContentLength(len);
    }

    @Override
    public void setContentType(String type) {
	servletResponse.setContentType(type);
    }

    @Override
    public void setBufferSize(int size) {
	servletResponse.setBufferSize(size);
    }

    @Override
    public int getBufferSize() {
	return servletResponse.getBufferSize();
    }

    @Override
    public void flushBuffer() throws IOException {
	servletResponse.flushBuffer();
    }

    @Override
    public void resetBuffer() {
	servletResponse.resetBuffer();
    }

    @Override
    public boolean isCommitted() {
	return servletResponse.isCommitted();
    }

    @Override
    public void reset() {
	servletResponse.reset();
    }

    @Override
    public void setLocale(Locale loc) {
	servletResponse.setLocale(loc);
    }

    @Override
    public Locale getLocale() {
	return servletResponse.getLocale();
    }

    /**
     * Not supported. Does nothing.
     */
    public void addCookie(Cookie cookie) {
    }

    /**
     * Not supported. Always returns false.
     */
    public boolean containsHeader(String name) {
	return header.contains(name);
    }

    /**
     * Not supported. Always returns the given url
     */
    public String encodeURL(String url) {
	return url;
    }

    /**
     * Not supported. Always returns the given url
     */
    public String encodeRedirectURL(String url) {
	return url;
    }

    /**
     * Not supported. Always returns the given url
     */
    public String encodeUrl(String url) {
	return url;
    }

    /**
     * Not supported. Always returns the given url
     */
    public String encodeRedirectUrl(String url) {
	return url;
    }

    /**
     * Not supported. Does nothing.
     */
    public void sendError(int sc, String msg) throws IOException {
    }

    /**
     * Not supported. Does nothing.
     */
    public void sendError(int sc) throws IOException {

    }

    /**
     * Not supported. Does nothing.
     */
    public void sendRedirect(String location) throws IOException {
    }

    /**
     * Not supported. Does nothing.
     */
    public void setDateHeader(String name, long date) {
	header.add(name);
    }

    /**
     * Not supported. Does nothing.
     */
    public void addDateHeader(String name, long date) {
	header.add(name);
    }

    /**
     * Not supported. Does nothing.
     */
    public void setHeader(String name, String value) {
	header.add(name);
    }

    /**
     * Not supported. Does nothing.
     */
    public void addHeader(String name, String value) {
	header.add(name);
    }

    /**
     * Not supported. Does nothing.
     */
    public void setIntHeader(String name, int value) {
	header.add(name);
    }

    /**
     * Not supported. Does nothing.
     */
    public void addIntHeader(String name, int value) {
	header.add(name);
    }

    /**
     * Not supported. Does nothing.
     */
    public void setStatus(int sc) {
    }

    /**
     * Not supported. Does nothing.
     */
    public void setStatus(int sc, String sm) {
    }

}
