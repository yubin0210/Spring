package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.model.ProductDTO;

@Repository
public interface productDAO {

	@Insert("insert into product (name, price, image, quantity) "
			+ "values (#{name}, #{price}, #{image}, #{quantity})")
	int insert(ProductDTO dto);

	@Select("select * from product order by idx")
	List<ProductDTO> selectList();

	@Select("select * from product where idx = #{idx}")
	ProductDTO selectOne(int idx);

}
