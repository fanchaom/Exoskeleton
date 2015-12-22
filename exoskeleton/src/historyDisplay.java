
import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author Randy Meng
 * last update date 204-06-20
 */
public class historyDisplay extends javax.swing.JFrame {

    //variables for connection to database
    Connection dbcon=null;
    Statement stmt=null;
    ResultSet rs=null;
    String dbName = "exoskeletondatabase?";
    String username="root";
    String password="Mengfanchao1124";
    String url = "jdbc:mysql://localhost:3306/"+dbName;
    
    int buttonSelect=0;
    
    public historyDisplay() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        graphDisplayButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        AVdisplayButton = new javax.swing.JButton();
        TdisplayButton = new javax.swing.JButton();
        MCdisplayButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("EXOSKELETON #1");

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Record Date", "Data Value"
            }
        ));
        jScrollPane1.setViewportView(displayTable);

        graphDisplayButton.setText("Graph View");
        graphDisplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphDisplayButtonActionPerformed(evt);
            }
        });

        BackButton.setText("BACK");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Value Selection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153))); // NOI18N

        AVdisplayButton.setText("Angle Value");
        AVdisplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AVdisplayButtonActionPerformed(evt);
            }
        });

        TdisplayButton.setText("% max torque");
        TdisplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TdisplayButtonActionPerformed(evt);
            }
        });

        MCdisplayButton.setText("Motor Current");
        MCdisplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MCdisplayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TdisplayButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AVdisplayButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MCdisplayButton, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AVdisplayButton)
                .addGap(18, 18, 18)
                .addComponent(MCdisplayButton)
                .addGap(18, 18, 18)
                .addComponent(TdisplayButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(391, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(graphDisplayButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BackButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(graphDisplayButton)
                    .addComponent(BackButton))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AVdisplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AVdisplayButtonActionPerformed
        // display the angle values stored in databse
        buttonSelect=1;
        DefaultTableModel model = (DefaultTableModel) displayTable.getModel();
        model.getDataVector().removeAllElements();
        
        //access databse and get the angle values data
        try{
            dbcon = getConnection(url, username, password);
            stmt = dbcon.createStatement();
            rs = stmt.executeQuery("SELECT recordTime, angleValue FROM data_exoskeleton");
        
            while(rs.next())
            {
                Object[] row={rs.getTimestamp("recordTime"), rs.getFloat("angleValue")}; 
                model.addRow(row);
            }
        }catch(SQLException se)
        {
             JOptionPane.showMessageDialog(this, "Unable to connect to CSIL SQL server. Please contact SFU helpdesk. Error message: " + se.getMessage());
        }
        finally
        {
            try{dbcon.close();} catch (SQLException ignore){}
            try{stmt.close();} catch (SQLException ignore){}
        }   
    }//GEN-LAST:event_AVdisplayButtonActionPerformed

    private void MCdisplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MCdisplayButtonActionPerformed
        
        buttonSelect=2;
        DefaultTableModel model =  (DefaultTableModel) displayTable.getModel(); 
        model.getDataVector().removeAllElements();
        
        try{
            dbcon = getConnection(url, username, password);
            stmt = dbcon.createStatement();
            rs = stmt.executeQuery("SELECT recordTime, motorCurrent FROM data_exoskeleton");
        
            while(rs.next())
            {
                Object[] row={rs.getTimestamp("recordTime"), rs.getFloat("motorCurrent")};
                model.addRow(row);
            }
        }catch(SQLException se)
        {
             JOptionPane.showMessageDialog(this, "Unable to connect to CSIL SQL server. Please contact SFU helpdesk. Error message: " + se.getMessage());
        }
        finally
        {
            try{dbcon.close();} catch (SQLException ignore){}
            try{stmt.close();} catch (SQLException ignore){}
        }
    }//GEN-LAST:event_MCdisplayButtonActionPerformed

    private void TdisplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TdisplayButtonActionPerformed
        
        buttonSelect=3;
        DefaultTableModel model =  (DefaultTableModel) displayTable.getModel(); 
        model.getDataVector().removeAllElements();
        
        try{
            dbcon = getConnection(url, username, password);
            stmt = dbcon.createStatement();
            rs = stmt.executeQuery("SELECT recordTime, percentageoftorque FROM data_exoskeleton");
        
            while(rs.next())
            {
                Object[] row={rs.getTimestamp("recordTime"), rs.getFloat("percentageoftorque")};   
                model.addRow(row);
            }
        }catch(SQLException se)
        {
             JOptionPane.showMessageDialog(this, "Unable to connect to CSIL SQL server. Please contact SFU helpdesk. Error message: " + se.getMessage());
        }
        finally
        {
            try{dbcon.close();} catch (SQLException ignore){}
            try{stmt.close();} catch (SQLException ignore){}
        }
    }//GEN-LAST:event_TdisplayButtonActionPerformed

    private void graphDisplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphDisplayButtonActionPerformed

        String q="";
        String title="";
        
        try{   
            dbcon = getConnection(url, username, password);
            
            //display the axes lable based on which data user wants to check
            if(buttonSelect==0)
                JOptionPane.showMessageDialog(this, "You don't choose the which graph you want to create");
            else if (buttonSelect==1)
            {
                q = "SELECT recordTime, angleValue FROM data_exoskeleton"; 
                title="Angle Value";
            }
            else if (buttonSelect==2)
            {
                q = "SELECT recordTime, motorCurrent FROM data_exoskeleton"; 
                title="Motor Current";
            }
            else
            {
                q = "SELECT recordTime, percentageoftorque FROM data_exoskeleton"; 
                title="% of Max Torque";
            }
            
            //draw the graph then
            JDBCCategoryDataset  d = new JDBCCategoryDataset(dbcon);
            d.executeQuery(q);
            JFreeChart chart = ChartFactory.createLineChart(title, "time", "value", d,PlotOrientation.VERTICAL, true, true, false);
            //set the graph original size
            ChartFrame frame = new ChartFrame(title,chart);
            frame.setVisible(true);
            frame.setSize(600, 450);    
        }catch(SQLException se)
        {
             JOptionPane.showMessageDialog(this, "Unable to connect to CSIL SQL server. Please contact SFU helpdesk. Error message: " + se.getMessage());
        }
    }//GEN-LAST:event_graphDisplayButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed

        currentPosition cp=new currentPosition();
        cp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackButtonActionPerformed

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
            java.util.logging.Logger.getLogger(historyDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(historyDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(historyDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(historyDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new historyDisplay().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AVdisplayButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton MCdisplayButton;
    private javax.swing.JButton TdisplayButton;
    private javax.swing.JTable displayTable;
    private javax.swing.JButton graphDisplayButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
