package kr.multi.bigdataShop.product.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductCommentServiceImpl implements ProductCommentService  {
	@Autowired
	@Qualifier("productDao")
	ProductCommentDAO dao;
	
	@Override
	public int insert(ProductCommentDTO product) {
		return dao.insert(product);
	}

	@Override
	public List<ProductCommentDTO> read(String prd_no) {
		return dao.read(prd_no);
	}

}
