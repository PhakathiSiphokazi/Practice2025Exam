/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exampast25;

/**
 *
 * @author emeris
 */
public class ProductSales implements IProduct {
     // Method 1: Calculate total sales
    @Override
    public int TotalSales(int[][] productSales) {

        int total = 0;

        // Loop through rows
        for (int row = 0; row < productSales.length; row++) {

            // Loop through columns
            for (int col = 0; col < productSales[row].length; col++) {

                total = total + productSales[row][col];
            }
        }

        return total;
    }

    // Method 2: Calculate average sales
    @Override
    public double AverageSales(int[][] productSales) {

        int total = TotalSales(productSales);

        int count = 0;

        // Count the number of sales values
        for (int row = 0; row < productSales.length; row++) {

            for (int col = 0; col < productSales[row].length; col++) {

                count++;
            }
        }

        return (double) total / count;
    }

    // Method 3: Find the maximum sale
    @Override
    public int MaxSale(int[][] productSales) {

        int maximum = productSales[0][0];

        for (int row = 0; row < productSales.length; row++) {

            for (int col = 0; col < productSales[row].length; col++) {

                if (productSales[row][col] > maximum) {

                    maximum = productSales[row][col];
                }
            }
        }

        return maximum;
    }

    // Method 4: Find the minimum sale
    @Override
    public int MinSale(int[][] productSales) {

        int minimum = productSales[0][0];

        for (int row = 0; row < productSales.length; row++) {

            for (int col = 0; col < productSales[row].length; col++) {

                if (productSales[row][col] < minimum) {

                    minimum = productSales[row][col];
                }
            }
        }

        return minimum;
    }

}
