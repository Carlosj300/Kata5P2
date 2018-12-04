package view;

import java.awt.Container;
import java.awt.Dimension;
import static java.util.logging.Logger.global;
import javax.swing.JPanel;
import static jdk.nashorn.internal.objects.NativeRegExp.global;
import model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame {
    
    private final Histogram<String> histogram;
    public HistogramDisplay(Histogram<String> histogram ){
        super("Histogram");
        this.histogram = histogram;
        this.setContentPane(CreatePanel());
        pack();
    }
    
    private JPanel CreatePanel(){
        ChartPanel chartPanel = new  ChartPanel(CreateChart(CreateDataSet()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        
        return chartPanel;
    }
    
    private JFreeChart CreateChart (DefaultCategoryDataset dataSet){
        JFreeChart chart;
        chart = ChartFactory.createBarChart("Histogram FreeChart",
                "Dominios de emails","Nº de emails", dataSet,PlotOrientation.VERTICAL,
                false,false,rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset CreateDataSet(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        
        for (String key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key), "", key);
        }

        
        return dataSet;
        
    }
    
    public void execute(){
        this.setVisible(true);
    }
}