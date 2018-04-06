package com.co.micros.sha_pdf.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	 /**
	  * Método que expone servicio para consultar el directorio FTP y devolverá un csv con el nombre del archivo y su SHA-3
	  * @param response
	  * @throws IOException
	  */
	@GetMapping(path="/generate",produces="text/csv")
	public void generateCsv(HttpServletResponse response ) throws IOException {	
	
		List<Pdf> pdfs;
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
