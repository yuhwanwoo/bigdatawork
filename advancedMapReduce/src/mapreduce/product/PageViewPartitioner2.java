package mapreduce.product;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

//Partitioner클래스에는 Mapper의 key와 value타입을 generic으로 명시
//year를 기준으로 해시코드를 구해서 같은 year를 갖고 있는 데이터를 같은 리듀서에서 작업할 수 있도록
//=>같은 것끼리 메모리버퍼에 쌓았다가 한꺼번에 전송
public class PageViewPartitioner2 extends Partitioner<MyKey, Text>{

	//numPartitions는 파티션의 개수 = 리듀스태스크의 개수
	@Override
	public int getPartition(MyKey key, Text value, int numPartitions) {
		
		return key.getProductId().hashCode() % numPartitions;
	}
	
}
