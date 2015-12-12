package edu.mizzou.incidentaccident.api.common.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.google.gson.Gson;

public class SignatureToImage {

	public static BufferedImage convertJsonToImage(String jsonString){
        Gson gson = new Gson();
        SignatureLine[] signatureLines = gson.fromJson(jsonString, SignatureLine[].class);
        BufferedImage offscreenImage = new BufferedImage(200, 50, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = offscreenImage.createGraphics();
        g2.setColor(Color.white);
        g2.fillRect(0,0,200,50);
        g2.setPaint(Color.black);
        for (SignatureLine line : signatureLines ) {
            g2.drawLine(line.lx, line.ly, line.mx, line.my);
        }
        return offscreenImage;
	}
}
