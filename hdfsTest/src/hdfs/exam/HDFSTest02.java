package hdfs.exam;

import java.io.IOException;
import java.io.InputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSTest02 {

	public static void main(String[] args) {

		Configuration conf = new Configuration();
		
		FileSystem hdfs= null;
		
		FSDataInputStream hdfsinput=null;
		
		try {
			hdfs=FileSystem.get(conf);
			
			Path path = new Path(args[0]);
			
			hdfsinput=hdfs.open(path);
			
			String inputString=hdfsinput.readUTF();
			
			System.out.println(inputString);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
