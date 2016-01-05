package edu.mizzou.incidentaccident.api.common.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppUtil {

	private static Logger log = LoggerFactory.getLogger(AppUtil.class);
	
    public static byte[] generateSignatureImage(String jsonData) {
    	byte[] binData = null;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
    	try {
        	BufferedImage bi = SignatureToImage.convertJsonToImage(jsonData);
    		if (bi !=null) {
    			ImageIO.write(bi, "jpg", os);
    			binData = os.toByteArray();
    		}
		} catch (Exception e) {
			log.error("Exception converting json data to image: " + e.getMessage(), e);
		} finally {
			try {
				os.close();
			} catch (IOException e) {
			}
		}
		return binData;
    }
	 
    public static String encodeSHA(String sha) {
		return DigestUtils.sha256Hex(sha);
	}
	
    
}
