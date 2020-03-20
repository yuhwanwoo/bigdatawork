package mapreduce.product;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

import mapreduce.air.sort.CustomKey;

public class MyKey implements WritableComparable<MyKey> {
	
	private String productId;
	private String userId;
	
	public MyKey() {
	
	}

	
	


	public String getProductId() {
		return productId;
	}





	public void setProductId(String productId) {
		this.productId = productId;
	}





	public String getUserId() {
		return userId;
	}





	public void setUserId(String userId) {
		this.userId = userId;
	}





	@Override
	public String toString() {
		return (new StringBuffer()).append(productId).append(",").append(userId).toString();
				
	}



	@Override
	public void write(DataOutput out) throws IOException {
		WritableUtils.writeString(out, productId);
		WritableUtils.writeString(out, userId);
		
	}
	
	//역직렬화될 때 호출
	@Override
	public void readFields(DataInput in) throws IOException {
		productId=WritableUtils.readString(in);
		userId=WritableUtils.readString(in);
	}

	//사용자가 만들어 놓은 키를 기준으로 정렬하기 위해서 비교하게 할 메소드
	//year로 비교 year가 같으면 month로 비교
	@Override
	public int compareTo(MyKey obj) {
		int result=productId.compareTo(obj.productId);
		if(result==0) { //year가 같다
			result=userId.compareTo(obj.userId);
		}
		return result;
	}
	
	
}
