package mapred.exam.stock.multiple;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StockMultipleMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	String jobType;
	static final IntWritable outputVal = new IntWritable(1);
	Text outputKey = new Text(); // output key
	// output Value
	static final IntWritable one = new IntWritable(1);

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		if (key.get() > 0) {
			String[] line = value.toString().split(",");
			if (line != null & line.length > 0) {
				
				String year = line[2].substring(0, 4);
				
				double result = Double.parseDouble(line[6]) - Double.parseDouble(line[3]);
					if (result > 0) {// 상승마감
						outputKey.set("up,"+year);
						context.write(outputKey, one);
					}else if (result < 0) {// 하락마감
						outputKey.set("down,"+year);
						context.write(outputKey, one);
					} else 
						outputKey.set("equal,"+year);
						context.write(outputKey, one);
				}

			}
		}
	}

