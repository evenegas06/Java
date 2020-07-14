
package tarea3archivosdirectos;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrearPDF {
    private String rutaArchivo;
    private int columnas;
    private Document document;
    private OutputStream file=null;
    private PdfPTable table;

    
    public CrearPDF(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }
    
      public void abrirDocumento(){
       
         try {
            
            document = new Document();
            
            file = new FileOutputStream(new File(rutaArchivo));
            PdfWriter.getInstance(document, file);
            //
            document.open();
        } catch (FileNotFoundException ex) {
        } catch (DocumentException ex) {
        }
    }
    
      public void crearTabla(int columnas){
          this.columnas=columnas;
          table = new PdfPTable(columnas);
            table.setSplitRows(true);
            table.setSplitLate(true);
      }
       
    public void AnadirCeldaSimple(String texto, int borde, int horizontalAlign){      
        try{
        PdfPCell cell;
        
        cell = new PdfPCell(new Phrase(texto));
        cell.setBorder(borde);
        cell.setHorizontalAlignment(horizontalAlign);
        
        table.addCell(cell);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void AnadirCeldaConColspan(String texto, int borde, int colspan, int horizontalAlign){
        
        PdfPCell cell;
        cell = new PdfPCell(new Phrase(texto));
        cell.setBorder(borde);
        cell.setColspan(colspan);
        cell.setHorizontalAlignment(horizontalAlign);
        table.addCell(cell);
        
    }
    
    public void AnadirCeldaConRowspan(String texto, int borde, int rowspan, int horizontalAlign, int verticalAlign){
        
        PdfPCell cell;
        cell = new PdfPCell(new Phrase(texto));
        cell.setBorder(borde);
        cell.setRowspan(rowspan);
        cell.setHorizontalAlignment(horizontalAlign);
        cell.setVerticalAlignment(verticalAlign);
        table.addCell(cell);
        
    }
    
    public void EstablecerRowsDeHeaderAndFooter(int rowsHeader, int rowsFooter){
        
        table.setHeaderRows(rowsHeader);
        table.setFooterRows(rowsFooter);
    }
    
      public boolean anadirCeldaImagen(String rutaImagen, int colspan, int rowspan, boolean fit, int border){
       boolean anadioImg = true;
        try {
           Image img = Image.getInstance(rutaImagen);
           PdfPCell cell = new PdfPCell(img,fit);
           
           
           cell.setColspan(colspan);
           cell.setRowspan(rowspan);
           cell.setBorder(border);
           
           table.addCell(cell);
           
        } catch (Exception ex) {
            anadioImg = false;
             }
        
        return anadioImg;
    }
      
    public void anadirTablaADocumento(){
        try {    
            document.add(table);
            System.out.println("añadio tabla al documento");    
        } catch (DocumentException ex) {
            Logger.getLogger(CrearPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void CerrarDocumento(){
        try {
            document.close();
            System.out.println("cerro documento");
                  file.close();
                  System.out.println("doc creado con exito");
                  Desktop desk = Desktop.getDesktop();
                  desk.open(new File(rutaArchivo));
                  System.out.println("abrio documento");
        }  catch (IOException ex) {
            System.out.println("error con el archivo");
        }
    }
    
}
