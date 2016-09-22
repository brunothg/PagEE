package com.github.brunothg.pagee.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class WriterResponseRenderer extends HttpServletResponseWrapper {

	private PrintWriter writer;
	private ServletOutputStream stream;

	public WriterResponseRenderer(HttpServletResponse response, Writer out) {
		super(response);
		this.writer = new PrintWriter(out);
		this.stream = new WriterStream(writer);
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		return writer;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return stream;
	}

	private class WriterStream extends ServletOutputStream {

		private PrintWriter writer;

		public WriterStream(PrintWriter writer) {
			this.writer = writer;
		}

		@Override
		public void write(int b) throws IOException {
			writer.write((char) ((byte) b));
		}
	}
}
