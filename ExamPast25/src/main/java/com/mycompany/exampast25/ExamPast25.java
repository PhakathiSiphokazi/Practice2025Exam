/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exampast25;

/**
 *
 * @author emeris
 */
public class ExamPast25 {

    public static void main(String[] args) {
        
        // Step 1: Create a two-dimensional array
        // This stores the sales for two years and three quarters

        int[][] productSales = {
            {300, 150, 700},
            {250, 200, 600}
        };

        // Step 2: Create single-dimensional arrays
        // These store the year names and quarter names

        String[] years = {
            "YEAR 1",
            "YEAR 2"
        };

        String[] quarters = {
            "Q1",
            "Q2",
            "Q3"
        };

        // Step 3: Create an object of the ProductSales class
        ProductSales ps = new ProductSales();

        // Step 4: Display the report heading
        System.out.println("---------------------------------------------");
        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("---------------------------------------------");

        // Step 5: Print the column headings
        System.out.print("YEARS\t");

        for (int col = 0; col < quarters.length; col++) {
            System.out.print(quarters[col] + "\t");
        }

        System.out.println();

        // Step 6: Print the rows and columns
        for (int row = 0; row < productSales.length; row++) {

            System.out.print(years[row] + "\t");

            for (int col = 0; col < productSales[row].length; col++) {

                System.out.print(productSales[row][col] + "\t");
            }

            System.out.println();
        }

        // Step 7: Display the sales calculations
        System.out.println("---------------------------------------------");

        System.out.println("Total sales: " +
                ps.TotalSales(productSales));

        System.out.println("Average sales: " +
                Math.round(ps.AverageSales(productSales)));

        System.out.println("Maximum sale: " +
                ps.MaxSale(productSales));

        System.out.println("Minimum sale: " +
                ps.MinSale(productSales));

        System.out.println("---------------------------------------------");

    }
}


