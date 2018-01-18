package com;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Before;
import org.junit.Test;



import java.io.IOException;

public class HdfsClientDemo {
    @Before
    public void init() throws IOException {
        Configuration conf = new Configuration();

        FileSystem fs = FileSystem.get(conf);
        fs.copyFromLocalFile(new Path("c:/ac"),new Path(""));

    }
    @Test
    public void testUpload(){
      //  fs.copyFromLocalFile(new Path("c:/ac"))
    }
}
