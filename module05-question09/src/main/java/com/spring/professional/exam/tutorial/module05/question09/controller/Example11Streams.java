package com.spring.professional.exam.tutorial.module05.question09.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// InputStream and OutputStream example
@Controller
public class Example11Streams {
	
	// curl -X  POST -H "Content-Type: application/octet-stream" -d "{request body content}" localhost:8080/actionK
	@RequestMapping("/actionK")
	@ResponseBody
	public void actionK(InputStream inputStream,OutputStream outputStream) throws IOException
	{
		inputStream.transferTo(outputStream);
		outputStream.write(10);
	}
	
	// curl -X  POST -H "Content-Type: application/octet-stream" -d "{request body content}" localhost:8080/actionK1
		@RequestMapping("/actionK1")
		@ResponseBody
		public void actionK1(Reader reader,Writer writer) throws IOException
		{
			reader.transferTo(writer);
			writer.write(10);
		}
}
