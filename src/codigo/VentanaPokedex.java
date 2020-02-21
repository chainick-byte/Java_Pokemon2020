/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author xp
 */
public class VentanaPokedex extends javax.swing.JFrame {

    BufferedImage buffer = null;
    Image imagen1 = null;
    Image pokedex_consola = null;
    int slide = 0;

    //variables que conectan mySQL con java
    Statement estado;
    ResultSet resultadoConculta;
    Connection conexion;
    Clip boton = null;

    //declaramos hashmap, donde guardamos tod el contenido de la BB DD
    HashMap<String, Pokemon> listaPokemons = new HashMap();

    @Override
    public void paint(Graphics g) {

        super.paintComponents(g);

        Graphics2D g2 = (Graphics2D) imagenPokemon.getGraphics();
        g2.drawImage(buffer, 0, 0, imagenPokemon.getWidth(),
                imagenPokemon.getHeight(), null);

    }

    /**
     * Creates new form VentanaPokedex
     */
    public VentanaPokedex() {
        initComponents();
        setSize(950, 750);
        this.getContentPane().setBackground(Color.red);

        try {
            imagen1 = ImageIO.read(getClass().getResource("/imagenes/black-white.png"));
        } catch (IOException ex) {
            Logger.getLogger(VentanaPokedex.class.getName()).log(Level.SEVERE, null, ex);
        }
        //asi hacemos que se dibujen pokemones en jpanel
        buffer = (BufferedImage) imagenPokemon.createImage(imagenPokemon.getWidth(),
                imagenPokemon.getHeight());

        Graphics2D g2 = buffer.createGraphics();
        dibujaElPokemonQueEstaEnLaPOsicion(slide);
        //conectamos la mysql con jaba
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://192.168.182.140/pokemon", "root", "");
            estado = conexion.createStatement();
            resultadoConculta = estado.executeQuery("Select * from pokemon");
            //recorremos el array del resultado uno a uno ,para ir 
            //cargandolo a hashmap
            while (resultadoConculta.next()) {
                Pokemon p = new Pokemon();
                p.nombre = resultadoConculta.getString(2);
                p.especie = resultadoConculta.getString(5);
                p.peso = resultadoConculta.getString(4);
                p.altura = resultadoConculta.getString(3);
                p.movimiento1 = resultadoConculta.getString(10);
                p.descripcion = resultadoConculta.getString(16);
                p.habitat = resultadoConculta.getString(6);
                p.especie = resultadoConculta.getString(5);
                p.tipo1 = resultadoConculta.getString(7);
                p.tipo2 = resultadoConculta.getString(8);
                p.movimiento1 = resultadoConculta.getString(10);
                p.movimiento2 = resultadoConculta.getString(11);
                p.movimiento3 = resultadoConculta.getString(12);
                p.movimiento4 = resultadoConculta.getString(13);
                listaPokemons.put(resultadoConculta.getString(1), p);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Paso por catch");

        }

    }

    private void dibujaElPokemonQueEstaEnLaPOsicion(int posicion) {
        int fila = posicion / 31;
        int columna = posicion % 31;
        Graphics2D g2 = (Graphics2D) buffer.createGraphics();
        g2.setColor(Color.black);
        //pinta el fondo de jpanel de negro 
        g2.fillRect(0, 0, imagenPokemon.getWidth(), imagenPokemon.getHeight());
        g2.drawImage(imagen1, 0, 0, imagenPokemon.getWidth(),
                imagenPokemon.getHeight(),
                columna * 96,
                fila * 96,
                columna * 96 + 96,
                fila * 96 + 96, null);
        repaint();
    }

