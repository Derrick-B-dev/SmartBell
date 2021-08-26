import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * Description
 *
 * @version 1.0 from 27/05/2021
 * @author Derrick Bugembe
 */

public class keypad extends JFrame {
    // App attributes
    private JPanel panel1 = new JPanel(null);
    private JButton keypad1 = new JButton();
    private JButton keypad2 = new JButton();
    private JButton keypad3 = new JButton();
    private JButton keypad4 = new JButton();
    private JButton keypad5 = new JButton();
    private JButton keypad6 = new JButton();
    private JButton keypad7 = new JButton();
    private JButton keypad8 = new JButton();
    private JButton keypad9 = new JButton();
    private JButton keypad10 = new JButton();
    private JButton button11 = new JButton();
    private JButton button12 = new JButton();
    private JButton button13 = new JButton();
    private JButton button14 = new JButton();
    private JPasswordField PWTXT = new JPasswordField(); //
    private JLabel label1 = new JLabel();
    // end attributes

    public keypad() {
        // Frame-Init
        super();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) { dispose(); }
        });
        int frameWidth = 503;
        int frameHeight = 358;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("keypad");
        setResizable(false);
        Panel cp = new Panel(null);
        add(cp);
        Font f1 = new Font("Dialog", Font.BOLD, 30);
        JTextField textfield = new JTextField ();

        textfield.setFont(f1);
        PWTXT.setFont(f1);

        // start components


        panel1.setBounds(1, -6, 484, 324);
        panel1.setFont(new Font("Dialog", Font.PLAIN, 13));
        cp.add(panel1);
        keypad1.setBounds(44, 80, 90, 60);
        keypad1.setLabel("1");
        keypad1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button1_ActionPerformed(evt);
            }
        });
        panel1.add(keypad1);
        keypad2.setBounds(152, 80, 90, 60);
        keypad2.setText("2");
        keypad2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button2_ActionPerformed(evt);
            }
        });
        panel1.add(keypad2);
        keypad3.setBounds(260, 80, 90, 60);
        keypad3.setLabel("3");
        keypad3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button3_ActionPerformed(evt);
            }
        });
        panel1.add(keypad3);
        keypad4.setBounds(44, 140, 90, 60);
        keypad4.setLabel("4");
        keypad4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button4_ActionPerformed(evt);
            }
        });
        panel1.add(keypad4);
        keypad5.setBounds(152, 140, 90, 60);
        keypad5.setLabel("5");
        keypad5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button5_ActionPerformed(evt);
            }
        });
        panel1.add(keypad5);
        keypad6.setBounds(260, 140, 90, 60);
        keypad6.setLabel("6");
        keypad6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button6_ActionPerformed(evt);
            }
        });
        panel1.add(keypad6);
        keypad7.setBounds(44, 200, 90, 60);
        keypad7.setLabel("7");
        keypad7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button7_ActionPerformed(evt);
            }
        });
        panel1.add(keypad7);
        keypad8.setBounds(152, 200, 90, 60);
        keypad8.setLabel("8");
        keypad8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button8_ActionPerformed(evt);
            }
        });
        panel1.add(keypad8);
        keypad9.setBounds(260, 200, 90, 60);
        keypad9.setLabel("9");
        keypad9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button9_ActionPerformed(evt);
            }
        });
        panel1.add(keypad9);
        keypad10.setBounds(44, 260, 90, 60);
        keypad10.setLabel("C");
        keypad10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button10_ActionPerformed(evt);
            }
        });
        panel1.add(keypad10);
        button11.setBounds(152, 260, 90, 60);
        button11.setLabel("0");
        button11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button11_ActionPerformed(evt);
            }
        });
        button11.setFont(new Font("Dialog", Font.BOLD, 20));
        panel1.add(button11);
        button12.setBounds(260, 260, 90, 60);
        button12.setLabel("OK");
        button12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button12_ActionPerformed(evt);
            }
        });
        button12.setFont(new Font("Dialog", Font.BOLD, 20));
        panel1.add(button12);
        button13.setBounds(370, 80, 90, 120);
        button13.setLabel("RFID");
        button13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button13_ActionPerformed(evt);
            }
        });
        button13.setFont(new Font("Dialog", Font.BOLD, 20));
        panel1.add(button13);
        button14.setBounds(370, 201, 90, 120);
        button14.setLabel("Close");
        button14.setBackground(new java.awt.Color(255, 51, 51));
        button14.setForeground(new java.awt.Color(255, 255, 255));
        button14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button14_ActionPerformed(evt);
            }
        });
        button14.setFont(new Font("Dialog", Font.BOLD, 18));
        panel1.add(button14);
        PWTXT.setBounds(43, 26, 306, 46);
        PWTXT.setHorizontalAlignment(JTextField.CENTER);
        panel1.add(PWTXT);

        keypad1.setFont(new Font("Dialog", Font.BOLD, 20));

        keypad2.setFont(new Font("Dialog", Font.BOLD, 20));

        keypad3.setFont(new Font("Dialog", Font.BOLD, 20));

        keypad4.setFont(new Font("Dialog", Font.BOLD, 20));

        keypad5.setFont(new Font("Dialog", Font.BOLD, 20));

        keypad6.setFont(new Font("Dialog", Font.BOLD, 20));

        keypad7.setFont(new Font("Dialog", Font.BOLD, 20));

        keypad8.setFont(new Font("Dialog", Font.BOLD, 20));

        keypad9.setFont(new Font("Dialog", Font.BOLD, 20));

        keypad10.setFont(new Font("Dialog", Font.BOLD, 20));

        PWTXT.setFont(new Font("Dialog", Font.BOLD, 20));

        label1.setFont(new Font("Dialog", Font.BOLD, 20));

        // end components

        setVisible(true);

        try {
            liveButton();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } // end of public keypad
    public void liveButton() throws FileNotFoundException {

        while (1 >0) {   //  A simpel infinet loop im because im runing out of time :D

            File live_update = new File("/var/www/html/docs/live.txt");
            Scanner if_liveReader = new Scanner(live_update);


            while (if_liveReader.hasNextLine()) {
                String cheaklive = if_liveReader.nextLine();
                if (cheaklive.contains("pins")) { // Updates user names and passwords

                    for(int i=1;i<=1;i++) {

                        try
                        {
                            File live = new File("/var/www/html/docs/liveDemo.txt");
                            Scanner liveReader = new Scanner(live);
                            File users = new File("/var/www/html/docs/residents.txt");

                            Scanner userReader = new Scanner(users);

                            String names = userReader.nextLine();
                            String live_btn = liveReader.nextLine();
                            String[] user = names.split("_");

                            String name1= user[0];
                            String name2= user[1];
                            String name3= user[2];

                            String pin1= user[3];
                            String pin2= user[4];
                            String pin3= user[5];

                            if (live_btn.equals(pin1)) {
                                PWTXT.setEchoChar((char)0);
                                PWTXT.setBackground(Color.GREEN);
                                PWTXT.setForeground(Color.BLUE);
                                PWTXT.setText("Welcome "+name1);
                                Process p_openDoor = Runtime.getRuntime().exec("sudo python /home/pi/Desktop/test-relay.py");
                                Process p_Led = Runtime.getRuntime().exec("sudo python /home/pi/Desktop/LED.py");
                                // New entry log
                                Date d = new Date();
                                SimpleDateFormat t = new SimpleDateFormat(" dd MMMM yyyy");
                                SimpleDateFormat tim = new SimpleDateFormat(" hh:mm");
                                String date=(t.format(d));
                                String time = (tim.format(d));
                                String info = "pin used at";

                                String notify = (name1+" User "+info+" "+time+" "+date+ " access granted" );

                                Writer output;
                                output = new BufferedWriter(new FileWriter("/home/pi/Desktop/doorbell log.txt",true));  //clears file every time

                                output.write(notify);
                                ((BufferedWriter) output).newLine();
                                output.close();

                                Thread.sleep(3000);// After 5 seconds
                                dispose();

                            } else if (live_btn.equals(pin2)) {
                                PWTXT.setEchoChar((char)0);
                                PWTXT.setBackground(Color.GREEN);
                                PWTXT.setForeground(Color.BLUE);
                                PWTXT.setText("Welcome "+name2);
                                Process p_openDoor = Runtime.getRuntime().exec("sudo python /home/pi/Desktop/test-relay.py");
                                Process p_Led = Runtime.getRuntime().exec("sudo python /home/pi/Desktop/LED.py");
                                // New entry log
                                Date d = new Date();
                                SimpleDateFormat t = new SimpleDateFormat(" dd MMMM yyyy");
                                SimpleDateFormat tim = new SimpleDateFormat(" hh:mm");
                                String date=(t.format(d));
                                String time = (tim.format(d));
                                String info = "pin used at";

                                String notify = (name2+" User "+info+" "+time+" "+date+ " access granted" );

                                Writer output;
                                output = new BufferedWriter(new FileWriter("/home/pi/Desktop/doorbell log.txt",true));  //clears file every time

                                output.write(notify);
                                ((BufferedWriter) output).newLine();
                                output.close();

                                Thread.sleep(3000);// After 5 seconds
                                dispose();

                            } else if (live_btn.equals(pin3)) {
                                PWTXT.setEchoChar((char)0);
                                PWTXT.setBackground(Color.GREEN);
                                PWTXT.setForeground(Color.BLUE);
                                PWTXT.setText("Welcome "+name3);
                                Process p_openDoor = Runtime.getRuntime().exec("sudo python /home/pi/Desktop/test-relay.py");
                                Process p_Led = Runtime.getRuntime().exec("sudo python /home/pi/Desktop/LED.py");
                                // New entry log
                                Date d = new Date();
                                SimpleDateFormat t = new SimpleDateFormat(" dd MMMM yyyy");
                                SimpleDateFormat tim = new SimpleDateFormat(" hh:mm");
                                String date=(t.format(d));
                                String time = (tim.format(d));
                                String info = "pin used at";

                                String notify = (name3+" User "+info+" "+time+" "+date+ " access granted" );

                                Writer output;
                                output = new BufferedWriter(new FileWriter("/home/pi/Desktop/doorbell log.txt",true));  //clears file every time

                                output.write(notify);
                                ((BufferedWriter) output).newLine();
                                output.close();

                                Thread.sleep(3000);// After 5 seconds
                                dispose();

                            } else {
                                PWTXT.setEchoChar((char)0);
                                PWTXT.setBackground(Color.RED);
                                PWTXT.setText("WRONG PIN");
                                // New entry log
                                Date d = new Date();
                                SimpleDateFormat t = new SimpleDateFormat(" dd MMMM yyyy");
                                SimpleDateFormat tim = new SimpleDateFormat(" hh:mm");
                                String date=(t.format(d));
                                String time = (tim.format(d));
                                String info = "Residents Attempted entry using pin ";

                                String notify = (info+" '"+pin2+"' at "+time+" date "+date+" access denied");

                                Writer output;
                                output = new BufferedWriter(new FileWriter("/home/pi/Desktop/doorbell log.txt",true));  //clears file every time

                                output.write(notify);
                                ((BufferedWriter) output).newLine();
                                output.close();
                                Thread.sleep(3000);// After 5 seconds
                                PWTXT.setBackground(new Color(255, 255, 255));
                                PWTXT.setText("");
                                PWTXT.setEchoChar('*');
                            }

                            userReader.close();

                            PrintWriter prw1= new PrintWriter ("/var/www/html/docs/liveDemo.txt");
                            prw1.println("");
                            PrintWriter prw2= new PrintWriter ("/var/www/html/docs/live.txt");
                            prw2.println("");
                            prw1.close();
                            prw2.close();
                            // System.out.println("done");

                        }
                        catch(Exception e)
                        {
                        }


                    }
                }
            }
        }




    }
    // start methods

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(keypad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(keypad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(keypad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(keypad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new keypad();



    } // end of main

    public void button1_ActionPerformed(ActionEvent evt) {
        PWTXT.setText( PWTXT.getText()+("1"));

    } // end of button1_ActionPerformed

    public void button2_ActionPerformed(ActionEvent evt) {
        PWTXT.setText( PWTXT.getText()+("2"));

    } // end of button2_ActionPerformed

    public void button3_ActionPerformed(ActionEvent evt) {
        PWTXT.setText( PWTXT.getText()+("3"));

    } // end of button3_ActionPerformed

    public void button4_ActionPerformed(ActionEvent evt) {
        PWTXT.setText( PWTXT.getText()+("4"));

    } // end of button4_ActionPerformed

    public void button5_ActionPerformed(ActionEvent evt) {
        PWTXT.setText( PWTXT.getText()+("5"));

    } // end of button5_ActionPerformed

    public void button6_ActionPerformed(ActionEvent evt) {
        PWTXT.setText( PWTXT.getText()+("6"));

    } // end of button6_ActionPerformed

    public void button7_ActionPerformed(ActionEvent evt) {
        PWTXT.setText( PWTXT.getText()+("7"));

    } // end of button7_ActionPerformed

    public void button8_ActionPerformed(ActionEvent evt) {
        PWTXT.setText( PWTXT.getText()+("8"));

    } // end of button8_ActionPerformed

    public void button9_ActionPerformed(ActionEvent evt) {
        PWTXT.setText( PWTXT.getText()+("9"));

    } // end of button9_ActionPerformed

    public void button10_ActionPerformed(ActionEvent evt) {
        PWTXT.setText(PWTXT.getText().substring(0, PWTXT.getText ().length() - 1));

    } // end of button10_ActionPerformed

    public void button11_ActionPerformed(ActionEvent evt) {
        PWTXT.setText( PWTXT.getText()+("0"));

    } // end of button11_ActionPerformed

    public void button12_ActionPerformed(ActionEvent evt) {
        Thread tp=new Thread(new Runnable() {

            public void run()
            {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            keypad.class.getClass().getResourceAsStream("/home/pi/Desktop/joke.txt");

            File users = new File("/home/pi/Desktop/joke.txt");

            Scanner userReader = new Scanner(users);

            while (userReader.hasNext()) {

                String names = userReader.nextLine();
                String[] user = names.split("_");

                String name1= user[0];
                String name2= user[1];
                String name3= user[2];


                String pin1= user[3];
                String pin2= user[4];
                String pin3= user[5];


                String epin1= PWTXT.getText();
                String epin2= PWTXT.getText();
                String epin3=PWTXT.getText();

                if (epin1.equals(pin1)) {
                    PWTXT.setEchoChar((char)0);
                    PWTXT.setBackground(Color.GREEN);
                    PWTXT.setForeground(Color.BLUE);
                    PWTXT.setText("Welcome "+name1);
                    Process p_openDoor = Runtime.getRuntime().exec("sudo python /home/pi/Desktop/test-relay.py");
                    Process p_Led = Runtime.getRuntime().exec("sudo python /home/pi/Desktop/LED.py");
                    // New entry log
                    Date d = new Date();
                    SimpleDateFormat t = new SimpleDateFormat(" dd MMMM yyyy");
                    SimpleDateFormat tim = new SimpleDateFormat(" hh:mm");
                    String date=(t.format(d));
                    String time = (tim.format(d));
                    String info = "pin used at";

                    String notify = (name1+" User "+info+" "+time+" "+date+ " access granted" );

                    Writer output;
                    output = new BufferedWriter(new FileWriter("/home/pi/Desktop/doorbell log.txt",true));  //clears file every time

                    output.write(notify);
                    ((BufferedWriter) output).newLine();
                    output.close();

                    Thread.sleep(3000);// After 5 seconds
                    dispose();

                }else if(epin2.equals(pin2)){
                    PWTXT.setEchoChar((char)0);
                    PWTXT.setForeground(Color.BLUE);
                    PWTXT.setBackground(Color.GREEN);
                    PWTXT.setText("Welcome "+name2);
                    Process p = Runtime.getRuntime().exec("sudo python /home/pi/Desktop/test-relay.py");
                    Process p_Led = Runtime.getRuntime().exec("sudo python /home/pi/Desktop/LED.py");
                    // New entry log
                    Date d = new Date();
                    SimpleDateFormat t = new SimpleDateFormat(" dd MMMM yyyy");
                    SimpleDateFormat tim = new SimpleDateFormat(" hh:mm");
                    String date=(t.format(d));
                    String time = (tim.format(d));
                    String info = "Pin used at";

                    String notify = (name2+" User "+info+" "+time+" "+date+ "access granted");

                    Writer output;
                    output = new BufferedWriter(new FileWriter("/home/pi/Desktop/doorbell log.txt",true));  //clears file every time

                    output.write(notify);
                    ((BufferedWriter) output).newLine();
                    output.close();

                    Thread.sleep(3000);// After 5 seconds
                    dispose();
                }else if(epin3.equals(pin3)){
                    PWTXT.setEchoChar((char)0);
                    PWTXT.setForeground(Color.BLUE);
                    PWTXT.setBackground(Color.GREEN);
                    PWTXT.setText("Welcome "+name3);

                    Process p = Runtime.getRuntime().exec("sudo python /home/pi/Desktop/test-relay.py");
                    Process p_Led = Runtime.getRuntime().exec("sudo python /home/pi/Desktop/LED.py");

                    // New entry log
                    Date d = new Date();
                    SimpleDateFormat t = new SimpleDateFormat(" dd MMMM yyyy");
                    SimpleDateFormat tim = new SimpleDateFormat(" hh:mm");
                    String date=(t.format(d));
                    String time = (tim.format(d));
                    String info = "Pin used at";

                    String notify = (name3+"'s "+info+" "+time+" date "+date+" access granted");

                    Writer output;
                    output = new BufferedWriter(new FileWriter("/home/pi/Desktop/doorbell log.txt",true));  //clears file every time

                    output.write(notify);
                    ((BufferedWriter) output).newLine();
                    output.close();

                    Thread.sleep(3000);// After 5 seconds
                    dispose();

                }else{
                    PWTXT.setEchoChar((char)0);
                    PWTXT.setBackground(Color.RED);
                    PWTXT.setText("WRONG PIN");
                    // New entry log
                    Date d = new Date();
                    SimpleDateFormat t = new SimpleDateFormat(" dd MMMM yyyy");
                    SimpleDateFormat tim = new SimpleDateFormat(" hh:mm");
                    String date=(t.format(d));
                    String time = (tim.format(d));
                    String info = "Residents Attempted entry using pin ";

                    String notify = (info+" '"+pin2+"' at "+time+" date "+date+" access denied");

                    Writer output;
                    output = new BufferedWriter(new FileWriter("/home/pi/Desktop/doorbell log.txt",true));  //clears file every time

                    output.write(notify);
                    ((BufferedWriter) output).newLine();
                    output.close();
                    Thread.sleep(3000);// After 5 seconds
                    PWTXT.setBackground(new Color(255, 255, 255));
                    PWTXT.setText("");
                    PWTXT.setEchoChar('*');

                }


            }

            userReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
            }
        });
        tp.start();

    } // end of button12_ActionPerformed

    public void button13_ActionPerformed(ActionEvent evt) {


    } // end of button13_ActionPerformed

    public void button14_ActionPerformed(ActionEvent evt) {
        dispose();

    } // end of button14_ActionPerformed

    // end methods
} // end of class keypad

