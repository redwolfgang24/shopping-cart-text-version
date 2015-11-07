package com.csss.training.console;

import com.csss.training.service.ShoppingCartServiceImpl;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 * Created by larry on 11/7/15.
 */
public class Main {

    private ShoppingCartServiceImpl serviceImpl = new ShoppingCartServiceImpl();

    public Main(String [] args) throws IOException {
        Scanner scan;
        String input = "";
        String[] splitString;

        System.out.println("Correct Format Below\n");
        System.out.println("Type : \n");
        System.out.println("   listproducts \t--> Show Product List");
        System.out.println("   showcart \t\t--> Show Shopping Cart");
        System.out.println("   buy prodNo. Qty \t--> Buy a product");
        System.out.println("\t\t\t    where: prodNo (pos integer), Qty (pos integer)\n\n");

        while(true) {
            System.out.print("java com.csss.training.console.Main : ");
            scan = new Scanner(System.in);
            input = scan.nextLine();
            splitString = input.split(" ");
            for(String s : splitString){
                if(s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("close")) {
                    System.out.println("\tProgram "+s);
                    System.exit(0);
                } else if (s.equalsIgnoreCase("listproducts")) {
                    dispListProducts();
                } else if (s.equalsIgnoreCase("showcart")) {
                    showShoppingCart();
                } else if (s.equalsIgnoreCase("buy")) {
                    if(Integer.parseInt(splitString[1]) > 0 && Integer.parseInt(splitString[1]) > 0) {
                        serviceImpl.purchasedProduct(Integer.parseInt(splitString[1]), Integer.parseInt(splitString[2]));
                        break;
                    }
                } else {
                    System.out.println("\nInvalid Format");
                    System.out.println("Correct Format Below\n");
                    System.out.println("Type : \n");
                    System.out.println("   listproducts \t--> Show Product List");
                    System.out.println("   showcart \t\t--> Show Shopping Cart");
                    System.out.println("   buy prodNo. Qty \t--> Buy a product");
                    System.out.println("\t\t\t    where: prodNo (pos integer), Qty (pos integer)\n\n");
                }
            }
        }
    }

    private void dispListProducts() {
        int counter = 1;
        if(!(isProductListEmpty(serviceImpl.getProductList()))) {
            System.out.println("\n=====================================================");
            System.out.println("Product List");
            System.out.println("-----------------------------------------------------");
            System.out.println("No.\t\t"+"Name\t\t"+"Price\t\t"+"Qty");
            System.out.println("-----------------------------------------------------");
            String []splitData;
            for(String s : serviceImpl.getProductList()) {
                splitData = s.split("\t\t");
                System.out.println((counter++)+"\t\t"+splitData[0]+"\t\t"+splitData[2]+""+"\t\t"+splitData[1]);
            }
            System.out.println("=====================================================\n");
        } else {
            System.out.println("\tNothing to Display");
            System.out.println("\t\nYour Product List Is Empty...!!!");
        }
    }

    private void showShoppingCart() {
        int counter = 1;
        if(!(isShoppCartEmpty(serviceImpl.getShopCartList()))) {
            System.out.println("\n=====================================================");
            System.out.println("Shopping Cart");
            System.out.println("-----------------------------------------------------");
            System.out.println("No.\t\t"+"Name\t\t"+"Price\t\t"+"Qty");
            System.out.println("-----------------------------------------------------");
            BigDecimal total = BigDecimal.ZERO;
            BigDecimal total1 = BigDecimal.ZERO;
            String []splitData;
            for(String s : serviceImpl.getShopCartList()) {
                splitData = s.split("\t\t");
                total1 = (new BigDecimal(splitData[2]).multiply(new BigDecimal(splitData[1])));
                total = total.add(total1);
                System.out.println((counter++)+"\t\t"+splitData[0]+"\t\t"+splitData[2]+""+"\t\t"+splitData[1]);
            }
            System.out.println("Total : "+total);
            System.out.println("=====================================================\n");
        } else {
            System.out.println("\tNothing to Display");
            System.out.println("\t\nYour Shopping Cart Is Empty...!!!");
        }
    }

    private boolean isProductListEmpty(List<String> data) {
        return (data.isEmpty()? true:false);
    }

    private boolean isShoppCartEmpty(List<String> data) {
        return (data.isEmpty()? true:false);
    }

    private boolean isAllProductQuantityZero(List<String> data) {
        String []holder;
        System.out.println();
        for(String str : data) {
            holder = str.split("\t\t");
            if(Integer.parseInt(holder[1]) > 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        new Main(args);
    }
}
