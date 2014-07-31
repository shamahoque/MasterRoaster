/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shama H
 */

import MasterRoaster.Process.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;


public class SimulationGUI implements ActionListener, ChangeListener,ItemListener{
    Graph TaGraph=new Graph("Ta vs time","Ta vs TIME PROFILE"), TbGraph=new Graph("Tb vs TIME", "Tb vs TIME PROFILE");
    CustomComboBox BeanPane, EquipPane;
    JButton start, pause, stop, resume, generate, roast;
    FixedInput fi;
    JTextField temp,time;
    JLabel animeLabel,currentTime,currentTempb, currentTempa,PValues, CValues, VOCvalues;
    JPanel panel3, panel4,panel5, panel6;
    StartRoasting st;
    JSlider heat;
    JTextArea calcArea;
    JCheckBox showCalc;
    JScrollPane scrollingArea;
    Font font=new Font("Consolas", Font.BOLD, 14);
    Font font1=new Font("Consolas", Font.PLAIN, 12);
    Font font2=new Font("Consolas",Font.BOLD,20);
    Font font3=new Font("Consolas", Font.BOLD, 16);
    double part, co, voc;
    boolean show=false;

    SimulationGUI(){
        fi=new FixedInput();
        fi.createM1();
        fi.createM2();
        TaGraph.setBounds(10,10,380,380);
        TbGraph.setBounds(10,10,380,380);
        TaGraph.setStream();
            TbGraph.setStream();
    }



//Create ImageIcon for buttons and labels
    protected static ImageIcon createImageIcon(String path){
        java.net.URL imgURL = SimulationGUI.class.getResource(path);
        if(imgURL!= null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
                return null;
        }
    }

//Create toolbar
    protected JToolBar makeToolBar() {
        JToolBar toolBar = new JToolBar("MasterRoaster ToolBar");
        toolBar.setLayout(null);
        //Setting up buttons.
        ImageIcon startIcon = createImageIcon("images/play.jpg");
        ImageIcon pauseIcon = createImageIcon("images/pause.jpg");
        ImageIcon stopIcon = createImageIcon("images/stop.jpg");
        ImageIcon resumeIcon = createImageIcon("images/resume.jpg");
        //start button
        start=new JButton(startIcon);
        start.setActionCommand("START");
        start.setBackground(Color.white);
        start.setToolTipText("Start Roasting");
        start.addActionListener(this);
        start.setBounds(650,160, 60,60);
        //pause button
        pause=new JButton(pauseIcon);
        pause.setActionCommand("PAUSE");
        pause.setBackground(Color.white);
        pause.setToolTipText("Pause Roasting");
        pause.addActionListener(this);
        pause.setBounds(725,160, 60,60);
        pause.setEnabled(false);
        //stop button
        stop=new JButton(stopIcon);
        stop.setActionCommand("STOP");
        stop.setBackground(Color.white);
        stop.setToolTipText("Stop Roasting");
        stop.addActionListener(this);
        stop.setBounds(800, 160, 60,60);
        stop.setEnabled(false);
        //resume button
        resume=new JButton(resumeIcon);
        resume.setActionCommand("RESUME");
        resume.setBackground(Color.white);
        resume.setToolTipText("Resume Roasting");
        resume.addActionListener(this);
        resume.setBounds(650,160, 60,60);
        resume.setVisible(false);

        generate=new JButton("Generate Reports");
        generate.setBounds(915,160,250, 50);
        generate.setEnabled(false);
        generate.setActionCommand("GENERATE");
        generate.setBackground(Color.white);
        generate.setToolTipText("Generate Reports");
        generate.addActionListener(this);

        roast=new JButton("ROAST");
        roast.setBounds(915,160,250, 50);
        roast.setActionCommand("ROAST");
        roast.setBackground(Color.white);
        roast.setToolTipText("Roast");
        roast.addActionListener(this);
        roast.setVisible(false);

        //Custom combo-box
        EquipPane = new CustomComboBox("Diedrich IR5","Diedrich IR12");
        BeanPane = new CustomComboBox("Peaberry Grade One", "Kona Prime Bean");
        EquipPane.setOpaque(false);
        BeanPane.setOpaque(false);
        EquipPane.setBounds(2, 0, 300, 300);
        BeanPane.setBounds(305, 20, 350, 250);

        showCalc=new JCheckBox("Show Calculations");
        showCalc.setBounds(960, 10,200, 50);
        showCalc.setOpaque(false);
        showCalc.setFont(font3);
        showCalc.addItemListener(this);

        JLabel endtemp = new JLabel("Select Roast End-Temperature:");
        endtemp.setFont(font);
        endtemp.setBounds(920,70,250,20);
        JLabel roastTime = new JLabel("Select Roasting interval:");
        roastTime.setBounds(680,70,250,20);
        roastTime.setFont(font);
        time=new JTextField(10);
        time.setBounds(680,100,70,20);
        JLabel unit=new JLabel("(minutes)");
        unit.setBounds(760,100, 100,20);
        unit.setFont(font1);
        toolBar.add(unit);

        unit=new JLabel("(degree Fahrenheit)");
        unit.setBounds(1050,100,150,20);
        unit.setFont(font1);
        toolBar.add(unit);
        unit=new JLabel("min: 100, max: 500");
        unit.setBounds(921,120,150,20);
        unit.setFont(font1);
        toolBar.add(unit);
        temp  = new JTextField(10);
        temp.setBounds(920,100, 100,20);
        temp.addActionListener(this);
        temp.setActionCommand("TEMP");
        
        
        toolBar.add(EquipPane);
        toolBar.add(BeanPane);
        toolBar.add(showCalc);
        toolBar.add(endtemp);
        toolBar.add(roastTime);
        toolBar.add(time);        
        toolBar.add(temp);
        toolBar.add(generate);
        toolBar.add(roast);
        toolBar.add(resume);
        toolBar.add(start);
        toolBar.add(pause);
        toolBar.add(stop);
        toolBar.setOpaque(false);
        toolBar.setFloatable(true);
        toolBar.setRollover(true);

        return toolBar;
    }

    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        st.Halt();
        resume.setVisible(true);
        pause.setEnabled(false);
        if (!source.getValueIsAdjusting()) {
            int fps=(int)source.getValue();
            int diff=0;
            if(EquipPane.getSelectedValue()==0){
                diff=550;
            }else{diff=1030;}
            st.getCalc().setTgi((diff/100)*fps);
            System.out.println(fps);
        }
    }
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange()==ItemEvent.SELECTED){
            show=true;
        }else{
            show=false;
            calcArea.setText("\n\nSelect Show Calculations \n  to see values here...");
        }


    }


    public void actionPerformed(ActionEvent e) {
       String cmd = e.getActionCommand();
       RoastingProcess rp;
    if(cmd.equals("GENERATE")){
        
        panel3.setVisible(false);
        panel4.setVisible(true);
        panel5.setVisible(true);
        panel6.setVisible(true);
        TaGraph.setTemperatureArray();
        TbGraph.setTemperatureArray();
        
        panel4.add(TaGraph);
        panel5.add(TbGraph);
        PValues.setText(part+" kg");
        VOCvalues.setText(voc+" kg");
        CValues.setText(co+" kg");
        generate.setVisible(false);
        roast.setVisible(true);
        start.setEnabled(false);
        pause.setEnabled(false);
        TaGraph.setStream();
        TbGraph.setStream();

       }
       if(cmd.equalsIgnoreCase("ROAST")){
        generate.setVisible(true);
        generate.setEnabled(false);
        panel3.setVisible(true);
        panel4.setVisible(false);
        panel5.setVisible(false);
        panel6.setVisible(false);
        start.setEnabled(true);
        roast.setVisible(false);
        heat.setValue(0);
        heat.setEnabled(false);


       }

        if(cmd.equals("START")){
              TaGraph.setStream();
            TbGraph.setStream();
 
            try{
            double rt=Double.parseDouble(time.getText());
            double ta=Double.parseDouble(temp.getText());
            if(ta>=100&&ta<=500){
            st=new StartRoasting(animeLabel,currentTime,currentTempb,currentTempa,start,stop,pause,resume, 
                    generate,heat,TaGraph, TbGraph,calcArea,show,showCalc);
            st.SelectInput(fi, EquipPane.getSelectedValue(), BeanPane.getSelectedValue(), rt, ta);
            part=st.getCe().getParticulate();
            co=st.getCe().getCO();
            voc=st.getCe().getVOC();
            st.execute();
              
            start.setEnabled(false);
            stop.setEnabled(true);
            pause.setEnabled(true);
            heat.setEnabled(true);
            heat.setValue(0);
            generate.setEnabled(false);
                }else{
                    JOptionPane.showMessageDialog(panel3, "Invalid Input! Temperature not within range.");
                }
            }catch(Exception e1){
                JOptionPane.showMessageDialog(panel3, "Invalid Input! Check your roast-end temperature and roast time.");
            }

        }
       if(cmd.equals("PAUSE")){
           st.Halt();
            resume.setVisible(true);
            pause.setEnabled(false);
       }
       if(cmd.equals("RESUME")){
           st.halt=false;
           resume.setVisible(false);
           pause.setEnabled(true);

       }
       if(cmd.equals("STOP")){
           
            st.cancel(true);
            st=null;
            resume.setVisible(false);
            start.setEnabled(true);
            stop.setEnabled(false);
            pause.setEnabled(false);
            generate.setEnabled(true);
            
        }
      
 
    }


    private void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Master Roaster");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenu m = new MainMenu();
        frame.setJMenuBar(m.createMenuBar());

        JPanel panel = new JPanel();
        MyPanel Mainpanel = new MyPanel(Color.getHSBColor(1.6f, .29f, .29f),Color.getHSBColor(1.6f, .39f, .69f),0,0,0,660,1200, 660);
        Mainpanel.setLayout(null);
        Mainpanel.setBounds(0,240,1200,660);
        panel.setLayout(null);

        JPanel panel2=new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(20,145,250,200);
        panel2.setBackground(Color.getHSBColor(1.5f, .30f, .69f));
        panel2.setBorder(BorderFactory.createTitledBorder("Current Temperature and Time"));

        JLabel Label=new JLabel("Time:");
        Label.setBounds(50, 30, 100,20);
        Label.setFont(font);
        panel2.add(Label);

        currentTime=new JLabel("0 seconds");
        currentTime.setBounds(45,50,100,20);
        currentTime.setForeground(Color.white);
        currentTime.setFont(font);
        panel2.add(currentTime);

        Label=new JLabel("Bean Temperature:");
        Label.setBounds(20, 80, 150,20);
        Label.setFont(font);
        panel2.add(Label);

        currentTempb=new JLabel("75");
        currentTempb.setBounds(45,100,130,20);
        currentTempb.setForeground(Color.white);
        currentTempb.setFont(font);
        panel2.add(currentTempb);

        Label=new JLabel("Bean Lot Temperature:");
        Label.setBounds(20, 130, 250,20);
        Label.setFont(font);
        panel2.add(Label);

        currentTempa=new JLabel("70");
        currentTempa.setBounds(45,150,130,20);
        currentTempa.setForeground(Color.white);
        currentTempa.setFont(font);
        panel2.add(currentTempa);

        JLabel unit=new JLabel("degree Fahrenheit");
        unit.setBounds(30,170,150,20);
        
        panel2.add(unit);
        
        
        
        
        MyPanel toolPane=new MyPanel(Color.white,Color.getHSBColor(1.5f, .1f, .61f),0,0,240,240,1200, 240);
        toolPane.setBounds(0,0,1200,240);
        toolPane.setLayout(null);

        //Create and set up the content pane.
        frame.setContentPane(panel);
        
        JToolBar tbar=makeToolBar();
        tbar.setBounds(0,0,1200,240);
        toolPane.add(tbar);
        panel.add(toolPane);
        

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(0,0,1200,660);
        panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setBounds(20,25,410, 410);
        panel4.setOpaque(true);
        panel4.setVisible(false);

        panel5 = new JPanel();
        panel5.setLayout(null);
        panel5.setBounds(440,25,410, 410);
        panel5.setOpaque(true);
        panel5.setVisible(false);
        
       panel6=new JPanel();
       panel6.setLayout(null);
       panel6.setBounds(870, 20, 300, 440);
       panel6.setOpaque(false);
       panel6.setVisible(false);

       JLabel em=new JLabel("EMISSIONS");
       em.setFont(font2);
       em.setForeground(Color.orange);
       em.setBounds(90,0,200,100);
       panel6.add(em);
       MyPanel emP =new MyPanel(Color.getHSBColor(1.1f, .29f, .89f),Color.white,0,0,0,250,250,320);
       emP.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.getHSBColor(1.6f, .20f, .98f)));
       emP.setLayout(null);
       emP.setBounds(20,80,250,320);

       em=new JLabel("Particulate Matter: ");
       em.setFont(font);
       em.setForeground(Color.orange.darker().darker());
       em.setBounds(20,20,200,40);
       emP.add(em);

       PValues=new JLabel();
       PValues.setBounds(40, 50, 200, 40);
       emP.add(PValues);

       em=new JLabel("Volatile Organic Matter: ");
       em.setBounds(20,100,200,50);
       em.setFont(font);
       em.setForeground(Color.orange.darker().darker());
       emP.add(em);
       VOCvalues=new JLabel();
       VOCvalues.setBounds(40, 130, 200, 40);
       emP.add(VOCvalues);

       em=new JLabel("Carbon Monoxide: ");
       em.setFont(font);
       em.setForeground(Color.orange.darker().darker());
       em.setBounds(20,180,200,40);
       emP.add(em);
       CValues=new JLabel();
       CValues.setBounds(40, 210, 200, 40);
       emP.add(CValues);
       panel6.add(emP);


        ImageIcon animeIcon=createImageIcon("images/smaller/1.jpg");
        animeLabel = new JLabel();
        animeLabel.setBorder(BorderFactory.createMatteBorder(7, 7, 7, 7, Color.getHSBColor(1.6f, .20f, .98f)));
        animeLabel.setIcon(animeIcon);
        animeLabel.setBounds(430,110,305,255);
     
        JLabel rpLabel = new JLabel("Roasting Progress");
        rpLabel.setBounds(490, 0, 300, 200);
        rpLabel.setFont(font2);
        rpLabel.setForeground(Color.white);
        panel3.add(rpLabel);

        MyPanel heatPanel=new MyPanel(Color.red,Color.yellow,0,0,40,250,30,270);
        heatPanel.setLayout(null);
        heatPanel.setBounds(370,100,30,270);

        JLabel sliderLabel = new JLabel("HEAT");
        sliderLabel.setBounds(295,205,100,50);
        sliderLabel.setFont(font2);
        sliderLabel.setForeground(Color.white);
        panel3.add(sliderLabel);

        sliderLabel=new JLabel("max");
        sliderLabel.setBounds(310,80,50,50);
        sliderLabel.setFont(font);
        sliderLabel.setForeground(Color.red);
        panel3.add(sliderLabel);

        sliderLabel=new JLabel("min");
        sliderLabel.setBounds(310,340,50,50);
        sliderLabel.setFont(font);
        sliderLabel.setForeground(Color.yellow);
        panel3.add(sliderLabel);

        heat = new JSlider(JSlider.VERTICAL, 0, 100,0);
        heat.setBounds(0, 0,30,270);
        heat.addChangeListener(this);
        heat.setEnabled(false);
        heat.setOpaque(false);
        heatPanel.add(heat);

        rpLabel= new JLabel("CALCULATIONS");
        rpLabel.setBounds(900, 0, 200, 200);
        rpLabel.setFont(font);
        rpLabel.setForeground(Color.white);
        panel3.add(rpLabel);
        calcArea=new JTextArea(6,20);
        calcArea.setText("\n\nSelect Show Calculations \n  to see values here...");
        calcArea.setEditable(false);
        calcArea.setFont(font);
        scrollingArea = new JScrollPane(calcArea);
        scrollingArea.setBounds(810,110, 300,250);
        scrollingArea.setVisible(true);
        scrollingArea.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.getHSBColor(0.9f, .20f, .7f)));
        panel3.add(heatPanel);
        panel3.add(animeLabel);
        panel3.add(panel2);
        panel3.add(scrollingArea);
        panel3.setVisible(true);
        panel3.setOpaque(false);


        
        Mainpanel.add(panel4);
        Mainpanel.add(panel5);
        Mainpanel.add(panel6);
        Mainpanel.add(panel3);
        panel.add(Mainpanel);

        panel.setVisible(true);



        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1200, 750);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            SimulationGUI sg = new SimulationGUI();
            public void run() {

                sg.createAndShowGUI();
               
            }
        });
    }


}
class MyPanel extends JPanel {

    Color s2, e1;
    int x1, x2, y1,y2, width,length;
    public MyPanel(Color s2, Color e1,int x1, int y1, int x2,int y2,int width, int length ) {
        this.s2=s2;
        this.e1=e1;
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        this.length=length;
        this.width=width;
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

       Graphics2D g2d = (Graphics2D)g;

      GradientPaint gradient1 = new GradientPaint(x1,y1,s2,x1,y2,e1,true);
      g2d.setPaint(gradient1);
      g2d.fillRect(0,0,width,length);
    }

}
