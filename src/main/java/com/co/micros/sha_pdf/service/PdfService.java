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

	
	public List<Pdf> findAll() {
		
		List<Pdf> pdfs  = FtpConnet.getFilesFtp();
		
		//pdfs.add(new Pdf("baseFormatoVerSolicitudViatico_110.pdf", "0509489da5767a5675hhhs9884d001351e76362b5be0568c0c3b9c44e662625a"));
		
		return pdfs;
	}
	
	

}
