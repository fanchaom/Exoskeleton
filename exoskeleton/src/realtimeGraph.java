
import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.DynamicTimeSeriesCollection;
import org.jfree.data.time.Second;

//create a class named "realtimeGraph" which deal with the data and acess to the database for the real-time graphing
public class realtimeGraph extends JPanel{
    
    private final DynamicTimeSeriesCollection dataset;
    private final JFreeChart chart;
    
    Connection dbcon=null;
    Statement stmt=null;
    ResultSet rs=null;
    String dbName = "exoskeletondatabase?";
    String username="root";
    String password="Mengfanchao1124";
    String url = "jdbc:mysql://localhost:3306/"+dbName;
    
    public realtimeGraph(String Title){

        dataset = new DynamicTimeSeriesCollection(1, 10, new Second());
        dataset.setTimeBase(new Second(0, 0, 0, 23, 1, 2014));
        dataset.addSeries(new float[100], 0, "1");
        chart = ChartFactory.createTimeSeriesChart(
            Title, "Time", Title, dataset, true, true, false);
        final XYPlot plot = chart.getXYPlot();
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setFixedAutoRange(10000);
        axis.setDateFormatOverride(new SimpleDateFormat("ss.SS"));
        final ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel);   
    }
    
     public void update(float value,int type) throws SQLException {
        if(type==1){
         try{
            dbcon = getConnection(url, username, password);
            stmt = dbcon.createStatement();
            rs = stmt.executeQuery("SELECT recordTime, angleValue FROM data_exoskeleton");
        
            
        }catch(SQLException se)
        {
             JOptionPane.showMessageDialog(this, "Unable to connect to CSIL SQL server. Please contact SFU helpdesk. Error message: " + se.getMessage());
        }
        float[] newData = new float[1];
        while(rs.next())
            {
                newData[0]=rs.getFloat("angleValue");
                //model.addRow(row);
            }
        //newData[0] = value;
        dataset.advanceTime();
        dataset.appendData(newData);
    }
     
     if(type==2){
         try{
            dbcon = getConnection(url, username, password);
            stmt = dbcon.createStatement();
            rs = stmt.executeQuery("SELECT recordTime, motorCurrent FROM data_exoskeleton");
        
            
        }catch(SQLException se)
        {
             JOptionPane.showMessageDialog(this, "Unable to connect to CSIL SQL server. Please contact SFU helpdesk. Error message: " + se.getMessage());
        }
        float[] newData = new float[1];
        while(rs.next())
            {
                newData[0]=rs.getFloat("motorCurrent");
                //model.addRow(row);
            }
        //newData[0] = value;
        dataset.advanceTime();
        dataset.appendData(newData);
    }
     
     if(type==3){
         try{
            dbcon = getConnection(url, username, password);
            stmt = dbcon.createStatement();
            rs = stmt.executeQuery("SELECT recordTime, percentageoftorque FROM data_exoskeleton");
        
            
        }catch(SQLException se)
        {
             JOptionPane.showMessageDialog(this, "Unable to connect to CSIL SQL server. Please contact SFU helpdesk. Error message: " + se.getMessage());
        }
        float[] newData = new float[1];
        while(rs.next())
            {
                newData[0]=rs.getFloat("percentageoftorque");
                //model.addRow(row);
            }
        //newData[0] = value;
        dataset.advanceTime();
        dataset.appendData(newData);
    }
     }
}

