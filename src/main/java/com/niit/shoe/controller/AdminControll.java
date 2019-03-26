package com.niit.shoe.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.niit.shoe.dao.CategoryDao;
import com.niit.shoe.dao.ProductShoeDao;
import com.niit.shoe.model.Category;
import com.niit.shoe.model.Product;


@Controller
@RequestMapping("/admin")
public class AdminControll {
	
	
		@Autowired
		CategoryDao categorydao;
		
		@Autowired
		ProductShoeDao productDao;
		
		
		@RequestMapping("/category")
		public ModelAndView categorylist(Model m)
		{
			
			Category cat = new Category();
			m.addAttribute(cat);
			List<Category> listcat = categorydao.retrievedAllData();
			m.addAttribute("catlist", listcat);
			return new ModelAndView("category");
			
		}
		
		@RequestMapping(value="/catprocess", method= RequestMethod.POST)
		public String addCategory(@ModelAttribute("category") Category category , Model m) throws Exception
		{
				System.out.println("cat id ="+category.getcategoryid());
				if (category.getcategoryid() != 0) {

					categorydao.update(category);

				} else {
					categorydao.addCreate(category);
				} 
	      					
				@SuppressWarnings("unused")
				List<Category> listcategories = categorydao.retrievedAllData();
				
				return "redirect:/admin/category";
			
				
		}
		
		@RequestMapping(value = "updateCat/{catId}")
		public String updateCategory(@PathVariable("catId") int catId, Model m)
		{
			
			
			Category category = categorydao.getCategory(catId);
			m.addAttribute("category",category);
	     	
			System.out.println("it is in update category"+category.getcategoryid());
			
		    categorydao.update(category);
			m.addAttribute(category);
 
			System.out.println("after process "+category.getcategoryid());
			List<Category> listcategories = categorydao.retrievedAllData();
			m.addAttribute("catlist", listcategories);
			return "category";
			
		}
		
		@RequestMapping(value = "deleteCat/{catId}")

		public String deleteCategory(@PathVariable("catId") int catId, Model m) {

			Category c = categorydao.getCategory(catId);

			categorydao.delete(c);

			Category category = new Category();

			m.addAttribute(category);

			List<Category> listcategories = categorydao.retrievedAllData();

			m.addAttribute("catlist", listcategories);

			return "redirect:/admin/category";

		}
		
		@RequestMapping("/product")
		public ModelAndView product(Model m)
		{
			Product product = new Product();
			m.addAttribute(product);
			List<Product> listproducts = productDao.retrievedAllData(); 
			m.addAttribute("prodlist",listproducts);
			List<Category> listcategories = categorydao.retrievedAllData();

			m.addAttribute("catlist", listcategories);


			return  new ModelAndView("product");
		}
		
	@RequestMapping(value = "/prodprocess", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("product") Product pr,@RequestParam("image") MultipartFile mfile,  Model m, BindingResult result, HttpServletRequest request) 
	{ 
		System.out.println("product id =" + pr.getProductid());
         if(pr.getProductid()!=0 ) {
        	 productDao.update(pr);
         }
         else {
        	 productDao.addCreate(pr);	 
         }
         
         //mutipart code to insert an image 
         String path = request.getServletContext().getRealPath("/resources/");
         String totalFilewithPath = path + String.valueOf(pr.getProductid()) + ".jpg";
         File productImage = new File(totalFilewithPath);
         
         
         if (!mfile.isEmpty()) {
        	   try {
        	    byte fileBuffer[] = mfile.getBytes();
        	    FileOutputStream fos = new FileOutputStream(productImage);
        	    BufferedOutputStream bs = new BufferedOutputStream(fos);
        	    bs.write(fileBuffer);
        	    bs.close();
        	   } catch (Exception e) {
        	    m.addAttribute("File Exception", e);
        	   }
        	  }
        	  else {
        	   m.addAttribute("error", "problem in uploading image");
        	  }
        	 
        	 
		@SuppressWarnings("unused")
		List<Product> listproducts = productDao.retrievedAllData();
		m.addAttribute("prodlist",listproducts);
		
		List<Category> listcategories = categorydao.retrievedAllData();
		m.addAttribute("catlist", listcategories);
		
		return "redirect:/admin/product";

	}	
	
	@RequestMapping(value = "updatePat/{pid}")
	public String updateProduct(@PathVariable("pid")int pid, Model m)
	{
		Product pr = productDao.getProductid(pid);
		m.addAttribute("product", pr);
		System.out.println("it is in update category"+pr.getProductid());
		
		productDao.update(pr);
		m.addAttribute(pr);
		System.out.println("after process "+pr.getProductid());
		List<Product> listproducts = productDao.retrievedAllData();
		m.addAttribute("prodlist",listproducts);
		return "product";
		
	}
 @RequestMapping(value = "deletePat/{pid}")

	public String deleteProduct(@PathVariable("pid") int pid, Model m) {

		Product p = productDao.getProductid(pid);


		productDao.delete(p);

		Product pr = new Product();
		m.addAttribute(pr);

		List<Product> listproducts =productDao.retrievedAllData(); 
		m.addAttribute("prodlist",listproducts);
		
		List<Category> listcategories = categorydao.retrievedAllData();
		m.addAttribute("catlist", listcategories);

		return "redirect:/admin/product";

	}
 


}

		
	


