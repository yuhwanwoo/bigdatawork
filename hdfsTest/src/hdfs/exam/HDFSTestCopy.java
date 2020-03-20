package hdfs.exam;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSTestCopy {

	public static void main(String[] args) {
	Configuration conf = new Configuration();
		
		FileSystem hdfs= null;
		
		FSDataInputStream hdfsinput=null;
		FSDataOutputStream hdfsout = null;
		
		try {
			hdfs=FileSystem.get(conf);
			
			Path inPath = new Path(args[0]);
			Path outpath = new Path(args[1]);
			
			hdfsinput=hdfs.open(inPath);
			hdfsout = hdfs.create(outpath);
			while(true) {
				int data = hdfsinput.read();
				System.out.println((char)data);
				if(data==-1) {
					break;
				}
				hdfsout.write((char)data);
			}
			//String inputString=hdfsinput.readUTF(); 여기가 output.txt의 hellohadoop 읽는거
			
			//System.out.println(inputString);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
}
