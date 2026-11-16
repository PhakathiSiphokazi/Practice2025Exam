/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exampast25q2;

/**
 *
 * @author emeris
 */
// Import statements to create GUI
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ExamPast25Q2 implements ActionListener {

    // =================================
    // Instance variables
    // =================================

    // Text area
    JTextArea outputArea;

    // Label
    JLabel yearsProcessedLabel;

    // Buttons
    JButton loadButton;
    JButton saveButton;

    // Menu items
    JMenuItem exit;
    JMenuItem load;
    JMenuItem save;
    JMenuItem clear;

    // Create ProductSales object
    ProductSales2 productSales = new ProductSales2();


    public static void main(String[] args) {
        
        //=======================================
        // Step 1: Create and configure the window
        //=======================================

        JFrame frame = new JFrame();

        frame.setTitle("Product Sales Application");

        frame.setSize(400, 400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlowLayout layout = new FlowLayout(FlowLayout.CENTER);

        frame.setLayout(layout);


        //==============================
        // Step 2: Create the menu
        //==============================

        JMenuBar menuBar = new JMenuBar();

        // Menu headings
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");

        // Menu items
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem load = new JMenuItem("Load Product Data");
        JMenuItem save = new JMenuItem("Save Product Data");
        JMenuItem clear = new JMenuItem("Clear");

        // Add items to their menus
        file.add(exit);

        edit.add(load);
        edit.add(save);
        edit.add(clear);

        // Add menus to menu bar
        menuBar.add(file);
        menuBar.add(edit);

        // Add menu bar to frame
        frame.add(menuBar);


        //==============================
        // Step 3: Create components
        //==============================

        JLabel headingLabel = new JLabel("Product Sales Report");

        JLabel outputAreaLabel = new JLabel("Product Sales Information");

        JTextArea outputArea = new JTextArea(10, 30);

        outputArea.setEditable(false);

        JScrollPane outputScrollBar = new JScrollPane(outputArea);

        JLabel yearsProcessedLabel = new JLabel("Years Processed: 0");

        // Buttons
        JButton loadButton = new JButton("Load Product Data");

        JButton saveButton = new JButton("Save Product Data");


        //========================================
        // Step 4: Create listener and connect it
        //========================================

        ExamPast25Q2 listenerObject = new ExamPast25Q2();

        // Give listener access to components
        listenerObject.loadButton = loadButton;
        listenerObject.saveButton = saveButton;

        listenerObject.outputArea = outputArea;

        listenerObject.yearsProcessedLabel = yearsProcessedLabel;

        listenerObject.exit = exit;
        listenerObject.load = load;
        listenerObject.save = save;
        listenerObject.clear = clear;


        // Register listener with buttons
        loadButton.addActionListener(listenerObject);
        saveButton.addActionListener(listenerObject);

        // Register listener with menu items
        exit.addActionListener(listenerObject);
        load.addActionListener(listenerObject);
        save.addActionListener(listenerObject);
        clear.addActionListener(listenerObject);


        //========================================
        // Step 5: Add components to the frame
        //========================================

        frame.add(headingLabel);

        frame.add(outputAreaLabel);

        frame.add(outputScrollBar);

        frame.add(yearsProcessedLabel);

        frame.add(loadButton);

        frame.add(saveButton);


        // Make window visible
        frame.setVisible(true);

    }


    //========================================
    // Step 6: Action performed
    //========================================

    @Override
    public void actionPerformed(ActionEvent e) {

        // Get the component that was clicked
        Object source = e.getSource();

        if (source == loadButton || source == load) {

            loadData();

        } else if (source == saveButton || source == save) {

            writeData();

        } else if (source == clear) {

            outputArea.setText("");

            yearsProcessedLabel.setText("");

        } else if (source == exit) {

            System.exit(0);

        }

    }


    //========================================
    // Step 7: Load product sales data
    //========================================

    public void loadData() {

        // Get information from ProductSales class
        int total = productSales.GetTotalSales();

        double average = productSales.GetAverageSales();

        int overLimit = productSales.GetSalesOverLimit();

        int underLimit = productSales.GetSalesUnderLimit();

        int years = productSales.GetProductsProcessed();


        // Clear previous information
        outputArea.setText("");

        // Display report
        outputArea.append("DATA LOG\n");

        outputArea.append("***********************************\n");

        outputArea.append("Total Sales: " + total + "\n");

        outputArea.append("Average Sales: " + Math.round(average) + "\n");

        outputArea.append("Sales over limit: " + overLimit + "\n");

        outputArea.append("Sales under limit: " + underLimit + "\n");

        outputArea.append("***********************************\n");


        // Display years processed
        yearsProcessedLabel.setText("Years Processed: " + years);

    }


    //========================================
    // Step 8: Save information to a file
    //========================================

    public void writeData() {

        // Get information from text area
        String report = outputArea.getText();

        // Create path for file
        Path pathLocation = Paths.get("data.txt");

        try {

            // Create and open file for writing
            BufferedWriter writerObj = Files.newBufferedWriter(
                    pathLocation,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );

            // Write information to file
            writerObj.write(report);

            // Flush contents
            writerObj.flush();

            // Close writer
            writerObj.close();

        } catch (IOException e) {

            System.out.println("Error writing to file " + e.getMessage());

        }

    }

        
  }

