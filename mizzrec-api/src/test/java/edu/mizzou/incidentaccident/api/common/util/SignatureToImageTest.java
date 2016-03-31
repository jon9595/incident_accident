package edu.mizzou.incidentaccident.api.common.util;

import java.awt.image.BufferedImage;

import javax.annotation.Generated;

import org.junit.Test;

@Generated(value = "org.junit-tools-1.0.2")
public class SignatureToImageTest {

	private SignatureToImage createTestSubject() {
		return new SignatureToImage();
	}

	@MethodRef(name = "convertJsonToImage", signature = "(QString;)QBufferedImage;")
	@Test
	public void testConvertJsonToImage() throws Exception {
		String jsonString = "";
		BufferedImage result;

		// default test
		result = SignatureToImage.convertJsonToImage(jsonString);
	}
}