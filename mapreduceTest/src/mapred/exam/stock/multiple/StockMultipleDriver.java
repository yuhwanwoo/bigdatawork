package mapred.exam.stock.multiple;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import mapred.basic.WordCountDriver;
import mapred.basic.WordCountMapper;
import mapred.basic.WordCountReducer;
import mapred.exam.air.option.AirOptionDriver;
import mapred.exam.air.option.AirOptionMapper;
import mapred.exam.air.option.AirOptionReducer;
import mapred.exam01.WordCountDriverExam;

public class StockMultipleDriver extends Configured implements Tool{
	
	@Override
	public int run(String[] optionlist) throws Exception {

		GenericOptionsParser parser = new GenericOptionsParser(getConf(),optionlist );
		String[] otherArgs = parser.getRemainingArgs();
		Job job = new Job(getConf(), "stock_multi");
		
		
		job.setMapperClass(StockMultipleMapper.class);
		job.setReducerClass(StockMultipleReducer.class);
		job.setJarByClass(StockMultipleDriver.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
		
		MultipleOutputs.addNamedOutput(job, "up", TextOutputFormat.class, Text.class,IntWritable.class);
		MultipleOutputs.addNamedOutput(job, "equal", TextOutputFormat.class, Text.class,IntWritable.class);
		MultipleOutputs.addNamedOutput(job, "down", TextOutputFormat.class, Text.class,IntWritable.class);
		job.waitForCompletion(true);
		
		return 0;
	}
		
	public static void main(String[] args) throws Exception {
		ToolRunner.run(new Configuration(), new StockMultipleDriver(), args);
	}
}