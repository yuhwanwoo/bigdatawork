package kr.multi.bigdataShop.product.comment;

import java.util.List;

public interface ProductCommentDAO {
	int insert(ProductCommentDTO product);
	List<ProductCommentDTO> read(String prd_no);
}
