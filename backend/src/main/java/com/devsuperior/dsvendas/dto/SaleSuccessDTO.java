package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

public class SaleSuccessDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String sellerName;
	private long visited;
	private long deals;

	public SaleSuccessDTO() {
		super();
	}

	public SaleSuccessDTO(String sellerName, long visited, long deals) {
		this();
		this.sellerName = sellerName;
		this.visited = visited;
		this.deals = deals;
	}

	public SaleSuccessDTO(Seller seller, long visited, long deals) {
		this(seller.getName(), visited, deals);
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public long getVisited() {
		return visited;
	}

	public void setVisited(long visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return "SaleSuccessDTO [sellerName=" + sellerName + ", visited=" + visited + ", deals=" + deals
				+ ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (deals ^ (deals >>> 32));
		result = prime * result + ((sellerName == null) ? 0 : sellerName.hashCode());
		result = prime * result + (int) (visited ^ (visited >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleSuccessDTO other = (SaleSuccessDTO) obj;
		if (deals != other.deals)
			return false;
		if (sellerName == null) {
			if (other.sellerName != null)
				return false;
		} else if (!sellerName.equals(other.sellerName))
			return false;
		if (visited != other.visited)
			return false;
		return true;
	}

}
