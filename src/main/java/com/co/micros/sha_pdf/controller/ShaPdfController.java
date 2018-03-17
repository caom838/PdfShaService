package com.co.micros.sha_pdf.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.micros.sha_pdf.Pdf;
import com.co.micros.sha_pdf.service.IPdfService;

@RestController
public class ShaPdfController {

	 @Autowired
	 private IPdfService pdfService;
	
	 
	
	
//	@POST
//	@Path("/generateCSV")
//	@Produces("text/csv")
	 @RequestMapping("/generate")
	public HttpServletResponse generateCsv()
	{
		ArrayList<Pdf> pdfs;
		pdfs = pdfService.findAll();
		
		
	}
	
	
}
