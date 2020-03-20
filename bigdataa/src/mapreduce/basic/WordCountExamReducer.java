package mapreduce.basic;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//Reducer - 데이터를 집계하는 역할
/*
 * 1.Reducer클래스를 상속
 * 2. reduce메소드를 오버라이딩
 */
public class WordCountExamReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	
	IntWritable resultVal=new IntWritable();
	Text appenddata = new Text();
	String data="";
	Text resultKey=new Text();
	
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {

		
		int sum=0;
		/*data=data+"reduce호출";
		appenddata.set(data);*/
		for(IntWritable value:values) { 
			sum= sum+value.get();
		}
		resultVal.set(sum);
		resultKey.set(key);
		context.write(resultKey,resultVal);
	}
	
	

}
