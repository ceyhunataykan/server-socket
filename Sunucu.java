import java.io.*;
import java.net.*;

public class Sunucu {

	public static void main(String[] args) throws IOException{
		
		String kullaniciGelen;
        ServerSocket sunucuSocket = null;
        Socket kullaniciSocket = null;

        int sayi;

        try {
             sunucuSocket = new ServerSocket(3002);
        } catch (Exception e) {
             System.out.println("Port Hatası!");
        }
        System.out.println("Sunucu Başladı...");

        kullaniciSocket = sunucuSocket.accept();

        PrintWriter out = new PrintWriter(kullaniciSocket.getOutputStream(), true);

        BufferedReader in = new BufferedReader(new InputStreamReader(kullaniciSocket.getInputStream()));

        while((kullaniciGelen = in.readLine()) != null) {
             System.out.println("Kullanıcı'dan gelen veri = " + kullaniciGelen);
             sayi = Integer.valueOf(kullaniciGelen);
             out.println(sayi*sayi);
        }
        out.close();
        in.close();
        kullaniciSocket.close();
        sunucuSocket.close();

	}
}
