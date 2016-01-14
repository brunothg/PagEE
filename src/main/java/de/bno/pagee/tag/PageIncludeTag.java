package de.bno.pagee.tag;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import de.bno.pagee.model.Page;
import de.bno.pagee.util.PageUtils;

/**
 * Tag zum direkten rendern von {@link Page}s<br>
 * Beispiel:<br>
 * <code>
 * 	&lt;pge:includePage page="${self.navigation}" &gt;
 * </code>
 */
public class PageIncludeTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public int doStartTag() throws JspException {

		ServletRequest request = pageContext.getRequest();
		ServletResponse response = pageContext.getResponse();

		try {
			PageUtils.render(page, request, response, pageContext.getOut());
		} catch (ServletException | IOException e) {
			throw new JspException(e);
		}

		return SKIP_BODY;
	}

}
