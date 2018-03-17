package com.co.micros.sha_pdf.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPFile;
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
			
		}
		
		return null;
	}
	
	

}
