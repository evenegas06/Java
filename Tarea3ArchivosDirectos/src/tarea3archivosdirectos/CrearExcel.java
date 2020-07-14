package tarea3archivosdirectos;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.util.CellRangeAddress;
import static org.apache.poi.hwpf.model.FileInformationBlock.logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CrearExcel {

    private FileOutputStream fileOut;
    private Workbook workbook;
    private Sheet sheet;
    private Row fila;

    public void crearWorkBook(String ruta) {
        try {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("ICO");
            fileOut = new FileOutputStream(ruta);

        } catch (FileNotFoundException ex) {
            System.err.println("Nose pudo crear archivo");
        }
    }

    public void crearFila(int indice) {
        fila = sheet.createRow(indice);
    }

    public void escribirTexto(String texto,  int cell) {
        //Row fila = sheet.createRow(row);
       CellStyle style = workbook.createCellStyle();
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);
        sheet.autoSizeColumn(4);
        sheet.autoSizeColumn(5);
        sheet.autoSizeColumn(6);
        
       
        Cell celda = fila.createCell(cell);
        celda.setCellType(Cell.CELL_TYPE_STRING);
          celda.setCellStyle(style);
        celda.setCellValue(texto);
    }
    
    public void escribirNumero(double numero,  int cell) {
        // Row fila = sheet.createRow(row);
        Cell celda = fila.createCell(cell);
        celda.setCellType(Cell.CELL_TYPE_NUMERIC);
        celda.setCellValue(numero);
    }

    public void escribirWorkbook() {
        try {
            workbook.write(fileOut);
            fileOut.close();
             
        } catch (IOException ex) {
            System.err.println("No pudo escribir libro");
        }

    }
    
    public void abrirEscritorio(String ruta){
        Desktop desk = Desktop.getDesktop();
        try {
            desk.open(new File(ruta));
        } catch (IOException ex) {
            Logger.getLogger(CrearExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
