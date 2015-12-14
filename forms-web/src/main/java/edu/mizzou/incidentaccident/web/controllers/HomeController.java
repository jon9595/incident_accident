package edu.mizzou.incidentaccident.web.controllers;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mizzou.incidentaccident.api.common.util.SignatureToImage;
import edu.mizzou.incidentaccident.api.models.SignaturesModel;
import edu.mizzou.incidentaccident.api.services.SignaturesService;

@Controller
public class HomeController {

	@Autowired
	private SignaturesService signaturesService;
	
	@RequestMapping(value="/logout")
	public String logoff(ModelMap map, HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String index(ModelMap map, HttpServletRequest request) {
		return "main.index";
	}

	@RequestMapping(value="/displaySignature/{id}")
	public void displaySignature(@PathVariable String id, ModelMap map, HttpServletResponse response) {
		ServletOutputStream sos = null;
		try {
			SignaturesModel signature = signaturesService.getSignatures(new Integer(id));
			if (signature != null) {
				sos = response.getOutputStream();
				response.setHeader("Content-disposition", "inline; filename=\"signature.jpg\"");
				response.setContentType("image/png");
				sos.write(signature.getData());
			}
		} catch (Exception e) {
			System.err.println("exception: " + e.getMessage());
		} finally {
			try {
				sos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	@RequestMapping(value="/regenSignature/{id}")
	public void regenSignature(@PathVariable String id, ModelMap map, HttpServletResponse response) {
		ServletOutputStream sos = null;
		try {
			SignaturesModel signature = signaturesService.getSignatures(new Integer(id));
			if (signature != null) {
				BufferedImage bi = SignatureToImage.convertJsonToImage(signature.getJsonData());
				sos = response.getOutputStream();
				response.setHeader("Content-disposition", "inline; filename=\"signature.jpg\"");
				response.setContentType("image/png");
				ImageIO.write(bi, "PNG", sos);			}
		} catch (Exception e) {
			System.err.println("exception: " + e.getMessage());
		} finally {
			try {
				sos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
}