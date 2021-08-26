import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

/**
 *
 * Description
 *
 * @version 1.0 from 01/06/2021
 * @author
 */

public class notice_board extends JFrame {
    // start attributes
    private JPanel background_Panl = new JPanel(null, true);
    private JLabel Qr_code_lbl = new JLabel();
    private JLabel Qr_icon_Lbl = new JLabel();
    private JLabel top_titile = new JLabel();
    private JLabel User_tag_Lbl = new JLabel();
    private JButton close_Btn = new JButton();
    // end attributes
    public void display (String new_msg ){

        top_titile.setText(new_msg);
        top_titile.setFont(new Font("Tohoma", Font.BOLD, 25));


    }
    public void display_img(String path) {
        Qr_code_lbl.setIcon(new javax.swing.ImageIcon(path));
    }
    public void display_name(String name){ User_tag_Lbl.setText(name); }

    public notice_board() {
        // Frame-Init
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 502;
        int frameHeight = 363;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("notice_board");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);

        // start components

        background_Panl.setBounds(1, 0, 484, 324);
        background_Panl.setOpaque(true);
        background_Panl.setBackground(new java.awt.Color(255, 255, 255));
        cp.add(background_Panl);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        URL resource2 = classLoader.getResource("img/QR_scan_1_1.png");

        Qr_code_lbl.setBounds(236, 87, 230, 172);

        Qr_code_lbl.setText("");
        background_Panl.add(Qr_code_lbl);
        Qr_icon_Lbl.setBounds(31, 92, 190, 172);
        Qr_icon_Lbl.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Qr_icon_Lbl.setIcon(new ImageIcon("img/QR_scan_1_1.png"));
        Qr_icon_Lbl.setText("Scan & Message");
        Qr_icon_Lbl.setHorizontalTextPosition(JLabel.CENTER);
        Qr_icon_Lbl.setVerticalTextPosition(JLabel.TOP);
        background_Panl.add(Qr_icon_Lbl);
        top_titile.setBounds(20, 11, 438, 60);
        top_titile.setHorizontalAlignment(SwingConstants.CENTER);
        top_titile.setText("NOCTICE BOARD");
        background_Panl.add(top_titile);

        User_tag_Lbl.setText("Usertag");
        User_tag_Lbl.setBounds(38, 254, 190, 36);
        User_tag_Lbl.setHorizontalTextPosition(JLabel.CENTER);
        background_Panl.add(User_tag_Lbl);
        close_Btn.setBounds(153, 274, 190, 41);
        close_Btn.setText("Close");
        close_Btn.setMargin(new Insets(2, 2, 2, 2));
        close_Btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2_ActionPerformed(evt);
                dispose();
            }
        });
        background_Panl.add(close_Btn);
        background_Panl.setFont(new Font("Dialog", Font.PLAIN, 14));
        background_Panl.setBounds(1, -6, 484, 324);
        User_tag_Lbl.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N


        // end components

        setVisible(true);




    } // end of public notice_board

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
            java.util.logging.Logger.getLogger(notice_board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(notice_board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(notice_board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(notice_board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        new notice_board();
    } // end of main

    public void jButton1_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    } // end of jButton1_ActionPerformed

    public void jButton2_ActionPerformed(ActionEvent evt) {
        // TODO add your code here

    }




    // end methods
} // end of class notice_board
