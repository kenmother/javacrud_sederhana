/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihancruddesktop.ui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import latihancruddesktop.ui.master.MasterPeserta;
import latihancruddesktop.ui.master.MasterKelas;

/**
 *
 * @author KENDAY
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    
    public MainMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTabbedPane = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnItemEntriPeserta = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainTabbedPane.setBackground(new java.awt.Color(87, 170, 254));

        jMenuBar1.setBackground(new java.awt.Color(0, 255, 255));

        mnItemEntriPeserta.setText("Daftar");

        jMenuItem1.setText("Entri Peserta");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnItemEntriPeserta.add(jMenuItem1);

        jMenuItem2.setText("Entri Kelas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnItemEntriPeserta.add(jMenuItem2);

        jMenuBar1.add(mnItemEntriPeserta);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       MasterPeserta.getPanel().setName(MasterPeserta.PANEL_NAME);
         indexTab = getComponentIndexByName(MasterPeserta.PANEL_NAME);
         if (indexTab == -1) {
             mainTabbedPane.addTab(MasterPeserta.PANEL_NAME, MasterPeserta.getPanel());
             setSelectedPanel(MasterPeserta.PANEL_NAME);
         }else{
             mainTabbedPane.setSelectedIndex(indexTab);
         }
         
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
          
        MasterKelas.getPanel().setName(MasterKelas.PANEL_NAME);
         indexTab = getComponentIndexByName(MasterKelas.PANEL_NAME);
         if (indexTab == -1) {
             mainTabbedPane.addTab(MasterKelas.PANEL_NAME, MasterKelas.getPanel());
             setSelectedPanel(MasterKelas.PANEL_NAME);
         }else{
             mainTabbedPane.setSelectedIndex(indexTab);
         }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
private List<JMenu> menus;
private List<JMenuItem> menuItems;
private Integer indexTab = -1;

public MainMenu(JMenu mnFile, JMenu mnMaster) {
    
    initComponents();
    menus = new ArrayList<JMenu>();
    menuItems = new ArrayList<JMenuItem>();
    menus.add(mnFile);
    menus.add(mnMaster);
    menuItems.add(mnItemEntriPeserta);
    setExtendedState(MAXIMIZED_BOTH);
    
}

public JTabbedPane getMainTabbedPane() {
return mainTabbedPane;
}

private int getComponentIndexByName(String panelName) {
return mainTabbedPane.indexOfTab(panelName);
}

private void setSelectedPanel(String panelName) {
mainTabbedPane.setSelectedComponent(mainTabbedPane.
getComponentAt(getComponentIndexByName(panelName)));
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JMenu mnItemEntriPeserta;
    // End of variables declaration//GEN-END:variables
}
