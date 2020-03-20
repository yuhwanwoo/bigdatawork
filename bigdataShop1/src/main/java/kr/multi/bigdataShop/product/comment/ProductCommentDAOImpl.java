package kr.multi.bigdataShop.product.comment;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("productDao")
public class ProductCommentDAOImpl implements ProductCommentDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insert(ProductCommentDTO product) {
		// TODO Auto-generated method stub
		return sqlSession.insert("kr.multi.bigdataShop.product.comment.insert",product);
	}

	@Override
	public List<ProductCommentDTO> read(String prd_no) {
		return sqlSession.selectList("kr.multi.bigdataShop.product.comment.select",prd_no);
	}
	
	
}
