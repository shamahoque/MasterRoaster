/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shama H
 */
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.imageio.ImageIO;
import java.awt.RenderingHints;
import javax.swing.*;
import MasterRoaster.Process.*;
import MasterRoaster.Equipment.*;
import MasterRoaster.Material.*;
import MasterRoaster.Calculations.*;
import java.util.List;


public class StartRoasting extends SwingWorker<Void, BufferedImage>{
    RDRoaster equip;
    BeanLot bean;
    CalculateTemp ca;
    CalculateEmissions ce;
    double rt, ta, temperature=70, thresholdHigh, thresholdLow,Tb;
     double totalSteps=68;

     BufferedImage image1 = null;
        BufferedImage image2 = null;
        BufferedImage image3 = null;
        BufferedImage image4 = null;
        BufferedImage image5 = null;
        BufferedImage image6 = null;
        BufferedImage image7 = null;
        BufferedImage image8 = null;
        BufferedImage image9 = null;
        BufferedImage image10 = null;
        BufferedImage image11 = null;
        BufferedImage image12 = null;
        BufferedImage image13 = null;
        BufferedImage image14 = null;
        BufferedImage image15 = null;
        BufferedImage image16 = null;
        BufferedImage fromImage;
    BufferedImage toImage;
     BufferedImage morphImage;
        ImageIcon animeIcon;
        boolean inProgress, halt;
        int height, width;
        JLabel anime,currentTime,currentTempb, currentTempa;
        JButton start, stop, pause, resume,generate;
        int i=0;
        JSlider heat;
        Graph TaGraph, TbGraph;
        JTextArea calcArea;
        boolean show;
        JCheckBox showCalc;
        boolean stopcheck;

    WritableRaster morphRaster;
    int [][][] array1;
    int [][][] array2;

    StartRoasting(JLabel anime, JLabel currentTime, JLabel currentTempb, JLabel currentTempa,JButton start,
            JButton stop, JButton pause, JButton resume,JButton generate, JSlider heat, Graph TaGraph, 
            Graph TbGraph,JTextArea calcArea,boolean show, JCheckBox showCalc){
        this.anime=anime;
        this.currentTime=currentTime;
        this.currentTempb=currentTempb;
        this.currentTempa=currentTempa;
        this.start=start;
        this.stop=stop;
        this.pause=pause;
        this.generate=generate;
        this.heat=heat;
        this.resume=resume;
        this.TaGraph=TaGraph;
        this.TbGraph=TbGraph;
        this.calcArea=calcArea;
        this.show=show;
        this.showCalc=showCalc;
        showCalc.setEnabled(false);
        i=0;
        try{
            image1=ImageIO.read(StartRoasting.class.getResource("images/smaller/1.jpg"));
            image2=ImageIO.read(StartRoasting.class.getResource("images/smaller/2.jpg"));
            image3=ImageIO.read(StartRoasting.class.getResource("images/smaller/3.jpg"));
            image4=ImageIO.read(StartRoasting.class.getResource("images/smaller/4.jpg"));
            image5=ImageIO.read(StartRoasting.class.getResource("images/smaller/5.jpg"));
            image6=ImageIO.read(StartRoasting.class.getResource("images/smaller/6.jpg"));
            image7=ImageIO.read(StartRoasting.class.getResource("images/smaller/7.jpg"));
            image8=ImageIO.read(StartRoasting.class.getResource("images/smaller/8.jpg"));
            image9=ImageIO.read(StartRoasting.class.getResource("images/smaller/9.jpg"));
            image10=ImageIO.read(StartRoasting.class.getResource("images/smaller/10.jpg"));
            image11=ImageIO.read(StartRoasting.class.getResource("images/smaller/11.jpg"));
            image12=ImageIO.read(StartRoasting.class.getResource("images/smaller/12.jpg"));
            image13=ImageIO.read(StartRoasting.class.getResource("images/smaller/13.jpg"));
            image14=ImageIO.read(StartRoasting.class.getResource("images/smaller/14.jpg"));
            image15=ImageIO.read(StartRoasting.class.getResource("images/smaller/15.jpg"));
            image16=ImageIO.read(StartRoasting.class.getResource("images/smaller/16.jpg"));
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("haha");
        }


    }
    
