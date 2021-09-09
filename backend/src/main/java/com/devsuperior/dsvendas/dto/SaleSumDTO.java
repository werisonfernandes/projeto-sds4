package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

public class SaleSumDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sellerName;
	private double sum;

	public SaleSumDTO() {
		super();
	}

	public SaleSumDTO(String sellerName, double sum) {
		this();
		this.sellerName = sellerName;
		this.sum = sum;
	}

	public SaleSumDTO(Seller seller, double sum) {
		this(seller.getName(), sum);
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "SalesSumDTO [sellerName=" + sellerName + ", sum=" + sum + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sellerName == null) ? 0 : sellerName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(sum);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		SaleSumDTO other = (SaleSumDTO) obj;
		if (sellerName == null) {
			if (other.sellerName != null)
				return false;
		} else if (!sellerName.equals(other.sellerName))
			return false;
		if (Double.doubleToLongBits(sum) != Double.doubleToLongBits(other.sum))
			return false;
		return true;
	}

}
