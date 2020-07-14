package tarea3archivosdirectos;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

public class GraficaPastel extends ApplicationFrame {

    public GraficaPastel(String title, JTable arr) {
        super(title);

        // this.setContentPane(crearDemoPanel());
        DefaultPieDataset dataset = new DefaultPieDataset();
       /* for (Pelicula arr1 : arr) {
            dataset.setValue(arr1.getNombre(), arr1.getDuracion());
        }*/
        
        
         for (int i = 0; i < arr.getRowCount(); i++) {
            for (int j = 0; j < arr.getColumnCount() + 1; j++) {

              String str=arr.getValueAt(i, 3).toString();
              int valor=Integer.parseInt(str);
              String str2=arr.getValueAt(i, 1).toString();
              
              dataset.setValue(str2,valor );
                  

                  
                
            }
        }
        JFreeChart chart = ChartFactory.createPieChart(
                "Duracion", //Nombre del gráfico
                dataset, //data
                true, //Leyenda
                true,
                false);
       //Color de la ventana
        // chart.setBackgroundPaint(Color.green);
        PiePlot plot = (PiePlot) chart.getPlot();
        //Color de las etiquetas
        plot.setLabelBackgroundPaint(Color.CYAN);
        //Color de el fondo del gráfico
        plot.setBackgroundPaint(Color.PINK);
        plot.setNoDataMessage("No hay data");

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 500));
        this.setContentPane(chartPanel);

    }

}
