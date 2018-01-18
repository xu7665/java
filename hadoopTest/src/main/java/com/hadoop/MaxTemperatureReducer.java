package com.hadoop;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxTemperatureReducer extends Reducer{

    //@Override
    public void reduce(Text key,Iterable<IntWritable> values,Context context) throws IOException,InterruptedException{
        int maxVaule = Integer.MIN_VALUE;
        for(IntWritable value : values){
            maxVaule = Math.max(maxVaule,value.get());
        }
        context.write(key,new IntWritable(maxVaule));
    }
}
