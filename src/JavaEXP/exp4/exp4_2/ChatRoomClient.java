package JavaEXP.exp4.exp4_2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatRoomClient {
    private Socket socket; // �ͻ����׽���
    private BufferedReader bufferedReader; // �ֽ�����ȡ�׽���������
    private PrintWriter pWriter; // �ֽ���д���׽��������

    /*
     * �����ҿͻ��˹��췽��
     * @param host
     *          ������ IP ��ַ
     * @param port
     *          ��������ͻ��˻����Ķ˿�
     */
    public ChatRoomClient(String host, int port) throws UnknownHostException, IOException {
        socket = new Socket( host, port ); // ���ӷ�����
        bufferedReader = new BufferedReader( new InputStreamReader( socket.getInputStream() ) ); // �ֽ�����ȡ�׽���������
        pWriter = new PrintWriter( socket.getOutputStream() ); // �ֽ���д���׽��������
    }

    /*
     * �����ҿͻ��˷�����Ϣ�ķ���
     * @param str �ͻ��˷��͵���Ϣ
     */
    public final void sendMessage(String str) {
        pWriter.println( str );
        pWriter.flush();
    }

    /*
     * ����ͻ��˻�ȡ��Ϣ�ķ���
     * @return ��ȡĳ���ͻ��˷��͵���Ϣ
     */
    final String receiveMessage() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /*
     * �ر��׽���
     */
    public final void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
