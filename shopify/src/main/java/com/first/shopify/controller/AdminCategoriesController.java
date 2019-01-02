package com.first.shopify.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.first.shopify.entities.Categories;
import com.first.shopify.interfaces.IAdminCategorie;

@Controller
@RequestMapping(value="/adminCat")
public class AdminCategoriesController {
	@Autowired
	private IAdminCategorie adminCat;
	
	@RequestMapping(value="/index")
	public String index(Model model) {
		model.addAttribute("categorie",new Categories());
		model.addAttribute("categories", adminCat.listCategories());
		
		return "categories";
	}
	
	@RequestMapping(value="/saveCat")
	public String saveCat(@Valid Categories categorie, Model model, BindingResult br, MultipartFile file) throws IOException {
		if(br.hasErrors()) {
			model.addAttribute("categories", adminCat.listCategories());
			return "categories";
		}
		
		if(!file.isEmpty()) {
			BufferedImage bi = ImageIO.read(file.getInputStream());
			categorie.setPhoto(file.getBytes());
			categorie.setNomPhoto(file.getOriginalFilename());
		}
		
		adminCat.ajouterCategorie(categorie);
		model.addAttribute("categorie",new Categories());
		model.addAttribute("categories", adminCat.listCategories());
		
		return "categories";
	}
	
	@RequestMapping(value="photoCat",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCat(Long idCat) throws IOException {
		Categories categorie=adminCat.getCategorie(idCat);
		return IOUtils.toByteArray(new ByteArrayInputStream(categorie.getPhoto()));
	}
	
}
