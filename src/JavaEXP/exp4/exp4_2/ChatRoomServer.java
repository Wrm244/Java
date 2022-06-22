package JavaEXP.exp4.exp4_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class ChatRoomServer {
    private ServerSocket serverSocket; // �������׽���
    private HashSet<Socket> allSockets; // �ͻ����׽��ּ���

    // �����ҹ��췽��
    public ChatRoomServer() {
        try {
            serverSocket = new ServerSocket(4569);
        } catch (IOException e) {
            e.printStackTrace();
        }
        allSockets = new HashSet<>(); //  ʵ�����ͻ����׽��ּ���
    }

    // ���������ҵķ���
    private void startService() throws IOException {
        int i = 0;
        while (true) {
            i++;
            Socket s = serverSocket.accept(); // ���һ���ͻ�������
            System.out.printf("�û�%d�Ѿ�����������\n", i);
            allSockets.add(s);
            new ServerThread(s).start();
        }
    }

    // �������߳��ڲ���
    private class ServerThread extends Thread {
        Socket socket; // �ͻ����׽���

        ServerThread(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            BufferedReader br = null;
            try {
                // ���ͻ����׽���������תΪ�ֽ�����ȡ
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (true) {
                    String str = br.readLine(); // ��ȡ��һ��֮����ֵ���ַ���
                    if (str.contains("%EXIT%")) { // ����ı����ݰ���"%EXIT%"
                        allSockets.remove(socket); // ����ɾ���˿ͻ�������
                        // �����������пͻ��˽ӿڷ����˳�֪ͨ
                        sendMessageToAllClient(str.split(":")[1] + "�û����˳�������");
                        socket.close();
                        return;
                    }
                    sendMessageToAllClient(str); // �����пͻ��˷��ʹ˿ͻ��˷��������ı���Ϣ
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /* *
         * ������Ϣ���ͻ��˵ķ���
         *
         * @param message
         */
        final void sendMessageToAllClient(String message) throws IOException {
            for (Socket s : allSockets) { // ѭ�����������еĿͻ�������
                PrintWriter pw = new PrintWriter(s.getOutputStream()); // ���������
                pw.println(message); // ����д���ı�
                pw.flush();
            }
        }


    }
    public static void main(String[] args) {
        try {
            new ChatRoomServer().startService();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
