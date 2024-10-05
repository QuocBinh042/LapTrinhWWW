package bai4.beans;

public class CartItemBean {
	private String partNumber;
	private String modelDescription;
	private double unitCost;
	private int quantity;
	private double totalCost;

	public CartItemBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItemBean(String partNumber, String modelDescription, double unitCost, int quantity, double totalCost) {
		super();
		this.partNumber = partNumber;
		this.modelDescription = modelDescription;
		this.unitCost = unitCost;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getModelDescription() {
		return modelDescription;
	}

	public void setModelDescription(String modelDescription) {
		this.modelDescription = modelDescription;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "CartItemBean [partNumber=" + partNumber + ", modelDescription=" + modelDescription + ", unitCost="
				+ unitCost + ", quantity=" + quantity + ", totalCost=" + totalCost + "]";
	}

}
