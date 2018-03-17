package com.co.micros.sha_pdf.service;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPFile;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;

import com.co.micros.sha_pdf.FtpConnet;
import com.co.micros.sha_pdf.Pdf;

@Service
public class PdfService implements IPdfService {

	
	public ArrayList<Pdf> findAll() {
		
		FTPFile[] files = FtpConnet.getFilesFtp();
		List<Pdf> pdfs = new ArrayList<Pdf>();
		
		
		for(FTPFile f : files)
		{
			InputStream iStream=f.retrieveFileStream(f.getName());	
			File file = File.createTempFile("tmp", null);
			FileUtils.copyInputStreamToFile(iStream, file);
		}
		
		return null;
	}
	
	

}
