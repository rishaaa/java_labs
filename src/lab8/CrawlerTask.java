package lab8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class CrawlerTask implements Runnable {
    URLPool urlPool;

    public CrawlerTask(URLPool pool) {
        this.urlPool = pool;
    }


    public void Search() throws IOException {
        Socket socket;
        URLDepthPair pair = urlPool.getPair();
        int depth = pair.get_depth();

        try {
            socket = new Socket(pair.get_host(), 80);
        } catch (UnknownHostException e) {
            System.err.println(e);
            return;
        }
        socket.setSoTimeout(4000);

        PrintWriter myWriter = new PrintWriter(socket.getOutputStream(), true);
        myWriter.println("GET " + pair.get_path() + " HTTP/1.1");
        myWriter.println("Host: " + pair.get_host());
        myWriter.println("Connection: close");
        myWriter.println();

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String input;

        while ((input = reader.readLine()) != null) {
            while (input.contains("a href=\"")) {
                String link;
                try {
                    input = input.substring(input.indexOf("a href=\"") + 8);
                    link = input.substring(0, input.indexOf('\"'));
                    if (!link.startsWith("http"))
                        link = link.startsWith("/") ? pair.get_link() + link : pair.get_link() + "/" + link;
                } catch (StringIndexOutOfBoundsException e) {
                    break;
                }
                urlPool.addPair(new URLDepthPair(link, depth + 1));
            }
        }
        reader.close();
        socket.close();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Search();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] msi) {
        msi = new String[]{"http://www.mtuci.ru/", "2", "4"};
        URLPool pool = new URLPool(Integer.parseInt(msi[1]));
        pool.addPair(new URLDepthPair(msi[0], 0));

        int numThread = Integer.parseInt(msi[2]);
        for (int m = 0; m < numThread; m++) {
            Thread thread = new Thread(new CrawlerTask(pool));
            thread.start();
        }
        while (pool.getWait() != numThread){ }

        int s = 0;
        for (URLDepthPair pair : pool.getChecked())
            System.out.printf("%-6s%-70s%5s%n",++s + ": " , pair.get_url(),"["+pair.get_depth()+"]");
        System.exit(0);
    }
}
