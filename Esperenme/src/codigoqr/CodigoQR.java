/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoqr;

import com.barcodelib.barcode.QRCode;
import java.awt.Desktop;
import java.io.File;

/**
 *
 * @author Eduardo
 */
public class CodigoQR {

    int udm = 0, resol = 72, rot = 0;
    float mi = 0.000f, md = 0.000f, ms = 0.000f, min = 0.000f, tam = 5.00f;

    public void generarQr(String dato,String nombreA) {
        try {
            QRCode c = new QRCode();
            c.setData(dato);
            c.setDataMode(QRCode.MODE_BYTE);
            c.setUOM(udm);
            c.setLeftMargin(mi);
            c.setRightMargin(md);
            c.setTopMargin(ms);
            c.setBottomMargin(min);
            c.setResolution(resol);
            c.setRotate(rot);
            c.setModuleSize(tam);

            String archivo = System.getProperty("user.home") + "/"+nombreA;
            c.renderBarcode(archivo);

            Desktop d = Desktop.getDesktop();
            d.open(new File(archivo));

        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
}
