package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entitys.OrderDetails;
import entitys.Products;
import service.OrderDetaisService;
import service.OrderService;
import service.ProductsService;

public class Main {
	
	
	public static void main(String[] args) {
		ProductsService productsService = new ProductsService();
		List<Products> listProducts = productsService.listProducts();
		OrderDetaisService orderDetails = new OrderDetaisService();
		List<OrderDetails> listOrderDetails = new ArrayList<OrderDetails>();	
		OrderService orderService = new OrderService();
		try (Scanner sc = new Scanner(System.in)) {
			int input = 0;
			
			do {
				System.out.println("--------------Grocery Store-------------");
				System.out.println("1.Show list product");
				System.out.println("2.Add products by cart");
				System.out.println("3.Show cart");
				System.out.println("4.Show bill");
				System.out.println("5.exit");
				input = sc.nextInt();
				
				switch (input) {
				case 1:
					productsService.showProduct(listProducts);
					System.out.println();
					break;
				case 2:
					int productId = 0;
					do {
						System.out.print("Enter product id or 0 exit: ");
						productId = sc.nextInt();
						
						Products products = productsService.getProductById(productId,listProducts);
						if(products != null) {
							System.out.print("Enter the number of product: ");
							int number = sc.nextInt();
							
							//if order empty
							if(listOrderDetails.size()==0) {
								OrderDetails orderDetails2 = orderDetails.addProductByOrderDetails(products, number);
								listOrderDetails.add(orderDetails2);
							}else {
								int a = 0;
								for(int i =0; i< listOrderDetails.size();i++) {
									int productId1 =listOrderDetails.get(i).getProducts().getId();
									//if product already exists
									if( productId1 == productId) {
										a++;
										System.out.print("The product already exists in the cart. Enter y update amount product. "
												+"Enter n skip ");
										String choose = sc.next();
										if("y".equals(choose)) {
											listOrderDetails.get(i).setAmount(listOrderDetails.get(i).getAmount()+ number);
											orderDetails.updateTotalOrderDetails(listOrderDetails.get(i));
											
										}
									}
								}
								if(a == 0) {
										OrderDetails orderDetails2 = orderDetails.addProductByOrderDetails(products, number);
										listOrderDetails.add(orderDetails2);
										a = 0;
								}
							}
							
						}
						else if (products == null && productId != 0){
							System.out.println("No products found with id " + productId);
							break;
						}
					} while (productId > 0);
					break;
				case 3:
					System.out.println("List product order: ");
					orderService.showOrder(listOrderDetails);
					break;
				case 4:
					orderService.showOrder(listOrderDetails);
					System.out.println("TOTAL MONEY: " + orderService.totalBills(listOrderDetails));
					listOrderDetails.clear();
					break;
				}
				
					
			} while (input > 0 && input <5);
			
		}

	}

}