    private void boton() {
        try {
            boton = AudioSystem.getClip();
            boton.open(AudioSystem.getAudioInputStream(getClass().getResource("/Sonido/button-3.wav")));
        } catch (Exception ex) {
            Logger.getLogger(VentanaPokedex.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("sonido ha petado");

        }
        boton.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        NombrePokemon = new javax.swing.JLabel();
        Descripcion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        Altura = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Peso = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Habitat = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Especie = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Tipo1 = new javax.swing.JLabel();
        Tipo2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Movimiento1 = new javax.swing.JLabel();
        Movimiento2 = new javax.swing.JLabel();
        Movimiento3 = new javax.swing.JLabel();
        Movimiento4 = new javax.swing.JLabel();
        imagenPokemon = new javax.swing.JLabel();
        imagenPokemon1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(getBackground());
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        jButton1.setText("<");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(120, 490, 41, 25);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setText(">");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(false);
        jButton2.setRequestFocusEnabled(false);
        jButton2.setRolloverEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(200, 490, 41, 25);

        NombrePokemon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(NombrePokemon);
        NombrePokemon.setBounds(300, 400, 229, 30);

        Descripcion.setBackground(new java.awt.Color(255, 123, 97));
        Descripcion.setColumns(20);
        Descripcion.setRows(5);
        Descripcion.setOpaque(false);
        getContentPane().add(Descripcion);
        Descripcion.setBounds(270, 424, 300, 90);

        jLabel1.setText("Altura:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 510, 39, 32);
        getContentPane().add(Altura);
        Altura.setBounds(310, 510, 39, 30);

        jLabel2.setText("Peso:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(270, 540, 39, 20);
        getContentPane().add(Peso);
        Peso.setBounds(310, 540, 39, 20);

        jLabel3.setText("Habitat:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(270, 560, 55, 25);
        getContentPane().add(Habitat);
        Habitat.setBounds(320, 560, 70, 25);

        jLabel4.setText("Especie:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(270, 590, 55, 25);
        getContentPane().add(Especie);
        Especie.setBounds(330, 590, 91, 25);

        jLabel5.setText("Tipos:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(410, 510, 40, 20);
        getContentPane().add(Tipo1);
        Tipo1.setBounds(450, 510, 56, 20);
        getContentPane().add(Tipo2);
        Tipo2.setBounds(510, 510, 60, 20);

        jLabel6.setText("Movimientos:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(410, 540, 76, 16);
        getContentPane().add(Movimiento1);
        Movimiento1.setBounds(490, 540, 83, 20);
        getContentPane().add(Movimiento2);
        Movimiento2.setBounds(490, 560, 83, 20);
        getContentPane().add(Movimiento3);
        Movimiento3.setBounds(490, 580, 84, 20);
        getContentPane().add(Movimiento4);
        Movimiento4.setBounds(490, 600, 82, 20);
        getContentPane().add(imagenPokemon);
        imagenPokemon.setBounds(260, 50, 320, 260);

        imagenPokemon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pokedex_consola.png"))); // NOI18N
        getContentPane().add(imagenPokemon1);
        imagenPokemon1.setBounds(0, 0, 890, 680);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (slide < 152) {
            slide++;
        }
        dibujaElPokemonQueEstaEnLaPOsicion(slide);
        Pokemon p = listaPokemons.get(String.valueOf(slide + 1));

        if (p != null) {
            NombrePokemon.setText(p.nombre);
            Descripcion.setLineWrap(true);
            Descripcion.setText(p.descripcion);
            Altura.setText(p.altura);
            Peso.setText(p.peso);
            Habitat.setText(p.habitat);
            Especie.setText(p.especie);
            Tipo1.setText(p.tipo1);
            Tipo2.setText(p.tipo2);
            Movimiento1.setText(p.movimiento1);
            Movimiento2.setText(p.movimiento2);
            Movimiento3.setText(p.movimiento3);
            Movimiento4.setText(p.movimiento4);

        } else {
            NombrePokemon.setText("No hay datos...");
            NombrePokemon.setText("No hay datos...");
            Descripcion.setText("...");
            Altura.setText("...");
            Peso.setText("...");
            Habitat.setText("...");
            Especie.setText("...");
            Tipo1.setText("...");
            Tipo2.setText("...");
            Movimiento1.setText("...");
            Movimiento2.setText("...");
            Movimiento3.setText("...");
            Movimiento4.setText("...");
        }
     
        boton();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (slide > 0) {
            slide --;
        }
        dibujaElPokemonQueEstaEnLaPOsicion(slide);
        Pokemon p = listaPokemons.get(String.valueOf(slide + 1));

        if (p != null) {
            NombrePokemon.setText(p.nombre);
            Descripcion.setLineWrap(true);
            Descripcion.setText(p.descripcion);
            Altura.setText(p.altura);
            Peso.setText(p.peso);
            Habitat.setText(p.habitat);
            Especie.setText(p.especie);
            Tipo1.setText(p.tipo1);
            Tipo2.setText(p.tipo2);
            Movimiento1.setText(p.movimiento1);
            Movimiento2.setText(p.movimiento2);
            Movimiento3.setText(p.movimiento3);
            Movimiento4.setText(p.movimiento4);

        } else {
            NombrePokemon.setText("No hay datos...");
            Descripcion.setText("...");
            Altura.setText("...");
            Peso.setText("...");
            Habitat.setText("...");
            Especie.setText("...");
            Tipo1.setText("...");
            Tipo2.setText("...");
            Movimiento1.setText("...");
            Movimiento2.setText("...");
            Movimiento3.setText("...");
            Movimiento4.setText("...");
        }
       
        boton();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Altura;
    private javax.swing.JTextArea Descripcion;
    private javax.swing.JLabel Especie;
    private javax.swing.JLabel Habitat;
    private javax.swing.JLabel Movimiento1;
    private javax.swing.JLabel Movimiento2;
    private javax.swing.JLabel Movimiento3;
    private javax.swing.JLabel Movimiento4;
    private javax.swing.JLabel NombrePokemon;
    private javax.swing.JLabel Peso;
    private javax.swing.JLabel Tipo1;
    private javax.swing.JLabel Tipo2;
    private javax.swing.JLabel imagenPokemon;
    private javax.swing.JLabel imagenPokemon1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
