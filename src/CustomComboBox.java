import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * CustomComboBoxDemo.java uses the following files:
 *   images/Bird.gif
 *   images/Cat.gif
 *   images/Dog.gif
 *   images/Rabbit.gif
 *   images/Pig.gif
 */
public class CustomComboBox extends JPanel{
    ImageIcon[] images;
    public String[] itemStrings= new String[2];
    JComboBox comboList;
    String Name;
    /*
     * Despite its use of EmptyBorder, this panel makes a fine content
     * pane because the empty border just increases the panel's size
     * and is "painted" on top of the panel's normal background.  In
     * other words, the JPanel fills its entire background if it's
     * opaque (which it is by default); adding a border doesn't change
     * that.
     */
    public CustomComboBox(String one, String two) {
        super(new BorderLayout());
        itemStrings[0]= one;
        itemStrings[1]= two;

        //Load the pet images and create an array of indexes.
        images = new ImageIcon[itemStrings.length];
        Integer[] intArray = new Integer[itemStrings.length];
        for (int i = 0; i < itemStrings.length; i++) {
            intArray[i] = new Integer(i);
            images[i] = createImageIcon("images/" + itemStrings[i] + ".jpg");
            if (images[i] != null) {
                images[i].setDescription(itemStrings[i]);
            }
        }

        //Create the combo box.
        comboList = new JComboBox(intArray);
        comboList.setOpaque(false);
        ComboBoxRenderer renderer= new ComboBoxRenderer();
        renderer.setSize(new Dimension(270, 200));
        renderer.setOpaque(false);

        
        comboList.setRenderer(renderer);
        comboList.setMaximumRowCount(3);


        //Lay out the demo.
        add(comboList, BorderLayout.PAGE_START);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    public int getSelectedValue(){
        return comboList.getSelectedIndex();
    }
   

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = CustomComboBox.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
                return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
   

    class ComboBoxRenderer extends JLabel
                           implements ListCellRenderer{
        private Font uhOhFont;

        public ComboBoxRenderer() {
            setOpaque(true);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
        }

        /*
         * This method finds the image and text corresponding
         * to the selected value and returns the label, set up
         * to display the text and image.
         */

        public Component getListCellRendererComponent(
                                           JList list,
                                           Object value,
                                           int index,
                                           boolean isSelected,
                                           boolean cellHasFocus) {
            //Get the selected index. (The index param isn't
            //always valid, so just use the value.)
            int selectedIndex = ((Integer)value).intValue();

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            //Set the icon and text.  If icon was null, say so.
            ImageIcon icon = images[selectedIndex];
            String pet = itemStrings[selectedIndex];
            setIcon(icon);
            if (icon != null) {
                setText(pet);
                setFont(list.getFont());
            } else {
                setUhOhText(pet + " (no image available)",
                            list.getFont());
            }

            return this;
        }

        //Set the font and text when no image was found.
        protected void setUhOhText(String uhOhText, Font normalFont) {
            if (uhOhFont == null) { //lazily create this font
                uhOhFont = normalFont.deriveFont(Font.BOLD);
            }
            setFont(uhOhFont);
            setText(uhOhText);
        }
    }
}