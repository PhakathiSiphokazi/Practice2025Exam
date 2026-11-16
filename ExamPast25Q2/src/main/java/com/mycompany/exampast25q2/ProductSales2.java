/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exampast25q2;

/**
 *
 * @author emeris
 */
public class ProductSales2  implements IProduct2 {
    // Instance variables
    int[][] productSales = {
        {300, 150, 700},
        {250, 200, 600}
    };

    int salesLimit = 500;

    // Method 1: Return product sales array
    @Override
    public int[][] GetProductSales() {

        return productSales;
    }

    // Method 2: Calculate total sales
    @Override
    public int GetTotalSales() {

        int total = 0;

        for (int row = 0; row < productSales.length; row++) {

            for (int col = 0; col < productSales[row].length; col++) {

                total = total + productSales[row][col];
            }
        }

        return total;
    }

    // Method 3: Calculate sales over the limit
    @Override
    public int GetSalesOverLimit() {

        int overLimit = 0;

        for (int row = 0; row < productSales.length; row++) {

            for (int col = 0; col < productSales[row].length; col++) {

                if (productSales[row][col] > salesLimit) {

                    overLimit++;
                }
            }
        }

        return overLimit;
    }

    // Method 4: Calculate sales under the limit
    @Override
    public int GetSalesUnderLimit() {

        int underLimit = 0;

        for (int row = 0; row < productSales.length; row++) {

            for (int col = 0; col < productSales[row].length; col++) {

                if (productSales[row][col] < salesLimit) {

                    underLimit++;
                }
            }
        }

        return underLimit;
    }

    // Method 5: Calculate years processed
    @Override
    public int GetProductsProcessed() {

        return productSales.length;
    }

    // Method 6: Calculate average sales
    @Override
    public double GetAverageSales() {

        int total = GetTotalSales();

        int count = 0;

        for (int row = 0; row < productSales.length; row++) {

            for (int col = 0; col < productSales[row].length; col++) {

                count++;
            }
        }

        return (double) total / count;
    }
}
