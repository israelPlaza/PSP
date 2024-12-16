import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
public static void main(String[] args) throws UnknownHostException 
{
  byte[] bytes;
  InetAddress fullname = InetAddress.getByName("www.upm.es");
  InetAddress local = InetAddress.getLocalHost();
  System.out.println ("HostName:"+fullname.getHostName());
  System.out.println ("HostAdress:"+fullname.getHostAddress());
  System.out.println ("Local Name:"+local.getHostName());
  System.out.println ("Local Adress:"+local.getHostAddress());
  bytes = fullname.getAddress();
  for (byte b : bytes)
   System.out.print(b+" ");
  System.out.println();
  for (byte b : bytes)
   System.out.print((b&0xFF)+" ");  
}
}
