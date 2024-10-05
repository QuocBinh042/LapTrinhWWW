package bai2.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CartItem")
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String partNumber;
	private String modelDescription;
	private double unitCost;
	private int quantity;
	private double totalCost;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cartitem_id")
	private List<Product> products = new ArrayList();

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItem(String partNumber, String modelDescription, double unitCost, int quantity, double totalCost) {
		super();
		this.partNumber = partNumber;
		this.modelDescription = modelDescription;
		this.unitCost = unitCost;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}

	public CartItem(int id, String partNumber, String modelDescription, double unitCost, int quantity,
			double totalCost) {
		super();
		this.id = id;
		this.partNumber = partNumber;
		this.modelDescription = modelDescription;
		this.unitCost = unitCost;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
