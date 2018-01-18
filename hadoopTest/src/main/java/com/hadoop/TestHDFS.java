package com.hadoop;

//import java.io.IOException;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class TestHDFS {
    public static void main(String[] args) throws Exception {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
        String url = "hdfs://192.168.189.158:9000/usr/local/hello.txt";
        URL u = new URL(url);
        URLConnection conn = u.openConnection();
        InputStream is = conn.getInputStream();
        FileOutputStream fos = new FileOutputStream("f:/hello.txt");
        byte[] buf = new byte[1024];
        int len = -1;
        int offset = 0;
       // int i = is.read(buf);
        while((len = is.read(buf,offset,1024)) != -1){
            fos.write(buf,0,len);
            offset += len;
        }
        fos.flush();
        is.close();
        fos.close();
        System.out.println("haha_____is ok");
    }
}
