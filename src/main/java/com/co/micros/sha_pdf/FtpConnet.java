package com.co.micros.sha_pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.Properties;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FtpConnet {

	private static String hostName;
	private static String user;
	private static String pass;
	
	 public static void putFiles() {
	        FTPClient client = new FTPClient();
	        try{
	            client.connect(InetAddress.getByName("staging.Carnicerialazaro1.arnetbiz.com.ar"),21);
	            boolean login = client.login("user", "password");
	            if (login){
	                client.changeWorkingDirectory("/web/staging");//Cambiar directorio de trabajo
	                System.out.println("Iniciando sesión Satisfactoriamente");
	                int replay = client.getReplyCode();
	                if (FTPReply.isPositiveCompletion(replay)){
	                    File file = new File("D:\\Nuevo.txt");
	                    FileInputStream input = new FileInputStream(file);
	                    client.setFileType(FTP.BINARY_FILE_TYPE);
	                    client.enterLocalActiveMode();
	                    System.out.println("Subió satisfactoriamente el archivo");
	                    if (!client.storeFile(file.getName(),input)){
	                        System.out.println("Subida fallida!");
	                    }
	                    input.close();
	                }
	// Cuando cierras sesión el método logout regresa "true".
	                boolean logout = client.logout();
	                if (logout){
	                    System.out.println("Salir del servidor FTP");
	                }
	            }else{
	                System.out.println("Falló inciar sesión");
	            }
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
	        finally{
	            try{
	                client.disconnect();
	            }
	            catch (IOException e){
	                e.printStackTrace();
	            }
	        }
	    }
	 
	 public static FTPFile[] getFilesFtp() {
	        
		 FTPFile[] filesInFtp = new FTPFile[0];
		 
		 try {

	        	readProperties();
	        	
	            //new ftp client
	            FTPClient ftp = new FTPClient();
	            //try to connect
	            ftp.connect(hostName);
	            //login to server
	            if (!ftp.login(user, pass)) {
	                ftp.logout();
	            }
	            int reply = ftp.getReplyCode();
	            //FTPReply stores a set of constants for FTP reply codes. 
	            if (!FTPReply.isPositiveCompletion(reply)) {
	                ftp.disconnect();
	            }

	            //enter passive mode
	            ftp.enterLocalPassiveMode();
	            //get system name
	            System.out.println("Remote system is " + ftp.getSystemType());
	            //change current directory
	            ftp.changeWorkingDirectory("/");
	            System.out.println("Current directory is " + ftp.printWorkingDirectory());

	            //get list of filenames
	          filesInFtp = ftp.listFiles();

	            if (filesInFtp != null && filesInFtp.length > 0) {
	                //loop thru files
	                for (FTPFile file : filesInFtp) {
	                    if (!file.isFile()) {
	                        continue;
	                    }
	                    System.out.println("File is " + file.getName());
	                    //get output stream
	                    OutputStream output;
	                    output = new FileOutputStream("FtpFiles" + "/" + file.getName());
	                    //get the file from the remote system
	                    ftp.retrieveFile(file.getName(), output);
	                    //close output stream
	                    output.close();

	                    //delete the file
	                    // ftp.deleteFile(file.getName());

	                }
	            }

	            ftp.logout();
	            ftp.disconnect();
	            
	            
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
			return filesInFtp;
	    }
	 
	 private static void readProperties() throws IOException
	 {
		 Properties p = new Properties();
		    try {
		      p.load(ClassLoader.getSystemResourceAsStream(
		        "config.properties"));
		      
		      hostName =p.getProperty("HostName");
		      user =p.getProperty("User");
		      pass =p.getProperty("Pass");
		      
		      
		    } catch (IOException e) {
		      throw e;
		    }
	 }
	 
}