    public void SelectInput(FixedInput fi, int selectedEquip, int selectedBean, double rt, double ta){
     RoastingProcess  rp = new RoastingProcess();
            rp.setGas(fi.createG());
            this.rt=rt;
            this.ta=ta;

            if((selectedEquip==0)&&(selectedBean==0)){
                equip=fi.createIR5();
                fi.createGreenBean();
                bean=fi.createPB1Lot(equip.getBeanCapacity().getBeanAmount());
            }else if((selectedEquip==0)&&(selectedBean==1)){
                equip=fi.createIR5();
                fi.createKPBean();
                bean=fi.createKPBLot(equip.getBeanCapacity().getBeanAmount());
            }else if((selectedEquip==1)&&(selectedBean==0)){
                equip=fi.createIR12();
                fi.createGreenBean();
                bean=fi.createPB1Lot(equip.getBeanCapacity().getBeanAmount());
            }else if((selectedEquip==1)&&(selectedBean==1)){
                equip=fi.createIR12();
                fi.createKPBean();
                bean=fi.createKPBLot(equip.getBeanCapacity().getBeanAmount());
            }
            rp.setRDRoaster(equip);
            rp.setBeanLot(bean);
            rp.setTm(180);
            rp.setRoastTime(rt);
            rp.setroastTemp(ta);
            rp.createActivity();
            ca=new CalculateTemp(rp.ra,rp.ca,rp.ga);
            ce=new CalculateEmissions(rp.ra);
    
    }

      public void setImage(double temp){
        if(!inProgress){
            if(temp>=75&&temp<=270){
                fromImage=image1;
                toImage=image2;
                thresholdHigh=270;
                thresholdLow=75;
            }else if(temp>=270&&temp<=327){
                fromImage=image2;
                toImage=image3;
                thresholdHigh=327;
                thresholdLow=270;
            }else if(temp>=327&&temp<=345){
                fromImage=image3;
                toImage=image4;
                thresholdHigh=345;
                thresholdLow=327;
            }else if(temp>=345&&temp<=370){
                fromImage=image4;
                toImage=image5;
                thresholdHigh=370;
                thresholdLow=345;
            }else if(temp>=370&&temp<=393){
                fromImage=image5;
                toImage=image6;
                thresholdHigh=393;
                thresholdLow=370;
            }else if(temp>=393&&temp<=401){
                fromImage=image6;
                toImage=image7;
                thresholdHigh=401;
                thresholdLow=393;
            }else if(temp>=401&&temp<=415){
                fromImage=image7;
                toImage=image8;
                thresholdHigh=415;
                thresholdLow=401;
            }else if(temp>=415&&temp<=426){
                fromImage=image8;
                toImage=image9;
                thresholdHigh=426;
                thresholdLow=415;
            }else if(temp>=426&&temp<=435){
                fromImage=image9;
                toImage=image10;
                thresholdHigh=435;
                thresholdLow=426;
            }else if(temp>=435&&temp<=444){
                fromImage=image10;
                toImage=image11;
                thresholdHigh=444;
                thresholdLow=435;
            }else if(temp>=444&&temp<=454){
                fromImage=image11;
                toImage=image12;
                thresholdHigh=454;
                thresholdLow=444;
            }else if(temp>=454&&temp<=465){
                fromImage=image12;
                toImage=image13;
                thresholdHigh=465;
                thresholdLow=454;
            }else if(temp>=465&&temp<=474){
                fromImage=image13;
                toImage=image14;
                thresholdHigh=474;
                thresholdLow=465;
            }else if(temp>=474&&temp<=486){
                fromImage=image14;
                toImage=image15;
                thresholdHigh=486;
                thresholdLow=474;
            }else if(temp>=486&&temp<=497){
                fromImage=image15;
                toImage=image16;
                thresholdHigh=497;
                thresholdLow=486;
            }
          inProgress=true;
          if (fromImage.getHeight() != toImage.getHeight() || fromImage.getWidth() != toImage.getWidth()){
            int width = Math.min(fromImage.getWidth(), toImage.getWidth());
            int height = Math.min(fromImage.getHeight(), toImage.getHeight());
            toImage = toImage.getSubimage(0, 0, width, height);
            fromImage = fromImage.getSubimage(0, 0, width, height);
          }
          height = fromImage.getHeight();
          width = fromImage.getWidth();

          int[] image1pixels = fromImage.getRaster().getPixels(0, 0, width, height, (int[])null);
          int[] image2pixels = toImage.getRaster().getPixels(0, 0, width, height, (int[])null);
          morphImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
          morphRaster = morphImage.getRaster();

          array1 = convertTo3DArray(image1pixels, width, height);
          array2 = convertTo3DArray(image2pixels, width, height);
        }
    }
      private static void morphTick(int[][][] image1, int[][][] image2) {
        //row
        for(int i = 0; i < image1.length; i++){
            // column
            for(int j = 0; j < image1[0].length; j++){

                // colors: red, green and blue
                // calculate the difference between two images for each color
                int diffr = (image2[i][j][0] - image1[i][j][0]);
                int diffg = (image2[i][j][1] - image1[i][j][1]);
                int diffb = (image2[i][j][2] - image1[i][j][2]);

                //signum() returns -1, 0 or 1.
                int redstep = (int)Math.signum(diffr);
                int greenstep = (int) Math.signum(diffg);
                int bluestep = (int)Math.signum(diffb);

                int adiffr = Math.abs(diffr);
                int adiffg = Math.abs(diffg);
                int adiffb = Math.abs(diffb);

                //take a big or small step
                if (adiffr >= 4)
                    redstep *= (int) Math.min(adiffr,4);
                if (adiffg >= 4)
                    greenstep *= (int) Math.min(adiffg,4);
                if (adiffb >= 4)
                    bluestep *= (int) Math.min(adiffb,4);

                //update the source image
                image1[i][j][0] += redstep;
                image1[i][j][1] += greenstep;
                image1[i][j][2] += bluestep;

            }
        }
    }
         public static int[][][] convertTo3DArray( int[] oneDPix1, int width, int height){

        int[][][] data = new int[height][width][3];

        // Convert 1D array to 3D array
        for(int row = 0; row < height; row++){
            for(int col = 0; col < width; col++){
                int element = (row * width + col)*3;
                // Red
                data[row][col][0] = oneDPix1[element+0];
                // Green
                data[row][col][1] = oneDPix1[element+1];
                // Blue
                data[row][col][2] = oneDPix1[element+2];

            }
        }
        return data;
    }

