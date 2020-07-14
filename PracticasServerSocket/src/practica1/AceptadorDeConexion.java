/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Eduardo
 */
//encargada de estar esperando una clase en modo servidor
public class AceptadorDeConexion {

    public static void main(String[] args) throws IOException {

        ServerSocket socketConexion = null;
        Socket socketDatos = null;

        try {
            int puerto = 12345;

            //Instancia un socket para aceptar la conexion
            socketConexion = new ServerSocket(puerto);
            socketConexion.setSoTimeout(10000);
            System.out.println("Esperando Conexion...");

            socketDatos = socketConexion.accept();//Se espera una conexion
            System.out.println("Conexion Aceptada");

            /*DataOutputStream dataOutputStream = new DataOutputStream(socketDatos.getOutputStream());
             dataOutputStream.writeUTF("Peticion de conexion aceptada");
             dataOutputStream.writeInt(11);*/
            
            Persona persona1 = new Persona("Eduardo", "Venegas", "Rivera", 21);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(persona1);
            
                //flujo de salida es por donde viajan los bytes
            OutputStream flujoSalida = socketDatos.getOutputStream();
                
            //los bytes del objeto colocados en un array
            byte[] bytesObjeto = baos.toByteArray();
            flujoSalida.write(bytesObjeto);

            System.out.println("Mensaje enviado");

        } catch (IOException ex) {
            System.err.println("No se pudo crear socket de conexion");
        } finally {
            if (socketDatos != null) {
                socketDatos.close();
            }
            if (socketConexion != null) {
                socketConexion.close();
            }

        }
    }

}
