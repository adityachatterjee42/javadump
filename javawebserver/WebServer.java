import java.net.ServerSocket;
import java.net.Socket;

public final class WebServer{
    public static void main(String args[]){
        try{
            ServerSocket serversocket = new ServerSocket(3333);
            while(true){
                Socket connection = serversocket.accept();
                HttpRequest request = new HttpRequest(connection);
                Thread thread = new Thread(request);
                thread.start();
            }
        }catch(Exception E){
            System.out.println(E.toString());
        }
    }
}
