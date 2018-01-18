package com.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteHDFS {
    private Configuration conf;
    private FileSystem fs;
    @Before
    public void iniConf(){
        try {
            Configuration conf = new Configuration();
            fs = FileSystem.get(conf);
        } catch (Exception e) {

        }
    }




    @Test
    public void writeFile() throws Exception{
        Configuration conf = new Configuration();
        conf.set("fs.default.name", "hdfs://192.168.189.158:9000");
        FileSystem fs = FileSystem.get(conf);
        fs.copyFromLocalFile(new Path("F://ff.txt"), new Path("/usr/lvtu.txt"));
        //Path path = new Path("hdfs://192.168.189.158:9000/usr/lvtu.txt");
        //FSDataOutputStream dos = fs.create(path);
        //dos.write("hehe".getBytes());

        //Hadoop自带的复制
        //IOUtils.copyBytes();
//        fs.close();
        System.out.println("over...............");
    }
    @Test
    public void readFile() throws  Exception{
        //conf.set("fs.default.name", "hdfs://192.168.189.158:9000");
        Path path = new Path("hdfs://192.168.189.158:9000/usr/lvtu.txt");
        FSDataInputStream fis = fs.open(path);
        FileOutputStream fos = new FileOutputStream("d:/hehe.txt");
        IOUtils.copyBytes(fis,fos,1024);
        IOUtils.closeStream(fis);
        IOUtils.closeStream(fos);
        System.out.println("oooooooooopp");
    }
}
