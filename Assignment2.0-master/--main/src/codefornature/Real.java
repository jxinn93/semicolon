/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package codefornature;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.io.IOException;
import java.awt.Desktop;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.net.URI;
import java.net.URISyntaxException;
public class Real extends javax.swing.JFrame {
    private List<NewsFilter.NewsArticle> apiNewsList;
    /**
     * Creates new form Real
     */
    public Real(List<NewsFilter.NewsArticle> apiNewsList) {
         this.apiNewsList = apiNewsList;
        initComponents();
        displayApiNews();
    }

     private void displayApiNews(){
        StringBuilder apiNewsText = new StringBuilder();
        
        if(apiNewsList != null && !apiNewsList.isEmpty()){
            apiNewsText.append("<html>");
        for(NewsFilter.NewsArticle news : apiNewsList){
             apiNewsText.append("<b>").append(news.title).append("</b><br>")
                    .append("<a href=\"").append(news.url).append("\">").append(news.url).append("</a><br>")
                    .append(new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).format(news.date)).append("<br><br>");
        }
        apiNewsText.append("</html>");
        setNewsText(apiNewsText.toString());
        }else {
           System.out.println("API NewsList is null or empty. Cannot display news");
                }
    }
        
   public void setNewsText(String newsText){
      DisplayNews.setContentType("text/html");
      DisplayNews.setEditable(false);
      DisplayNews.setText(newsText);
      DisplayNews.addHyperlinkListener(new HyperlinkListener(){
        @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    openUrlInBrowser(e.getURL().toString());
                }
            }
        });
   
     
   }
   private void openUrlInBrowser(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DisplayNews = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Real News");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 410, 110));

        DisplayNews.setEditable(false);
        DisplayNews.setBackground(new java.awt.Color(255, 255, 204));
        DisplayNews.setFont(new java.awt.Font("Segoe UI Historic", 3, 36)); // NOI18N
        DisplayNews.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                DisplayNewsHyperlinkUpdate(evt);
            }
        });
        jScrollPane2.setViewportView(DisplayNews);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 560, 420));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\SCSM11\\Downloads\\back.jpg")); // NOI18N
        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\SCSM11\\Downloads\\news2.0.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void DisplayNewsHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_DisplayNewsHyperlinkUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_DisplayNewsHyperlinkUpdate

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
            java.util.logging.Logger.getLogger(Real.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Real.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Real.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Real.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            try{
                    Api api = new Api();
                    List<NewsFilter.NewsArticle> apiNewsList = api.getNewsNature();
                
                new Real(apiNewsList).setVisible(true);
            } catch(IOException e){
              e.printStackTrace();
            } 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane DisplayNews;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
