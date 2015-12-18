
    import java.awt.Color;
    import javax.swing.ImageIcon;
    import java.io.File;  
    import java.io.FileWriter;
    import java.io.IOException;  
    import java.util.Scanner;
    import org.jsoup.Jsoup;  
    import org.jsoup.nodes.Document;  
    import org.jsoup.nodes.Element;  
    import org.jsoup.select.Elements; 
    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;    
    import java.nio.channels.FileChannel;


/**
 *
 * @author hena
 */
public class FetchCases extends javax.swing.JFrame {
int CF;
   
    public FetchCases() {
        initComponents();
        ImageIcon icon = new ImageIcon(this.getClass().getResource("coding1.jpeg"));
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(Color.DARK_GRAY);
        enter.setEnabled(false);
        download.setEnabled(true);
        this.setTitle("CODEON");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        round = new javax.swing.JTextField();
        enter = new javax.swing.JButton();
        download = new javax.swing.JButton();
        close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(31, 29, 242));
        jLabel1.setText("Enter the round number");

        round.setFont(new java.awt.Font("TlwgTypewriter", 1, 14)); // NOI18N
        round.setForeground(new java.awt.Color(21, 38, 223));

        enter.setFont(new java.awt.Font("TlwgTypewriter", 1, 14)); // NOI18N
        enter.setText("Enter the round");
        enter.setMaximumSize(new java.awt.Dimension(156, 33));
        enter.setMinimumSize(new java.awt.Dimension(156, 33));
        enter.setPreferredSize(new java.awt.Dimension(156, 33));
        enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterActionPerformed(evt);
            }
        });

        download.setFont(new java.awt.Font("TlwgTypewriter", 1, 14)); // NOI18N
        download.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1450433359_Down.png"))); // NOI18N
        download.setText("Download Testcases");
        download.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadActionPerformed(evt);
            }
        });

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1450433401_Delete.png"))); // NOI18N
        close.setToolTipText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(36, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(round, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(download)
                        .addGap(42, 42, 42)
                        .addComponent(enter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(round, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(download))
                .addGap(47, 47, 47)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterActionPerformed
          QuesDisplay q=new QuesDisplay(CF);
          this.hide();
          q.show();
  
    }//GEN-LAST:event_enterActionPerformed

    private void downloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadActionPerformed
        CF=Integer.parseInt(round.getText());
        String url = "http://codeforces.com/contest/"+CF+"/problems";
        Document doc=null;
        
       try{
         // doc = Jsoup.connect(url).get();
        doc = Jsoup.parse(new File("/home/hena/OnlineJudge/Problems-Codeforces1.html"),"utf-8"); 
        
       }
      catch(IOException e)
      {
          e.printStackTrace();
      }
//______________________________________________________________________________________
       //Creating a directory with the name of codeforces round
        File dir=new File(""+CF+"");
        if(dir.exists() && dir.isDirectory())
            System.out.println("Directory already exits.");
        else{
            boolean success=dir.mkdir();
            if(success)
                System.out.println("Successfully created");
            else
                 System.out.println("Not created");
        }

        //____________________________________________________________________________________
       Elements problems=doc.select("div.problemindexholder");
       
        for (Element problem : problems) {  
            String qid = problem.attr("problemindex");  
            File pdir=new File(""+CF+"/"+qid+"");
            boolean suc=pdir.mkdir();
              if(suc)
                 System.out.println("Problem directory created");
              else
                 System.out.println("Problem directory failed");
            System.out.println("Question id:"+qid);  
       //____________________________________________________________________________________________
            
        StringBuilder ques=new StringBuilder();
            Elements questions=problem.getElementsByTag("p");
            for(Element question :questions){
                String que=question.text();
               ques.append(que);
                ques.append("\n");
            }
           
        
        //______________________________________________________________________________________
       //_______________________________________________________________________________________-
                Elements testcases=problem.getElementsByTag("pre");
                int incounter=1;
                   for(Element testcase : testcases){
                
                       String item=testcase.text();
               
                
                     System.out.println("Testcases of problem "+qid+":"+item+"\n");
               
      //_________________________________________________________________________________________
      //Creating files for test cases
                     if(incounter % 2 ==1)
                     {
                         try{
                         File f1=new File(""+CF+"/"+qid+"/in"+(incounter/2)+".txt");
                         f1.createNewFile();
                         FileWriter fw=new FileWriter(f1);
                         fw.write(item);
                         fw.close();
                         ques.append("Input "+(incounter/2)+": \n"+item+"\n\n");
                         }
                         catch(IOException e)
                         {
                             e.printStackTrace();
                         }
                     }
                     else
                     {
                         try{
                          File f2=new File(""+CF+"/"+qid+"/out"+((incounter/2)-1)+".txt");
                         f2.createNewFile();
                         FileWriter fw1=new FileWriter(f2);
                         fw1.write(item);
                         fw1.close();
                         ques.append("Output "+((incounter/2)-1)+": \n"+item+"\n\n");
                         }
                         catch(IOException e)
                         {
                             e.printStackTrace();
                         }
                     }
                     incounter++;
                 }
      //____________________________________________________________________________________________
          try{
             File f=new File(""+CF+"/"+qid+"/ques.txt");
                f.createNewFile();
                FileWriter fw = new FileWriter(f);
                    fw.write(ques.toString());
                    fw.close();
           }
           catch(IOException e){}
        }
        enter.setEnabled(true);
    }//GEN-LAST:event_downloadActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException  {
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
            java.util.logging.Logger.getLogger(FetchCases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FetchCases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FetchCases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FetchCases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 
          
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FetchCases().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JButton download;
    private javax.swing.JButton enter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField round;
    // End of variables declaration//GEN-END:variables
}
