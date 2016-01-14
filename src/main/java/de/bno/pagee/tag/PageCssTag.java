package de.bno.pagee.tag;

import java.io.IOException;

import javax.servlet.ServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Tag zum einbinden von css Dateien. Funktioniert auch außerhalb vom Head Tag.
 * <br>
 * Beispiel:<br>
 * <code>
 * 	&lt;pge:css href="/resource/css/main.css" &gt;
 * </code>
 */
public class PageCssTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	private String href;
	private Boolean internal;
	private Boolean scriptFallback;

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href.trim();
		if (this.href.startsWith("/")) {
			this.href = this.href.substring(1);
		}
	}

	public boolean isInternal() {
		return (internal != null) ? internal : true;
	}

	public void setInternal(Boolean internal) {
		this.internal = internal;
	}

	public boolean isScriptFallback() {
		return (scriptFallback != null) ? scriptFallback : true;
	}

	public void setScriptFallback(Boolean scriptFallback) {
		this.scriptFallback = scriptFallback;
	}

	private String getContextPath() {
		String ctxPath = pageContext.getServletContext().getContextPath();
		if (ctxPath.endsWith("/")) {
			ctxPath = ctxPath.substring(0, ctxPath.length() - 1);
		}
		return ctxPath;
	}

	private String buildCssLoader(String href, boolean includeFallback) {
		String cssLoader = "";
		cssLoader += "<script type=\"text/javascript\">";
		cssLoader += " var link = document.createElement('link');";
		cssLoader += " link.rel = 'stylesheet';";
		cssLoader += " link.type = 'text/css';";
		cssLoader += " link.href = '" + href + "';";
		cssLoader += " document.head.appendChild(link);";
		cssLoader += "</script>";

		if (includeFallback) {
			cssLoader += "\n";
			cssLoader += "<noscript>";
			cssLoader += buildCssLink(href);
			cssLoader += "</noscript>";
		}

		return cssLoader;
	}

	private String buildCssLink(String href) {
		return "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + href + "\">";
	}

	@Override
	public int doStartTag() throws JspException {

		ServletResponse response = pageContext.getResponse();
		String contextPath = getContextPath();

		String effectiveHref = href;
		if (isInternal()) {
			effectiveHref = contextPath + "/" + href;
		}

		try {
			response.getWriter().append(buildCssLoader(effectiveHref, isScriptFallback()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

}
