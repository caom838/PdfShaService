package com.co.micros.sha_pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPFile;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;

import com.google.common.io.ByteStreams;

public class Sha3Utils {

	static String calculate(File file) throws IOException {

		SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest256();
		InputStream targetStream = new FileInputStream(file);
		byte[] bytes = ByteStreams.toByteArray(targetStream);
		byte[] digest = digestSHA3.digest(bytes);

		return Hex.toHexString(digest);
	}
	


}
