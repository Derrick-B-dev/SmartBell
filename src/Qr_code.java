

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Derrick
 */
public class Qr_code {

    /**
     * Creates new form Qr_code
     */





    public static void generateQRcode(String data, String path, String charset, Map map, int h, int w) throws WriterException, IOException
    {
//the BitMatrix class represents the 2D matrix of bits
//MultiFormatWriter is a factory class that finds the appropriate Writer subclass for the BarcodeFormat requested and encodes the barcode with the supplied contents.
        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, w, h);
        MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
    }



    @SuppressWarnings("unchecked")



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws WriterException, IOException {


        //data that we want to store in the QR code
        try {

            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Qr_code.class.getClass().getResourceAsStream("/home/pi/Desktop/redirect.txt");
            File reMsg = new File("/home/pi/Desktop/redirect.txt");
            Scanner msgReader = new Scanner(reMsg);
            while (msgReader.hasNextLine()) {
                String msg = msgReader.nextLine();
                String[] user = msg.split("_");
                String msg1= user[0];
                String msg2= user[1];
                String msg3= user[2];

//path where we want to get QR Code
                String path = "/var/www/html/images/usr1Quote.png";
                String path1 = "/var/www/html/images/usr2Quote.png";
                String path2 = "/var/www/html/images/usr3Quote.png";
                String pathhtml = "/var/www/html/images/usr1Quotexml.png";
                String pathhtml2 = "/var/www/html/images/usr2Quotexml.png";
                String pathhtml3 = "/var/www/html/images/usr3Quotexml.png";
//Encoding charset to be used
                String charset = "UTF-8";
                Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
//generates QR code with Low level(L) error correction capability
                hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//invoking the user-defined method that creates the QR code
                generateQRcode(msg1, path, charset, hashMap, 250, 250);//increase or decrease height and width accodingly
                generateQRcode(msg2, path1, charset, hashMap, 250, 250);
                generateQRcode(msg3, path2, charset, hashMap, 250, 250);
                generateQRcode(msg1, pathhtml, charset, hashMap, 450, 450);//increase or decrease height and width accodingly
                generateQRcode(msg2, pathhtml2, charset, hashMap, 450, 450);
                generateQRcode(msg3, pathhtml3, charset, hashMap, 450, 450);
                System.out.println(msg2);
//prints if the QR code is generated
                System.out.println("QR Code created successfully.");

            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

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
            java.util.logging.Logger.getLogger(Qr_code.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Qr_code.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Qr_code.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Qr_code.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */



    }



}
