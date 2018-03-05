package com.co.micros.sha_pdf;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShaPdfController {

	 @Autowired
	 private IPdfService pdfService;
	
	@RequestMapping("/generate")
	public HttpServletResponse generateCsv()
	{
		Array<Pdf> pdfs;
		pdfs = pdfService.findAll();
		
	}
	
	
}
