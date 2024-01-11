package com.winter.app.products;

import com.winter.app.files.FileDTO;

public class ProductFileDTO extends FileDTO{
	private Long productNum;

	public Long getProductNum() {
		return productNum;
	}

	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
}
