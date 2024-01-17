/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


package codefornature;
import java.awt.Desktop;
import java.net.URL;
import java.net.URISyntaxException;
import javax.swing.table.DefaultTableModel;

import java.text.ParseException;
import javax.swing.JFrame;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.JTextArea;
import java.io.IOException;
import java.net.URI;


public class DisplayNews extends javax.swing.JFrame {
     private List<NewsFilter.NewsArticle> fileNewsList ;
     private final NewsSection NewsFrame ;
    
    public DisplayNews(List<NewsFilter.NewsArticle> fileNewsList, NewsSection NewsFrame) {
        initComponents();
        this.fileNewsList = fileNewsList;
        this.NewsFrame = NewsFrame;
        populateTable();
        
        
    }
    
   
     
                                      


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        RealNews = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("TOP 5 NEWS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 410, 100));

        RealNews.setBackground(new java.awt.Color(255, 255, 204));
        RealNews.setFont(new java.awt.Font("Rockwell", 3, 24)); // NOI18N
        RealNews.setForeground(new java.awt.Color(0, 0, 0));
        RealNews.setText("MORE");
        RealNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RealNewsActionPerformed(evt);
            }
        });
        getContentPane().add(RealNews, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 690, 140, 60));

        Back.setBackground(new java.awt.Color(255, 255, 255));
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setIcon(new javax.swing.ImageIcon("C:\\Users\\SCSM11\\Downloads\\back.jpg")); // NOI18N
        Back.setText("jButton1");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 100));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 102, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title", "URL", "DATE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(200);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Title");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("URL");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("DATE");
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 550, 330));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\SCSM11\\Downloads\\news2.0.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 986, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RealNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RealNewsActionPerformed
         try {
        Api api = new Api();  
        List<NewsFilter.NewsArticle> apiNewsList = api.getNewsNature();  

       
        Real jframe = new Real(apiNewsList);
        jframe.setVisible(true);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
    } catch (IOException e) {
        e.printStackTrace();
   
    }
    }//GEN-LAST:event_RealNewsActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        this.NewsFrame.setVisible(true);
        NewsFrame.pack();
        NewsFrame.setLocationRelativeTo(null);
        this.dispose();    
    }//GEN-LAST:event_BackActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.rowAtPoint(evt.getPoint());
        int col = jTable1.columnAtPoint(evt.getPoint());
        if (col == 1) { 
            String url = (String) jTable1.getValueAt(row, col);
            openUrlInBrowser(url);
        }
    }//GEN-LAST:event_jTable1MouseClicked
 private void openUrlInBrowser(String url) {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                System.err.println("Error opening URL: " + url);
                e.printStackTrace();
            }
        } else {
            System.err.println("Desktop browsing not supported, cannot open URL: " + url);
        }
    }
 private void populateTable() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); 

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);

    for (NewsFilter.NewsArticle news : fileNewsList) {
        model.addRow(new Object[]{news.title, createClickableLink(news.url), dateFormat.format(news.date)});
    }
}

private String createClickableLink(String url) {
    return url;
}
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton RealNews;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
