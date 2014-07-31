/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shama H
 */
import java.io.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;

public class Graph extends JPanel{

  static double prices[]={75,80,100,115,124,137,168,178,180,190,210,234,267,310};
 DataOutputStream data_out;
 FileOutputStream file_output;
 String fileName, Title;
 double TempArray[];
 Font font1=new Font("Consolas", Font.PLAIN, 12);
 Font font2=new Font("Consolas", Font.BOLD, 16);

    Graph(String fileName, String Title){
       this.fileName=fileName;
       this.setOpaque(false);
       this.Title=Title;

       
    }
    public void setStream(){
        try{
           File file = new File (fileName);
           file_output = new FileOutputStream (file);
           data_out = new DataOutputStream (file_output);
       }catch(Exception e){}
    }
    public void MakeFile(double value, boolean f){

    try {
         data_out.writeDouble (value);

          if(f){
      file_output.close ();
        }
    }
    catch (IOException e) {
       e.printStackTrace() ;
    }

    }
    public int getTime(){
        File file = null;
        file = new File (fileName);
        int length=1;
        try {

      FileInputStream file_input = new FileInputStream (file);
      DataInputStream data_in    = new DataInputStream (file_input );

      while (true) {
        try {
            data_in.readDouble();
            System.out.println(length++);
        }
        catch (EOFException eof) {
          //System.out.println ("End of File");
          break;
        }
        }
      data_in.close ();
    } catch  (IOException e) {
       System.out.println ( "IO Exception =: " + e );
    }

    return length-2;
    }

    public void setTemperatureArray(){
        File file = null;
        file = new File (fileName);
        int length=getTime();
        TempArray=new double[length];
        try {

      FileInputStream file_input = new FileInputStream (file);
      DataInputStream data_in    = new DataInputStream (file_input );

      for(int i=0;i<length;i++){

            TempArray[i]=data_in.readDouble();
        }
      data_in.close ();
    } catch  (IOException e) {
       System.out.println ( "IO Exception =: " + e );
    }

   
    }

        protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(font1);
        int w = getWidth();
        int h = getHeight();
        // Draw ordinate.
        g2.draw(new Line2D.Double(20, 5, 20, h-20));
        g2.draw(new Line2D.Double(20, 5, 20, h-20));
        // Draw abcissa.
        g2.draw(new Line2D.Double(20, h-20, w-20, h-20));
        g2.draw(new Line2D.Double(20, h-20, w-20, h-20));


        // Draw lines.
        double xInc = (double)(w - 2*20)/(TempArray.length-1);
        double scale = (double)(h - 25)/getMax();
        g2.setPaint(Color.green.darker());
        for(int i = 0; i < TempArray.length-1; i++) {
            double x1 = 20 + i*xInc;
            double y1 = h - 20 - scale*TempArray[i];
            double x2 = 20 + (i+1)*xInc;
            double y2 = h - 20 - scale*TempArray[i+1];
            g2.draw(new Line2D.Double(x1, y1, x2, y2));
            g2.draw(new Line2D.Double(x1, y1, x2, y2));
            g2.draw(new Line2D.Double(x1, y1, x2, y2));
        }
        //label axes
        g2.setPaint(Color.blue);
        float t=20, T=h-19;
        String str="0";
        String str1="0";
        for(int i=1;i<=TempArray.length;i++){
            g2.drawString(str,t,h-8);
            t=(float)(t+xInc*5);
            str=""+i*5;
        }
        for(int i=1;i<getMax();i++){
            g2.drawString(str1, 0, T);
            T=(float)(T-scale*30);
            str1=""+i*30;
        }
        // Mark data points.
        g2.setPaint(Color.red);
        for(int i = 0; i < TempArray.length; i++) {
            double x = 20+ i*xInc;
            double y = h - 20 - scale*TempArray[i];
            g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
        }
        g2.drawString("time (s)",w-60,h-25);
        g2.drawString("temperature (F)",30,20);
        g2.setPaint(Color.ORANGE.darker());
        g2.setFont(font2);
        g2.drawString(Title,50,h-40);

    }

    private double getMax() {
        double max = -Double.MAX_VALUE;
        for(int i = 0; i < TempArray.length; i++) {
            if(TempArray[i] > max)
                max = TempArray[i];
        }
        return max;
    }


}
