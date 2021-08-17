/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author  Ankur Bywar
 */
public class GraphPlotterUtils {
    
    public void addToDataSet(Map<LocalDate, Double> values, String dimension, DefaultCategoryDataset dataset) {
        for (Map.Entry<LocalDate, Double> entry : values.entrySet()) {
            LocalDate xAxisVal = entry.getKey();
            Double yAxisVal = entry.getValue();
            dataset.addValue(yAxisVal, dimension, xAxisVal.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
        }
    }
    
    public boolean writeGraphAsImageToDisk(            
            String xAxisLabel, 
            String yAxisLabel, 
            String chartName, 
            String frameTitle, 
            DefaultCategoryDataset dataset,
            String filePath) {
        
        JFreeChart jchart = ChartFactory.createLineChart (chartName, xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false);
        BufferedImage objBufferedImage=jchart.createBufferedImage(600,800);
        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        try {
            ImageIO.write(objBufferedImage, "png", bas);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        byte[] byteArray=bas.toByteArray();
        InputStream in = new ByteArrayInputStream(byteArray);
        BufferedImage image = null;
        try {
            image = ImageIO.read(in);
        } catch (IOException ex) {
            Logger.getLogger(GraphPlotterUtils.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        File outputfile = new File(filePath);
        try {
            ImageIO.write(image, "png", outputfile);
        } catch (IOException ex) {
            Logger.getLogger(GraphPlotterUtils.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }
    
    public void createLineChart(
            String xAxisLabel, 
            String yAxisLabel, 
            String chartName, 
            String frameTitle, 
            DefaultCategoryDataset dataset, 
            JPanel panel) {
        JFreeChart jchart = ChartFactory.createLineChart (chartName, xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = jchart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        ChartFrame cf = new ChartFrame(frameTitle, jchart, true);
        cf.setVisible(true);
        cf.setSize(500, 400);
        ChartPanel cp = new ChartPanel(jchart);
        panel.removeAll();
        panel.add(cp);
        panel.updateUI();
   }
    public void createBarChart3D(
            String xAxisLabel, 
            String yAxisLabel, 
            String chartName, 
            String frameTitle, 
            DefaultCategoryDataset dataset, 
            JPanel panel) {
        JFreeChart jchart = ChartFactory.createBarChart3D(chartName, xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = jchart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        ChartFrame cf = new ChartFrame(frameTitle, jchart, true);
        cf.setVisible(true);
        cf.setSize(500, 400);
        ChartPanel cp = new ChartPanel(jchart);
        panel.removeAll();
        panel.add(cp);
        panel.updateUI();
    
    
    
}
}
