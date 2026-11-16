/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.exampast25;

/**
 *
 * @author emeris
 */
public interface IProduct {
    int TotalSales(int[][] productSales);

    double AverageSales(int[][] productSales);

    int MaxSale(int[][] productSales);

    int MinSale(int[][] productSales);
}
