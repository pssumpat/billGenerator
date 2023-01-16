package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.ProductRepo;
import com.example.demo.model.BillProduct;
import com.example.demo.model.Product;

@Controller
public class indexController 
{
	@RequestMapping("/")
	public String getHomePage()
	{
		return "index.jsp";
	}
	
	@Autowired
	ProductRepo productRepo;
	
	@RequestMapping("/generateBill")
	public ModelAndView billGenerator(String amount,String billDate)
	{
		int billAmount = Integer.parseInt(amount);
		int min=1;
		int max=(int) productRepo.count();
		System.out.println(max);
		int i=1;
		int billMade=0;
		ArrayList<BillProduct> list = new ArrayList<BillProduct>();
		
		while(billAmount>0)
		{
			if(billAmount<50)
			{
				break;
			}
			int chooseRandomProduct = (int)Math.floor(Math.random()*(max-min+1)+min);
			Product randomProduct = productRepo.findById(chooseRandomProduct).orElse(null);
			int productPrice = Integer.parseInt((String)randomProduct.getProductPrice());
			int checkBillAmount = billAmount-productPrice;
			if(checkBillAmount>0)
			{
				BillProduct billProduct = new BillProduct();
				billProduct.setQuantity(1);
				billProduct.setSerialNumber(i);
				billProduct.setProductName(randomProduct.getProductName());
				billProduct.setProductPrice(Integer.parseInt(randomProduct.getProductPrice()));
				list.add(billProduct);
				billAmount= checkBillAmount;
				billMade= billMade+productPrice;
				i++;
			}
			else
			{
				continue;
			}
		}
		BillProduct billProductLast = new BillProduct();
		billProductLast.setQuantity(1);
		billProductLast.setSerialNumber(i);
		billProductLast.setProductName("Packaging");
		billProductLast.setProductPrice(billAmount);
		list.add(billProductLast);
		int length = list.size();
		int j=0;
		while(j<length)
		{
			System.out.println(list.get(j));
			j++;
		}
		
		System.out.println("Total bill amount ="+amount);
		System.out.println("Bill Made of amount = "+billMade);
		System.out.println("Packaging  ="+billAmount);
		System.out.println(billDate);
//		====================================================================================================
		ArrayList<BillProduct> finalList = new ArrayList<BillProduct>();
		int serialNumber = 1;
		
		for(int k=0;k<length;k++)
		{
			int count=1;
			BillProduct billProductFinal = new BillProduct();
			billProductFinal.setSerialNumber(serialNumber);
			BillProduct billProductK = list.get(k);
			for(int l=k+1;l<length;l++)
			{
				
				BillProduct billProductL = list.get(l);
				if(billProductK.getProductName().equals(billProductL.getProductName()))
				{
					list.remove(billProductL);
					length--;
					count++;
					
				}
				
			}
			billProductFinal.setProductName(billProductK.getProductName());
			billProductFinal.setQuantity(count);
			billProductFinal.setProductPrice(billProductK.getProductPrice()*count);
			finalList.add(billProductFinal);
			serialNumber++;
		}
		
		int lengthFinal = finalList.size();
		int d=0;
		while(d<lengthFinal)
		{
			System.out.println(finalList.get(d));
			d++;
		}
//		=================================================================================================
		ModelAndView mv = new ModelAndView("indexWithBill.jsp");
		mv.addObject("bill", finalList);
		mv.addObject("total", amount);
		return mv;
	}
	
	@RequestMapping("addProduct")
	public String addProduct(Product product)
	{
		productRepo.save(product);
		return "index.jsp";
	}

}

