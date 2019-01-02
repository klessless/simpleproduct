package com.first.shopify;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.first.shopify.entities.Categories;
import com.first.shopify.entities.Produit;
import com.first.shopify.interfaces.IAdminCategorie;

public class TestDB {
	
	ClassPathXmlApplicationContext path;
	
	@Before
	public void setUp() throws Exception {
			path =new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
	}

	@Test
	public void test() {
		try{
				IAdminCategorie metier=(IAdminCategorie) path.getBean("metier");
				List<Categories> cat=metier.listCategories();
				Categories c1=new Categories("nomCategorie1", "description1", null, "nomPhoto");
				Categories c2=new Categories("nomCategorie2", "description2", null, "nomPhoto");
				metier.ajouterCategorie(c1);
				metier.ajouterCategorie(c2);
				List<Categories> cat2=metier.listCategories();
				assertTrue(cat.size()+2==cat2.size());
		}catch (Exception e) {
				assertTrue(e.getMessage(),false);
		}
	}
	
	@Test
	public void test2() {
		try{
				IAdminCategorie metier=(IAdminCategorie) path.getBean("metier");
				List<Produit> cat=metier.listProduits();
				Produit p1=new Produit("nomProduit1", "description", 500, true, "nomPhoto", 1);
				Produit p2=new Produit("nomProduit2", "description2", 2500, true, "nomPhoto", 1);
				metier.ajouterProduit(p1, 1L);
				metier.ajouterProduit(p2,1L);
				List<Produit> cat2=metier.listProduits();
				assertTrue(cat.size()+2==cat2.size());
		}catch (Exception e) {
				assertTrue(e.getMessage(),false);
		}
	}

}



