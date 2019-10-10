package serversocketuygulamasi;

import java.io.*;
import java.net.*;

public class Kullanici {
     public static void main(String[] args) throws UnknownHostException, IOException{
        Socket socket = null;
          PrintWriter out = null;
          BufferedReader in = null;
          String deger;
          try {
               socket = new Socket("192.168.86.129", 3002);
          } catch (Exception e) {
               System.out.println("Port Hatası!");
          }
          out = new PrintWriter(socket.getOutputStream(), true);

          in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 
          System.out.println("Sunucu'ya gönderilecek bir sayı giriniz :");

          BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
 
          while((deger = data.readLine()) != null) {
               out.println(deger);
               System.out.println("Sunucu'dan dönen sonuç = " + in.readLine());
               System.out.println("Sunucu'ya gönderilecek sayı giriniz :");
          }
          
          out.close();
          in.close();
          data.close();
          socket.close();
    }
}
