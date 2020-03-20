package mapred.exam.stock.option;

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

public class StockOptionDriver extends Configured implements Tool{
	
	@Override
	public int run(String[] optionlist) throws Exception {
		//run메소드는 사용자가 입력한 모든 옵션에 대한 정보를 String[]로 전달받는다.
		//-D를 입력하고 설정한 옵션과 사용자가 입력한 명령행매개변수를 분리하여 관리해야한다.
		//getRemainingArgs()를 이용하여 공통옵션(-D와 입력한 값 이외의 입력값)과 사용자가 입력한 옵션을 따로 분리한다.
		GenericOptionsParser parser = new GenericOptionsParser(getConf(),optionlist );
		String[] otherArgs = parser.getRemainingArgs();
		Job job = new Job(getConf(), "airoption");
		
		
		job.setMapperClass(StockOptionMapper.class);
		job.setReducerClass(StockOptionReducer.class);
		job.setJarByClass(StockOptionDriver.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
		
		job.waitForCompletion(true);
		
		return 0;
	}


		
	public static void main(String[] args) throws Exception {
		ToolRunner.run(new Configuration(), new StockOptionDriver(), args);
	}
}