/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */

//Comunicacion Orientada a Conexion
public class SolicitanteDeConexion {

    public static void main(String[] args) {

        Socket socketDatos = null;
        int puerto = 12345;
        String maquinaServidor = "127.0.0.1";

        try {

            socketDatos = new Socket(maquinaServidor, puerto);
            System.out.println("Me pude conectar");
            
           /* DataInputStream dataInputStream = new DataInputStream(socketDatos.getInputStream());
            System.out.println("Mensaje recibido "+ dataInputStream.readUTF());
            System.out.println("Entero recibido "+ dataInputStream.readInt());*/
            
            InputStream flujoEntrada = socketDatos.getInputStream();
            byte[] arrayDeObjeto= new byte[300]; //Tamaño maximo a recibir
            flujoEntrada.read(arrayDeObjeto);
            
            ByteArrayInputStream bais= new ByteArrayInputStream(arrayDeObjeto);
            ObjectInputStream ois = new ObjectInputStream(bais);
            
            Object object = ois.readObject();
            
            if (object instanceof Persona) {
                Persona persona=(Persona)object;
                System.out.println(persona);
            }
            
            
            socketDatos.close();
            
        } catch (IOException ex) {
            Logger.getLogger(SolicitanteDeConexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolicitanteDeConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
