import com.google.zxing.*;

import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * Description
 *
 * @version 1.0 from 17/05/2021
 * @author Derrick
 */

public class Doorbell_Gui extends JFrame {
    // start attributes
    private JPanel jPanel1 = new JPanel(null, true);
    private JButton jButton1 = new javax.swing.JButton();
    private JButton jButton2 = new JButton();
    private JButton jButton3 = new JButton();
    private JPanel jPanel2 = new GradientPanel();
    private JButton jButton4 = new JButton();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();



    // Loops for "update" string in text file if true it fetches user new user names, passwords, messages etc

    void update() throws IOException, WriterException {

        while (1 >0){   //  A simpel infinet loop im because im runing out of time :D

            File updateData = new File("/var/www/html/docs/update.txt");
            Scanner updateReader = new Scanner(updateData);
            while (updateReader.hasNextLine()){
                String checkups = updateReader.nextLine();

                if (checkups.contains("update")) { // Updates user names and passwords
                    Qr_code.main(new String[]{});

                    for(int i=1;i<=1;i++) {

                            try
                            {
                                File Pi_name = new File("/var/www/html/docs/doorText.txt");
                                File users = new File("/var/www/html/docs/residents.txt");

                                Scanner nameReader = new Scanner(Pi_name);
                                Scanner userReader = new Scanner(users);
                                while (nameReader.hasNextLine()||userReader.hasNext()) {

                                    String header = nameReader.nextLine();
                                    String names = userReader.nextLine();
                                    String[] user = names.split("_");
                                    String name1= user[0];
                                    String name2= user[1];
                                    String name3= user[2];

                                    jLabel1.setText(" "+header);
                                    jButton1.setText(name1);
                                    jButton2.setText(name2);
                                    jButton3.setText(name3);
                                }
                                nameReader.close();
                                userReader.close();

                                Thread.sleep(2);// After 2 seconds
                                PrintWriter prw1= new PrintWriter ("/var/www/html/docs/update.txt");
                                prw1.println("waiting");
                                prw1.close();
                               // System.out.println("done");

                            }
                            catch(Exception e)
                            {
                            }
                    }
                }
            }

            File live_update = new File("/var/www/html/docs/live.txt");
            Scanner if_liveReader = new Scanner(live_update);

            while (if_liveReader.hasNextLine()) {
                String cheaklive = if_liveReader.nextLine();
                if (cheaklive.contains("live")) { // Updates user names and passwords

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

                            if (live_btn.equals(name1)) {
                                jButton1.doClick();

                            } else if (live_btn.equals(name2)) {
                                jButton2.doClick();

                            } else if (live_btn.equals(name3)) {
                                jButton3.doClick();

                            } else if (live_btn.equals("pins")){
                                jButton4.doClick();
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
    // Fills User names into buttons and update sets current passwords from text file
    void startup() throws IOException, WriterException {

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Doorbell_Gui.class.getClass().getResourceAsStream("/var/www/html/docs/doorText.txt");

            // Loads user names and passwords etc at start up
            File Pi_name = new File("/var/www/html/docs/doorText.txt");
            File users = new File("/var/www/html/docs/residents.txt");

            Scanner nameReader = new Scanner(Pi_name);
            Scanner userReader = new Scanner(users);
            while (nameReader.hasNextLine()||userReader.hasNext()) {

                String header = nameReader.nextLine();
                String names = userReader.nextLine();
                String[] user = names.split("_");
                String name1= user[0];
                String name2= user[1];
                String name3= user[2];

                jLabel1.setText(" "+header);
                jButton1.setText(name1);
                jButton2.setText(name2);
                jButton3.setText(name3);
            }
            nameReader.close();
            userReader.close();

        } catch (FileNotFoundException exception) {
            System.out.println("An error occurred.");
            exception.printStackTrace();
        }



    }



    void showTimeAndHeader() {
        new Timer(1000, new ActionListener() {   // updates time every second
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("H:mm");
                jLabel2.setText(s.format(d));

            }
        }).start();
    }


    public Doorbell_Gui() throws IOException, WriterException {
        // Frame-Init
        super();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int frameWidth = 498;
        int frameHeight = 357;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("Welcome");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);

        jPanel1.setBounds(-7, -1, 492, 324);
        jPanel1.setOpaque(true);
        jPanel1.setBackground(Color.WHITE);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cp.add(jPanel1);
        jButton1.setBounds(50, 73, 400, 70);

        jButton1.setMargin(new Insets(2, 2, 2, 2));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 24));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    jButton1_ActionPerformed(evt);
                } catch (FileNotFoundException exception) {
                    exception.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        jPanel1.add(jButton1,new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 73, 400, 70));

