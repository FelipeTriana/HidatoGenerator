/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author user
 */
public class Ventana extends javax.swing.JFrame {

    //Matriz 
    JTextField[][] matrizDeCositas;  //Crea una matriz de JTextField que sera el tablero donde se mostrara el Hidato
    JTextField cositaNueva;
    //Variables globales
    int tamX = 0;                      //Tamaño de la matriz en filas y columnas
    int tamY = 0;
    static final int TABLEROX = 500;
    static final int TABLEROY = 500;
    static int f, c;
    int[][] tablero;
    String filas, columnas;
    boolean termina = false;
    int random1, random2, randomx, randomy;
    int[][] copiaTablero;
    int xp, yp;
    int xu, yu;
    static int primero, ultimo;
    Random random;
    boolean decision;
    int cuentapistas = 0;
    String dentroDeCosita;
    static Tripleta tripleta = new Tripleta();
    static ArrayList<Tripleta> tripletas = new ArrayList<Tripleta>();
    int pistas;
    long tiempoInicio, tiempoFin;
    static double tiempo=0.0;
    static int miraEsasPistasPapa = 0;

    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Imagen", "jpg");
    private JFileChooser fileChooser = new JFileChooser();

    //El siguiente vector comprende los espacios por los que el hidato llenara el tablero de modo que cada numero sea contiguo al que le sigue
    int[][] num = {{-1, -1}, {-1, 0}, {-1, +1}, {0, -1}, {0, -1}, {0, +1}, {+1, -1}, {+1, 0}, {+1, +1}};

    

