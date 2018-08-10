
package Ventana;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Archivo {
    
    public static void registraTripleta() {

        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("Tripletas.txt");
            pw = new PrintWriter(fichero);
            pw.print(Ventana.f + ",");
            pw.print(Ventana.c + ",");
            pw.print((Ventana.f*Ventana.c)+",");
            pw.print((Ventana.miraEsasPistasPapa) + ";");
            pw.println("");
            
            
            for (Tripleta t : Ventana.tripletas) {
                if(t.getValor()!=Ventana.primero && t.getValor()!=Ventana.ultimo){
                pw.print(t.getFila()+",");
                pw.print(t.getColumna()+",");
                pw.print(t.getValor()+";");
                pw.println("");
                System.out.println(t.getFila()+","+t.getColumna()+","+t.getValor()+";");
                System.out.println("\t");
                }
            }
            pw.print(Ventana.tiempo);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }
    
}
