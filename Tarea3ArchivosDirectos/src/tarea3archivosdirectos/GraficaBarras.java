package tarea3archivosdirectos;

import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class GraficaBarras extends ApplicationFrame {

    public GraficaBarras(String title, JTable arr) {
        super(title);

        DefaultCategoryDataset dataset
                = new DefaultCategoryDataset();

       
        /*     // title
        , // axis labels
        dataset, // dataset
        PlotOrientation.VERTICAL,
        true, // legend? yes
        true, // tooltips? yes
        false // URLs? no
         */
       /* for (Pelicula arr1 : arr) {
            dataset.setValue(arr1.getDuracion(), "Minutos", arr1.getNombre());
        }*/
                for (int i = 0; i < arr.getRowCount(); i++) {
            for (int j = 0; j < arr.getColumnCount() + 1; j++) {

              String str=arr.getValueAt(i, 3).toString();
              int valor=Integer.parseInt(str);
              String str2=arr.getValueAt(i, 1).toString();
              
              dataset.setValue(valor, "Minutos",str2 );
                  

                  
                
            }
        }
       
        JFreeChart chart = ChartFactory.createBarChart(
                "Duracion De Peliculas",
                "Nombre",
                "Minutos",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 500));
        this.setContentPane(chartPanel);

    }

    /* public static void main(String[] args) {
     GraficaBarras demo = new GraficaBarras("Ya aprendí a graficar");
     demo.pack();
     RefineryUtilities.centerFrameOnScreen(demo);
     demo.setVisible(true);
     }*/
}
