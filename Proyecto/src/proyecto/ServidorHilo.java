package proyecto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorHilo extends Thread {

    private Socket socket;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private int idSesionAtendida;
    ConexionSQL conexionSQL;

    public ServidorHilo(Socket socket, ConexionSQL conexionSQL) {
        this.conexionSQL = conexionSQL;
        this.socket = socket;
        //this.idSesionAtendida = idSesionAtendida;

        try {
            entrada = new DataInputStream(this.socket.getInputStream());
            salida = new DataOutputStream(this.socket.getOutputStream());
        } catch (IOException ex) {
            System.err.println("error IO");
        }
    }

    private void desconectar() {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
String nom,pat,mat,fecha,dir,tel,noCuenta,nip,deposito;
String campos[];
String query;
double saldo;
double cDeposito;
    ResultSet resultados;
    @Override
    public void run() {
        try {
            int tipo = entrada.readInt();
            String accion = entrada.readUTF();
           // System.out.println("Cliente con Sesion " + this.idSesionAtendida + "Solicito contar hasta  ");

            /* for (int i = 0; i <= contador; i++) {
             System.out.println("sesion: " + this.idSesionAtendida + " " + i);
             Thread.sleep(1000);
             }*/
            switch (tipo) {
                case 1://registro
                   // String nom,pat,mat,fecha,dir,tel,noCuenta,nip;
                   // String campos[] = accion.split(":");
                    campos=accion.split(":");
                    nom = campos[0];
                    pat = campos[1];
                    mat = campos[2];
                    fecha = campos[3];
                    dir = campos[4];
                    tel = campos[5];
                    noCuenta = campos[6];
                    nip = campos[7];
                    double temp=0;
                     query = "INSERT INTO usuarios VALUES('" + nom + "','" + pat + "','" + mat + "','" + fecha + "','" + dir + "','" + tel + "','" + noCuenta + "','" + nip + "')";
                    conexionSQL.actualizarBD(query);
                    query="INSERT INTO cuenta VALUES ('"+noCuenta+"','"+temp+"')";
                    conexionSQL.actualizarBD(query);
                   
                    salida.writeUTF("Bien");

                    break;
                    
                case 2://verificar
                   // String noCuenta,nip;
                   // String campos[]=accion.split(":");
                    campos=accion.split(":");
                    noCuenta=campos[0];
                    nip=campos[1];
                    
                     query="SELECT * FROM usuarios WHERE noCuenta="+noCuenta+" AND nip="+nip;
                     resultados=conexionSQL.ejecutarConsulta(query);
                     
                     if (resultados.next()) {
                         
                         System.out.println("entraste");
                         salida.writeUTF("Bien");
                         
                         query="SELECT * FROM usuarios WHERE noCuenta="+noCuenta;
                         resultados=conexionSQL.ejecutarConsulta(query);
                         while (resultados.next()) {
                             nom=resultados.getString(resultados.findColumn("nombre"));
                             pat=resultados.getString(resultados.findColumn("paterno"));
                         }
                         query="SELECT * FROM cuenta WHERE noCuenta="+noCuenta;
                         resultados=conexionSQL.ejecutarConsulta(query);
                         
                         while (resultados.next()) {
                             saldo=resultados.getDouble(resultados.findColumn("saldo"));
                             
                         }
                         
                         
                         Movimientos movimientos = new Movimientos(null,false, nom+" "+pat, saldo, noCuenta);
                         movimientos.setVisible(true);
                         
                    }else{
                         System.out.println("no existe");
                         salida.writeUTF("Mal");
                     }
                    break;
                    case 3://no tiene noCuenta 
                        campos=accion.split(":");
                        
                       double nuevoSaldo=Double.parseDouble(campos[0]);
                       noCuenta=campos[1];
                          query = "UPDATE cuenta SET saldo=" + nuevoSaldo + " WHERE noCuenta=" + noCuenta;
                         conexionSQL.actualizarBD(query);
                         salida.writeUTF("Bien");
                         
                        
                    break;
                        case 4:
                            campos=accion.split(":");
                            double nuevoSaldo2=Double.parseDouble(campos[0]);
                            noCuenta=campos[1];
                             query = "UPDATE cuenta SET saldo=" + nuevoSaldo2 + " WHERE noCuenta=" + noCuenta;
                             conexionSQL.actualizarBD(query);
                             salida.writeUTF("Bien");
                            
                    break;
                            case 5:
                                campos= accion.split(":");
                               // double
                                saldo=Double.parseDouble(campos[0]);
                                deposito=campos[1];
                                cDeposito=Double.parseDouble(campos[2]);
                                noCuenta=campos[3];
                              query="SELECT * FROM cuenta WHERE noCuenta="+deposito;
                              ResultSet rr=conexionSQL.ejecutarConsulta(query);
                              double tmp=0;  
                              while (rr.next()) {
                                    tmp=rr.getDouble(rr.findColumn("saldo"));
                                }
                              tmp=tmp+cDeposito;
                              query = "UPDATE cuenta SET saldo=" + tmp + " WHERE noCuenta=" + deposito;
                              conexionSQL.actualizarBD(query);
                              double xd=0;
                             
                              query= "UPDATE cuenta SET saldo=" + saldo + " WHERE noCuenta=" + noCuenta;
                              conexionSQL.actualizarBD(query);
                              salida.writeUTF("Bien");
                                System.out.println(xd);
                                
                    break;
                default:
                    throw new AssertionError();
            }

            

        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
    }
}
