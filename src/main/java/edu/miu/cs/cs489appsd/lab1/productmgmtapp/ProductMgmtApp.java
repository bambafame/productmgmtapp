package edu.miu.cs.cs489appsd.lab1.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1.productmgmtapp.model.Product;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class ProductMgmtApp {

  public static void main(String[] args) {
    Product[] products = {
        new Product(
            31288,
            "Banana",
            LocalDate.of(2026, 1, 24),
            124,
            new BigDecimal("0.55")
        ),

        new Product(
            19274,
            "Apple",
            LocalDate.of(2025, 12, 9),
            18,
            new BigDecimal("1.09")
        ),

        new Product(
            91899,
            "Carrot",
            LocalDate.of(2026, 3, 31),
            89,
            new BigDecimal("2.99")
        ),

        new Product(
            12345,
            "Banana",
            LocalDate.of(2026, 2, 13),
            240,
            new BigDecimal("0.65")
        )
    };

    printProducts(products);
  }

  public static void printProducts(Product[] products) {
    Arrays.sort(
        products,
        Comparator.comparing(Product::getName)
            .thenComparing(Product::getUnitPrice, Comparator.reverseOrder())
    );

    printJson(products);
    printXml(products);
    printCsv(products);

  }

  private static void printJson(Product[] products) {

    System.out.println("================ JSON ================");

    System.out.println("[");

    for (int i = 0; i < products.length; i++) {

      Product product = products[i];

      System.out.println("  {");
      System.out.printf("    \"productId\": %d,%n", product.getProductId());
      System.out.printf("    \"name\": \"%s\",%n", product.getName());
      System.out.printf("    \"dateSupplied\": \"%s\",%n", product.getDateSupplied());
      System.out.printf("    \"quantityInStock\": %d,%n", product.getQuantityInStock());
      System.out.printf("    \"unitPrice\": %.2f%n", product.getUnitPrice());

      if (i < products.length - 1) {
        System.out.println("  },");
      } else {
        System.out.println("  }");
      }
    }

    System.out.println("]");
    System.out.println();
  }

  private static void printXml(Product[] products) {

    System.out.println("================ XML =================");

    System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    System.out.println("<products>");

    for (Product product : products) {

      System.out.println("  <product>");

      System.out.printf("    <productId>%d</productId>%n", product.getProductId());

      System.out.printf("    <name>%s</name>%n", product.getName());

      System.out.printf("    <dateSupplied>%s</dateSupplied>%n", product.getDateSupplied());

      System.out.printf("    <quantityInStock>%d</quantityInStock>%n", product.getQuantityInStock());

      System.out.printf("    <unitPrice>%.2f</unitPrice>%n", product.getUnitPrice());

      System.out.println("  </product>");
    }

    System.out.println("</products>");
    System.out.println();
  }

  private static void printCsv(Product[] products) {

    System.out.println("================ CSV =================");

    System.out.println(
        "productId,name,dateSupplied,quantityInStock,unitPrice"
    );

    for (Product product : products) {

      System.out.printf(
          "%d,%s,%s,%d,%.2f%n",
          product.getProductId(),
          product.getName(),
          product.getDateSupplied(),
          product.getQuantityInStock(),
          product.getUnitPrice()
      );
    }
  }
}
