package bai2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table (name = "Product")
public class Product {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
//	@NotBlank (message = "Model không được để trống!")
	private String model;
	private String description;
//	@NotBlank (message = "Quantity không được để trống!")
//	@Min (value = 1, message = "Quantity phải lớn hơn 0!")
	private int quantity;
//	@NotBlank (message = "Price không được để trống!")
//	@DecimalMin (value = "0.1", inclusive = true, message = "Price phải lớn hơn 0!")
	private double price;
	private String imgURL;

	public Product() {
		super();
	}

	public Product(int id, String model, String description, int quantity, double price, String imgURL) {
		super();
		this.id = id;
		this.model = model;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.imgURL = imgURL;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", model=" + model + ", description=" + description + ", quantity=" + quantity
				+ ", price=" + price + ", imgURL=" + imgURL + "]";
	}

}
