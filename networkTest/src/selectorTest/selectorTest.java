package selectorTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class selectorTest {
	public static void main(String[] args) throws IOException {
		
		int[] ports = new int[3];
		ports[0] = 8189;
		ports[1] = 5001;
		ports[2] = 5002;
		
		myServer server = new myServer(ports);
		
		server.go();
		
	}
	

}

class myServer
{
	private int[] ports;
	private ByteBuffer echoBuffer = ByteBuffer.allocate( 1024 );

	public myServer(int[] ports) {
		this.ports = ports;
	}
	
	public void go() throws IOException
	{
		Selector select = Selector.open();
		for (int i = 0; i < ports.length; i++)
		{
			ServerSocketChannel ssc = ServerSocketChannel.open();
			ssc.configureBlocking(false);			
			ServerSocket sock = ssc.socket();
			
			sock.bind(new InetSocketAddress( ports[i] ));
			
			
			
			ssc.register(select, SelectionKey.OP_ACCEPT);	
			
			System.out.println("Going to accept port:" + ports[i]);
		}
		
		while (true)
		{
			int num = select.select();
			
			Set<SelectionKey> selectKeys = select.selectedKeys();
			
			Iterator it = selectKeys.iterator();
			
			while (it.hasNext())
			{
				SelectionKey key = (SelectionKey) it.next();
				
				if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT)
				{
					ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
					
					SocketChannel sc = ssc.accept();
			        sc.configureBlocking( false );

			        // Add the new connection to the selector
			        SelectionKey newKey = sc.register( select, SelectionKey.OP_READ );
			        it.remove();
				}
				else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ)
				{
					SocketChannel sc = (SocketChannel)key.channel();
					
//					Scanner scanner = new Scanner(sc);
//					
					int bytesEchoed = 0;
//					String recvStr = null;
//					while (scanner.hasNextLine())
//					{
//						recvStr = scanner.nextLine();
//						System.out.println(recvStr);
//						
//						bytesEchoed += recvStr.length();
//						
//						if (recvStr.contains("@"))
//						{
//							//sc.close();
//							break;
//						}
//						
//					}
//					System.out.println( "Echoed "+bytesEchoed+" from "+sc );
//					if (recvStr.contains("@"))
//					{
//						sc.close();
//						
//					}
//			        it.remove();	
					
					// Echo data   
			          while (true) {
			            echoBuffer.clear();

			            int r = sc.read( echoBuffer );
			            System.out.println("r: " + r);

			            if (r==0) {  //client如果连接上服务器，发了一个字符，然后不发了，这边的r为0，回break掉，等再收到字符时进来，Great!
			            	
			                break;
			            }
			            if (r == -1)
			            {
			            	sc.close();
			            	//sc.socket().close();
			            	break;
			            }

			            echoBuffer.flip();

			            sc.write( echoBuffer );
			            bytesEchoed += r;
			          }
	          
			          System.out.println( "Echoed "+bytesEchoed+" from "+sc );
			          

			          it.remove();	
			          
			          
				}		
				
			}			
		}	
		
		
	}
	
	
	
	
	
	
}