    public static int[] convertTo1DArray( int[][][] data, int width, int height){

        // Pack a 3D image array into a 1D array because raster requires 1D int array
        int[] oneDPix = new int[ width * height * 3];

        int cnt = 0;

        for (int row = 0; row < height; row++){
            for (int col = 0; col < width; col++){
                //red
                oneDPix[cnt++] =  data[row][col][0];
                //green
                oneDPix[cnt++] =  data[row][col][1];
                //blue
                oneDPix[cnt++] =  data[row][col][2];
            }
        }

        return oneDPix;
    }
BufferedImage redrawPicture(int  [][][]array1)
    {

            int[] arr1D = convertTo1DArray(array1, width, height);
            morphRaster.setPixels(0, 0, width, height, arr1D);
            BufferedImage displayImage =  ImageUtils.getScaledInstance(morphImage, width, height, RenderingHints.VALUE_INTERPOLATION_BILINEAR, false);
               // animeIcon = new ImageIcon(displayImage);
              //  anime.setIcon(animeIcon);
            return displayImage;


    }
public CalculateTemp getCalc(){
    return ca;
}
public CalculateEmissions getCe(){
    return ce;
}
public void Halt(){
    halt=true;

}
public Boolean checkHalt(){
    return halt;
}
    protected Void doInBackground(){
        

        while((!isCancelled())){
       
          
          
           while((!halt)&&(temperature<=ta)&&(!isCancelled())&&(i<=(rt*60))){
               stopcheck=false;
            halt=checkHalt();
            ca.CalculateTemp();
            i++;
            currentTime.setText(i+" seconds");
            double currentSteps;
          
            temperature = ca.getTa();
            TaGraph.MakeFile(temperature,false);
            if(ca.getTb()>thresholdHigh){
                inProgress=false;
            }
            Tb=ca.getTb();
            TbGraph.MakeFile(Tb, false);
            currentTempb.setText(Tb+"");
            currentTempa.setText(temperature+"");
            if(show){
            calcArea.setText(ca.getCalc());
               }
            
            setImage(Tb);
            double diff=thresholdHigh-thresholdLow;
            currentSteps=(totalSteps*(Tb-thresholdLow))/diff;

            for(int j=0;j<currentSteps;j++){
                morphTick(array1, array2);
                   publish(  redrawPicture(array1));
            }
       

            totalSteps=totalSteps-currentSteps;
            thresholdLow=Tb;
            diff=thresholdHigh-thresholdLow;

            }



           if((temperature>ta)||(i>(rt*60))){
               start.setEnabled(true);
               stop.setEnabled(false);
               pause.setEnabled(false);
               heat.setValue(0);
               heat.setEnabled(false);
               resume.setVisible(false);
               generate.setEnabled(true);
               TaGraph.MakeFile(temperature,true);
               TbGraph.MakeFile(ta, true);
               showCalc.setEnabled(true);
  

            break;
            }

        }
        heat.setEnabled(false);
        heat.setValue(0);
        halt=false;
   
        showCalc.setEnabled(true);
    return null;
    }

    protected void process(List<BufferedImage> pairs) {
            BufferedImage pair = pairs.get(pairs.size() - 1);
            
                 
            animeIcon = new ImageIcon(pair);
            anime.setIcon(animeIcon);
        }



}