        jButton2.setBounds(50, 146, 400, 70);
        jButton2.setMargin(new Insets(2, 2, 2, 2));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 24));
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    jButton2_ActionPerformed(evt);
                } catch (FileNotFoundException exception) {
                    exception.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        jPanel1.add(jButton2,new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 146, 400, 70));
        jButton3.setBounds(50, 220, 400, 70);

        jButton3.setMargin(new Insets(2, 2, 2, 2));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 24));
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    jButton3_ActionPerformed(evt);
                } catch (FileNotFoundException exception) {
                    exception.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        jPanel1.add(jButton3,new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 400, 70));
        jPanel2.setBounds(6, 299, 492, 28);
        jPanel2.setOpaque(false);
        jPanel1.add(jPanel2,new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 299, 492, 28));

        jButton4.setBounds(375, 8, 80, 57);
        jButton4.setText("PIN");
        jButton4.setMargin(new Insets(2, 2, 2, 2));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 22));

        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4_ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4,new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 8, 75, 57));
        jLabel1.setBounds(64, 10, 302, 52);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(117, 169, 41));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource("/home/pi/Desktop/SmartBell/img/rapi_logo.png");
        jLabel1.setIcon(new ImageIcon("/home/pi/Desktop/SmartBell/img/rapi_logo.png"));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(117, 169, 41));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 10, 302, 52));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 60, 52));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 480, -1));
        // end components

        setVisible(true);
        showTimeAndHeader();
        startup();
        update();

    }



    public static void main(String[] args) throws IOException, WriterException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        new Doorbell_Gui();

    } // end of main

    public void jButton1_ActionPerformed(ActionEvent evt) throws IOException {

        File msgs = new File("/var/www/html/docs/Messages.txt");
        File redirect = new File("/var/www/html/docs/Cheak_user.txt");

        Scanner msgReader = new Scanner(msgs);
        Scanner redirectReader = new Scanner(redirect);

        while (msgReader.hasNextLine()||redirectReader.hasNext()) {

            String redir = redirectReader.nextLine();
            String[] rdi = redir.split("_");
            String rdi1= rdi[1];

            //Splits messages.txt and Gets the user based message
            String msg = msgReader.nextLine();
            String[] Msg = msg.split("/");
            //Message for first user is in  array postion [1]
            String msg1= Msg[0];

            if (rdi1.contains("Away")  ) {
                // block of code to be executed if the condition is true
                try
                {
                    String path = "/var/www/html/images/usr1Quote.png";
                    String new_msg = msg1;
                    String name = jButton1.getText();
                    notice_board board = new notice_board();
                    board.display(new_msg);
                    board.display_name(name);
                    board.display_img(path);
                    System.out.println(new_msg);


                } catch (Exception ex) {

                }

            }
                Thread tp=new Thread(new Runnable() { // changes text and label icon

                    public void run()
                    {
                        try
                        {
                            File Pi_name = new File("/var/www/html/docs/doorText.txt");
                            Scanner nameReader = new Scanner(Pi_name);
                            String header = nameReader.nextLine();
                            jLabel1.setText("KLINGET");
                            jLabel1.setIcon(new javax.swing.ImageIcon("/var/www/html/images/bell.png"));
                            Thread.sleep(3000);// After 5 seconds
                            jLabel1.setIcon(new javax.swing.ImageIcon("/var/www/html/images/rapi_logo.png"));
                            jLabel1.setText(" "+header);
                            Process p1 = Runtime.getRuntime().exec("sudo python /home/pi/pi-rfid/opentest.py");

                        }
                        catch(Exception e)
                        {
                        }
                        jLabel1.setIcon(new ImageIcon("/var/www/html/images/rapi_logo.png"));
                    }
                });
                tp.start();


        }
        msgReader.close();
        redirectReader.close();


        // Colleting resident name information included date & time  to save in the log file
        String name = jButton1.getText();
        String time = jLabel2.getText();
        String info = "Door Bell rang at";

        Date d = new Date();

        SimpleDateFormat t = new SimpleDateFormat(" dd MMMM yyyy");
        String date=(t.format(d));

        String notify = (name+" "+info+" "+time+ " "+" "+date);

        File mFile = new File("/var/www/html/docs/doorbell log.txt");
        BufferedReader in = new BufferedReader(new FileReader("/var/www/html/docs/doorbell log.txt"));
        String result = "";
        String line ="";

        while ((line = in.readLine()) != null) {
            result = result +"\r\n"+ line;

        }
        result = notify + result;
        mFile.delete();
        FileOutputStream fos = new FileOutputStream(mFile);
        fos.write(result.getBytes());
        fos.flush();




    } // end of jButton1_ActionPerformed

    public void jButton2_ActionPerformed(ActionEvent evt) throws IOException {
        File msgs = new File("/var/www/html/docs/Messages.txt");
        File redirect = new File("/var/www/html/docs/Cheak_user.txt");

        Scanner msgReader = new Scanner(msgs);
        Scanner redirectReader = new Scanner(redirect);

        while (msgReader.hasNextLine()||redirectReader.hasNext()) {

            String redir = redirectReader.nextLine();
            String[] rdi = redir.split("_");
            String rdi2= rdi[3];

            //Splits messages.txt and Gets the resident placed message
            String msg = msgReader.nextLine();
            String[] Msg = msg.split("/");
            //Message for first user is in  array postion [1]
            String msg2= Msg[1];

            if (rdi2.contains("Away")) {

                // block of code to be executed if the condition is true

                    String path = "/var/www/html/images/usr2Quote.png";
                    String new_msg = msg2;
                    String name = jButton2.getText();
                    notice_board board = new notice_board();
                    board.display(new_msg);
                    board.display_name(name);
                    board.display_img(path);


            }
                Thread tp=new Thread(new Runnable() {

                    public void run()
                    {
                        try
                        {
                            File Pi_name = new File("/var/www/html/docs/doorText.txt");
                            Scanner nameReader = new Scanner(Pi_name);
                            String header = nameReader.nextLine();
                            jLabel1.setText("KLINGET");
                            jLabel1.setIcon(new javax.swing.ImageIcon("/var/www/html/images/bell.png"));
                            Thread.sleep(3000);// After 5 seconds
                            jLabel1.setIcon(new javax.swing.ImageIcon("/var/www/html/images/rapi_logo.png"));
                            jLabel1.setText(" "+header);
                            Process p1 = Runtime.getRuntime().exec("sudo python /home/pi/pi-rfid/opentest.py");
                        }
                        catch(Exception e)
                        {

                        }
                    }
                });
                tp.start();

        }
        msgReader.close();
        redirectReader.close();
        String name = jButton2.getText();
        String time = jLabel2.getText();
        String info = "Door Bell rang at";

        Date d = new Date();


        SimpleDateFormat t = new SimpleDateFormat(" dd MMMM yyyy");
        String date=(t.format(d));

        String notify = (name+" "+info+" "+time+ " "+" "+date);

        File mFile = new File("/var/www/html/docs/doorbell log.txt");
        BufferedReader in = new BufferedReader(new FileReader("/var/www/html/docs/doorbell log.txt"));
        String result = "";
        String line ="";

        while ((line = in.readLine()) != null) {
            result = result +"\r\n"+ line;

        }
        result = notify + result;
        mFile.delete();
        FileOutputStream fos = new FileOutputStream(mFile);
        fos.write(result.getBytes());
        fos.flush();

    } // end of jButton2_ActionPerformed

    public void jButton3_ActionPerformed(ActionEvent evt) throws IOException {
        File msgs = new File("/var/www/html/docs/Messages.txt");
        File redirect = new File("/var/www/html/docs/Cheak_user.txt");

        Scanner msgReader = new Scanner(msgs);
        Scanner redirectReader = new Scanner(redirect);

        while (msgReader.hasNextLine()||redirectReader.hasNext()) {

            String redir = redirectReader.nextLine();
            String[] rdi = redir.split("_");
            String rdi5= rdi[5];

            //Splits messages.txt and Gets the user based message
            String msg = msgReader.nextLine();
            String[] Msg = msg.split("/");
            //Message for first user is in  array postion [1]
            String msg3= Msg[2];

            if (rdi5.contains("Away")  ) {
                // block of code to be executed if the condition is true


                    String path = "/var/www/html/images/usr3Quote.png";
                    String new_msg = msg3;
                    String name = jButton1.getText();
                    notice_board board = new notice_board();
                    board.display(new_msg);
                    board.display_name(name);
                    board.display_img(path);

            }

        }
                 msgReader.close();
                 redirectReader.close();

            Thread tp=new Thread(new Runnable() {

                public void run()
                {

                    try
                    {

                        File Pi_name = new File("/var/www/html/docs/doorText.txt");
                        Scanner nameReader = new Scanner(Pi_name);
                        String header = nameReader.nextLine();
                        jLabel1.setText("KLINGET");
                        jLabel1.setIcon(new javax.swing.ImageIcon("/var/www/html/images/bell.png"));
                        Thread.sleep(3000);// After 5 seconds
                        jLabel1.setIcon(new javax.swing.ImageIcon("/var/www/html/images/rapi_logo.png"));
                        jLabel1.setText(" "+header);
                        Process p1 = Runtime.getRuntime().exec("sudo python /home/pi/pi-rfid/opentest.py");
                    }
                    catch(Exception e)
                    {

                    }
                    jLabel1.setIcon(new ImageIcon("/var/www/html/images/rapi_logo.png"));
                }
            });
            tp.start();
        String name = jButton3.getText();
        String time = jLabel2.getText();
        String info = "Door Bell rang at";

        Date d = new Date();

        SimpleDateFormat t = new SimpleDateFormat(" dd MMMM yyyy");
        String date=(t.format(d));

        String notify = (name+" "+info+" "+time+ " "+" "+date);

        File mFile = new File("/var/www/html/docs/doorbell log.txt");
        BufferedReader in = new BufferedReader(new FileReader("/var/www/html/docs/doorbell log.txt"));
        String result = "";
        String line ="";

        while ((line = in.readLine()) != null) {
            result = result +"\r\n"+ line;

        }
        result = notify + result;
        mFile.delete();
        FileOutputStream fos = new FileOutputStream(mFile);
        fos.write(result.getBytes());
        fos.flush();



    } // end of jButton3_ActionPerformed

    public void jButton4_ActionPerformed(ActionEvent evt) {
        keypad.main(new String[]{});

    }



}

class GradientPanel extends JPanel {

    private static final int WIDE = 480;
    private static final int HIGH = 20;
    private static final float HUE_MIN = 0;
    private static final float HUE_MAX = 1;
    private final Timer timer;
    private float hue = HUE_MIN;
    private Color color1 = Color.white;
    private Color color2 = Color.gray;
    private float delta = 0.01f;

    GradientPanel() {
        ActionListener action = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                hue += delta;
                if (hue > HUE_MAX) {
                    hue = HUE_MIN;
                }
                color1 = Color.getHSBColor(hue, 1, 1);
                color2 = Color.getHSBColor(hue + 16 * delta, 1, 1);
                repaint();
            }
        };
        timer = new Timer(50, action);
        timer.start();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint p = new GradientPaint(
                0, 0, color1, getWidth(), 0, color2);
        g2d.setPaint(p);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDE, HIGH);
    }
}
