package shop.bigdata.comment;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CommentWordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	static final IntWritable outputVal = new IntWritable(1);
	Text outputKey = new Text();
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		if(key.get()>0) {
			String[] str = value.toString().split(",");
			
			Pattern p = Pattern.compile("은|는|이|가|요|서");
			Matcher m = p.matcher(str[2]);
			
			StringBuffer sb = new StringBuffer();
			while(m.find()) {
				String data = m.group();
				m.appendReplacement(sb, "");
			}
			m.appendTail(sb);
			
			String[] line = sb.toString().split(" ");
			
			if(line!=null & line.length > 0) {
				for(int i=0;i<line.length;i++) {
					if(!line[i].equals("")) {
						outputKey.set(line[i]);
						context.write(outputKey, outputVal);
					}
				}
			}
		}
	}
}