    public Ventana() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Hidato");
        setSize(477, 500);
        getContentPane().setBackground(Color.cyan.darker());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        JGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Kristen ITC", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Generador de Hidato");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Kristen ITC", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Filas:");

        jLabel3.setFont(new java.awt.Font("Kristen ITC", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Columnas:");

        jLabel4.setFont(new java.awt.Font("Kristen ITC", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Dificultad:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Kristen ITC", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Kristen ITC", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 102));
        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );

        JGuardar.setFont(new java.awt.Font("Kristen ITC", 1, 12)); // NOI18N
        JGuardar.setForeground(new java.awt.Color(0, 102, 102));
        JGuardar.setText("Guardar");
        JGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(JGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(90, 90, 90)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tiempoInicio = System.currentTimeMillis();
        if (!comprobarCamposVacios()) {
            JOptionPane.showMessageDialog(null, "No puede dejar campos vacios");
            limpiar();
        } else {

            try {

                if (validarTamaño()) {

                    //Obtenemos el tiempo de inicio de la ejecucion en milisegundos
                    random = new Random();
                    filas = jTextField1.getText();
                    columnas = jTextField2.getText();
                    f = Integer.parseInt(filas);
                    c = Integer.parseInt(columnas);
                    tablero = new int[f][c];
                    matrizDeCositas = new JTextField[f][c]; //Se configura el tamaño de la matriz de JTextField
                    jPanel1.setLayout(new GridLayout(f, c)); //Se configura el tamaño del panel respecto al tamaño de nuestra matriz
                    obtenerTamañoCositas(f, c);              //Se obtiene el tamaño de JTextField respecto a la cantidad de estos

                    //Llenado de la matriz tablero de valores -1
                    for (int x = 0; x < tablero.length; x++) {
                        for (int y = 0; y < tablero[x].length; y++) {
                            tablero[x][y] = -1;
                        }
                    }

                    //Generacion de un numero random para decidir en que posicion se comienza el hidato
                    random1 = (int) (Math.random() * f);
                    random2 = (int) (Math.random() * c);

                    tablero[random1][random2] = 1;
                    
                    hidato(random1, random2, 2);

                    primero = 1;
                    ultimo = (f * c);

                    copiaTablero = tablero.clone();

                    //Identificacion del primer y ultimo elemento de la matriz tablero
                    for (int i = 0; i < copiaTablero.length; i++) {
                        for (int j = 0; j < copiaTablero[i].length && decision == false; j++) {
                            if (copiaTablero[i][j] == primero) {
                                primero = copiaTablero[i][j];
                                xp = i;
                                yp = j;
                            }
                            if (copiaTablero[i][j] == ultimo) {
                                ultimo = copiaTablero[i][j];
                                xu = i;
                                yu = j;
                            }
                        }
                    }

                    //Imprimir en consola la matriz original del tablero
                    System.out.println("Matriz original");
                    for (int i = 0; i < tablero.length; i++) {
                        for (int j = 0; j < tablero[i].length; j++) {
                            System.out.print(tablero[i][j] + "\t");
                        }
                        System.out.println();
                    }

                    //Control de pistas en la matriz del Hidato resuelto
                    switch (jComboBox1.getSelectedItem().toString()) {
                        case "1":
                            pistas = (f * c) / 4;

                            for (int i = 0; i < copiaTablero.length && cuentapistas < pistas; i++) {
                                for (int j = 0; j < copiaTablero[i].length && cuentapistas < pistas; j++) {
                                    randomx = (int) (Math.random() * f);
                                    randomy = (int) (Math.random() * c);
                                    if (copiaTablero[randomx][randomy] != primero && copiaTablero[randomx][randomy] != ultimo && copiaTablero[randomx][randomy] != -1) {
                                        copiaTablero[randomx][randomy] = -1;
                                        cuentapistas = cuentapistas + 1;

                                    }
                                    miraEsasPistasPapa = (f * c) - cuentapistas - 2;

                                }
                            }
                            break;
                        case "2":
                            pistas = (f * c) / 2;

                            for (int i = 0; i < copiaTablero.length && cuentapistas < pistas; i++) {
                                for (int j = 0; j < copiaTablero[i].length && cuentapistas < pistas; j++) {
                                    randomx = (int) (Math.random() * f);
                                    randomy = (int) (Math.random() * c);
                                    if (copiaTablero[randomx][randomy] != primero && copiaTablero[randomx][randomy] != ultimo && copiaTablero[i][j] != -1) {
                                        copiaTablero[randomx][randomy] = -1;
                                        cuentapistas = cuentapistas + 1;
                                    }
                                    miraEsasPistasPapa = (f * c) - cuentapistas - 2;
                                }
                            }
                            break;
                        case "3":
                            pistas = (f * c);

                            for (int i = 0; i < copiaTablero.length && cuentapistas < pistas; i++) {
                                for (int j = 0; j < copiaTablero[i].length && cuentapistas < pistas; j++) {
                                    randomx = (int) (Math.random() * f);
                                    randomy = (int) (Math.random() * c);
                                    if (copiaTablero[randomx][randomy] != primero && copiaTablero[randomx][randomy] != ultimo && copiaTablero[randomx][randomy] != -1) {
                                        copiaTablero[randomx][randomy] = -1;
                                        cuentapistas = cuentapistas + 1;
                                    }
                                    miraEsasPistasPapa = (f * c) - cuentapistas - 2;
                                }
                            }
                            break;
                    }

                    System.out.println("Matriz copia");
                    for (int i = 0; i < copiaTablero.length; i++) {
                        for (int j = 0; j < copiaTablero[i].length; j++) {
                            System.out.print(copiaTablero[i][j] + "\t");
                        }
                        System.out.println();
                    }

                    
                    //Llenado de la matriz de JTextFields
                    for (int i = 0; i < f; i++) {        //Recorrido por filas
                        for (int j = 0; j < c; j++) {    //Recorrido por columnas
                            cositaNueva = new JTextField(); //Creacion de un nuevo objeto de la clase JTextField  
                            cositaNueva.setSize(tamX, tamY); //Asignacion de tamaño de los JTextField 
                            cositaNueva.setToolTipText(Integer.toString(i) + "," + Integer.toString(j));  //Conocer la posicion del JTextField al cual le paso el cursos por encima 

                            if (copiaTablero[i][j] != -1) {
                                dentroDeCosita = Integer.toString(copiaTablero[i][j]);
                                cositaNueva.setText(dentroDeCosita); //Asignamos texto con la ubicacion del JTextField
                                cositaNueva.setHorizontalAlignment(SwingConstants.CENTER);
                                cositaNueva.setBackground(Color.CYAN);

                                tripleta = new Tripleta(i, j, copiaTablero[i][j]);
                                tripletas.add(tripleta);
                                System.out.println(tiempo);
                                Archivo.registraTripleta(); //Usamos clase Archivo y a su vez esta escribe en el archivo Tripleta.txt de la carpeta del proyecto

                                if (tablero[i][j] == primero || tablero[i][j] == ultimo) {
                                    cositaNueva.setBackground(Color.red);
                                }
                            } else {
                                dentroDeCosita = null;
                                cositaNueva.setText(dentroDeCosita);
                                cositaNueva.setHorizontalAlignment(SwingConstants.CENTER);

                            }

                            matrizDeCositas[i][j] = cositaNueva; //Agregamos el nuevo JTexfield creado a la matriz
                            jPanel1.add(matrizDeCositas[i][j]); //Añadir y dibujar en panel el nuevo JTextField creado
                            dibujarTablero();
                        }

                    }

                    System.out.println("Primer elemento: " + primero + " en la posicion: (" + xp + "," + yp + ")");
                    System.out.println("Ultimo elemento: " + ultimo + " en la posicion: (" + xu + "," + yu + ")");

                    jButton1.setEnabled(false);
                    
                    tiempoFin = System.currentTimeMillis();  //Obtenemos el tiempo de terminacion de la ejecucion en milisegundos
                    System.out.println("Tiempo fin:" + tiempoFin);
                    tiempo = (double) ((tiempoFin - tiempoInicio) / 1000);
                    System.out.println("Tiempo ejecucion total: " + tiempo);
                    
                }

              
                System.out.println("Tiempo inicio:" + tiempoInicio);
                System.out.println("Numero de pistas: " + miraEsasPistasPapa);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Introduzca datos numericos validos");
                limpiar();

            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        System.exit(0);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void JGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JGuardarActionPerformed

        Guardar_Foto(); //Invocamos evento guardar foto que mostrara una ventana para escoger la ruta y nombre de la imagen
    }//GEN-LAST:event_JGuardarActionPerformed

    public void guardar_imagen(String f) {
        BufferedImage imagen = new BufferedImage(jPanel1.getWidth(), jPanel1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        jPanel1.paint(imagen.getGraphics()); //Aqui creamos una imagen del jPanel(Matriz donde tenemos en Hidato)
        try {                                //Posteriormente se controlan las respectivas excepciones
            ImageIO.write(imagen, "png", new File(f));
            JOptionPane.showMessageDialog(null, "Tu hidato ha sido guardado");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: no se pudo guardar la imagen");
        }
    }

    public void Guardar_Foto() {//Con Guardar_Foto() lo que hacemos basicamente es usar la clase fileChooser para desplegar una ventana 
        String file = null;     //que nos permitira guardar una imagen previamente creada
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile().toString();
            guardar_imagen(file + ".png");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);

            }
        });
    }

    private boolean validarTamaño() {
        boolean validar = false;
        int x, y;
        String dimX, dimY;

        dimX = jTextField1.getText(); //Se obtiene el ancho que debe tener la matriz

        dimY = jTextField2.getText(); //Se obtiene el alto que debe tener la matriz
        x = Integer.parseInt(dimX);    //Conversion a enteros
        y = Integer.parseInt(dimY);    //Conversion a enteros

        if ((x < 51) && (y < 51) && (x > 0) && (y > 0)) {//Dimensiones de la cuadricula deben ser entre 1 y 50
            return true;
        }
        return validar;
    }

    private void obtenerTamañoCositas(int cantX, int cantY) {
        tamX = TABLEROX / cantX; //Tamaño de los JTextField de la Matriz que varia segun las filas y columnas de esta
        tamY = TABLEROY / cantY;
    }

    private void dibujarTablero() {
        jPanel1.validate(); //Se validan los componentes en el panel(tablero)
        jPanel1.repaint();  //Se redibuja el panel

    }

    private void hidato(int x1, int y1, int s) { //Con este algoritmo de backtraking se desarrollara el hidato a partir de una posicion inicial aleatoria

        int x2, y2, k;
        k = -1;
        do {
            k = k + 1;
            x2 = x1 + num[k][0];//Usamos la matriz de num definida al principio para saber donde poner el siguiente numero
            y2 = y1 + num[k][1];
            if (esValido(x2, y2)) { //Evaluamos la valides de las coordenadas segun el metodo esValido()
                tablero[x2][y2] = s; //Siendo asi llenamos esa posicion con el numero que le sigue al anterior

                if (s == ((f * c))) { //El hidato realizara su trabajo hasta que s sea igual al ultimo numero de la matriz
                    termina = true;
                } else {
                    hidato(x2, y2, s + 1);//Si es valido hace una llamada recursiva y aumenta S para rellenar la siguiente posicion con el numero siguiente
                    if (!termina) {
                        tablero[x2][y2] = -1;//En esta condicion nos devolvemos en caso de llegar a un punto muerto en el hidato
                    }                        //Se evaluan el resto de posibilidades hasta encontrar una solucion VALIDA, un ejemplo muy grafico del backtraking
                }
            }
        } while (k < 7 && termina == false);

    }

    private boolean esValido(int x3, int y3) {
        if (x3 > -1 && x3 < f && y3 > -1 && y3 < c && tablero[x3][y3] == -1) {//Sobra explicar cuando es valida una posicion
            return true;//Aunque resaltaremos que es valida si alguna coordenada no es menor que -1 ni mayor que la dimension que esta recorriendo de la matriz
        }               //Y ademas si el dato que va a rellenar es igual a -1 (Inicialmente nuestra matriz ''vacia'' estara llena con -1)
        return false;
    }

    private boolean comprobarCamposVacios() {
        if (jTextField1.getText().equalsIgnoreCase("") || jTextField2.getText().equalsIgnoreCase("")) {
            return false;
        } else {
            return true;
        }
    }

    private void limpiar() {
        jTextField1.setText("");
        jTextField2.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
