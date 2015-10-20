package pagee.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class StringResponseRenderer extends HttpServletResponseWrapper {

    private final PrintWriter writer = new PrintWriter(new RenderWriter());
    private final ServletOutputStream stream = new RenderOutputStream();

    private final StringBuilder renderResult = new StringBuilder();

    public StringResponseRenderer(HttpServletResponse response) {
	super(response);
    }

    @Override
    public PrintWriter getWriter() {
	return writer;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
	return stream;
    }

    public String getRenderResult() {
	return renderResult.toString();
    }

    private class RenderWriter extends Writer {

	@Override
	public void close() throws IOException {
	}

	@Override
	public void flush() throws IOException {
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
	    renderResult.append(cbuf, off, len);
	}

    }

    private class RenderOutputStream extends ServletOutputStream {

	@Override
	public void write(int b) throws IOException {
	    renderResult.append((char) ((byte) b));
	}

    }
}
