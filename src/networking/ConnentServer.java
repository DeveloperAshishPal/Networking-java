package networking;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ConnentServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path = "/home/insanenoise/workspace/kbc/mydb";
		System.out.println("Enter the URl to connect....");
		String urlValue = new Scanner(System.in).next();
		String fileName = urlValue.substring(urlValue.lastIndexOf("/"));
		FileOutputStream fo = new FileOutputStream(path+fileName);
		System.out.println(urlValue);
		System.out.println(fileName);
		System.out.println(path+fileName);
		URL url = new URL(urlValue);
		URLConnection connection = url.openConnection();
		connection.connect();
		InputStream is = connection.getInputStream();
		int singleByte = is.read();
		while(singleByte!=-1){
			fo.write(singleByte);
			//System.out.print((char)singleByte);
			singleByte = is.read();
		}
		fo.close();
		is.close();
	}

}
