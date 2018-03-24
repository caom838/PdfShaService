package com.co.micros.sha_pdf.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.co.micros.sha_pdf.Pdf;
import com.co.micros.sha_pdf.service.IPdfService;

@RestController
@RequestMapping("v1/pdf")
public class ShaPdfController {

	 @Autowired
	 private IPdfService pdfService;
	
	 
	
	
//	@POST
//	@Path("/generateCSV")
	//@Produces("text/csv")
	@GetMapping(path="/generate",produces="text/csv")
	public void generateCsv(HttpServletResponse response ) throws IOException {	
	
		ArrayList<Pdf> pdfs;
		pdfs = pdfService.findAll();
		
		 // uses the Super CSV API to generate CSV data from the model data
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        String[] header = { "Name", "Sha" };

        csvWriter.writeHeader(header);

        for (Pdf p : pdfs) {
            csvWriter.write(p, header);
        }

        csvWriter.close();
	}
		
}
