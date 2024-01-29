package com.winter.app.product;

import java.util.List;

import com.winter.app.account.AccountDTO;

public class ProductDTO {
	private Long productNum;
	private String productName;
	private String productContents;
	private Double productRate;
	private Double productJumsu;
	private Double productCount;
	private Integer productSale;
	
	private List<ProductFileDTO> fileDTOs;
	
	private List<AccountDTO> accountDTOs;
	
	private List<ReplyDTO> replyDTOs;
	
	
	public List<ReplyDTO> getReplyDTOs() {
		return replyDTOs;
	}
	public void setReplyDTOs(List<ReplyDTO> replyDTOs) {
		this.replyDTOs = replyDTOs;
	}
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductContents() {
		return productContents;
	}
	public void setProductContents(String productContents) {
		this.productContents = productContents;
	}
	public Double getProductRate() {
		return productRate;
	}
	public void setProductRate(Double productRate) {
		if(productRate==null || productRate<0) {
			productRate = 0.0;
		}
		this.productRate = productRate;
	}
	public Double getProductJumsu() {
		return productJumsu;
	}
	public void setProductJumsu(Double productJumsu) {
		this.productJumsu = productJumsu;
	}
	public Double getProductCount() {
		return productCount;
	}
	public void setProductCount(Double productCount) {
		this.productCount = productCount;
	}
	public Integer getProductSale() {
		return productSale;
	}
	public void setProductSale(Integer productSale) {
		this.productSale = productSale;
	}
	public List<ProductFileDTO> getFileDTOs() {
		return fileDTOs;
	}
	public void setFileDTOs(List<ProductFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}
	public List<AccountDTO> getAccountDTOs() {
		return accountDTOs;
	}
	public void setAccountDTOs(List<AccountDTO> accountDTOs) {
		this.accountDTOs = accountDTOs;
	}
	
	
	
}
