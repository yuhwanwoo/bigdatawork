package kr.multi.bigdataShop.product.comment;

import java.sql.Date;

public class ProductCommentDTO {
	String prd_no;
	String mem_id;
	String pro_comment;
	Date write_date;
	
	public ProductCommentDTO() {
		
	}

	@Override
	public String toString() {
		return "ProductCommentDTO [prd_no=" + prd_no + ", mem_id=" + mem_id + ", pro_comment=" + pro_comment
				+ ", write_date=" + write_date + "]";
	}

	public String getPrd_no() {
		return prd_no;
	}

	public void setPrd_no(String prd_no) {
		this.prd_no = prd_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getPro_comment() {
		return pro_comment;
	}

	public void setPro_comment(String pro_comment) {
		this.pro_comment = pro_comment;
	}

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	
	
}
