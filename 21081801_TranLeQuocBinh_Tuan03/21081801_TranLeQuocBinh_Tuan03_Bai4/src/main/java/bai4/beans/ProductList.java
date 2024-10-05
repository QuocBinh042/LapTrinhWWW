package bai4.beans;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
	private static final List<Product> ds = new ArrayList<Product>();
	static {
		initData();
	}

	public static List<Product> queryProducts() {
		return ds;
	}

	private static void initData() {
		Product sp = new Product();
		sp.setId("PRO01");
		sp.setDescription("");
		sp.setPrice(99000);
		sp.setModel("Nokia Lumia");
		sp.setQuantity(10);
		sp.setImgURL("images/nokia-lumia.jpg");
		ds.add(sp);

		sp = new Product();
		sp.setId("PRO82");
		sp.setDescription("");
		sp.setPrice(48000);
		sp.setModel("BlackBerry Passport");
		sp.setQuantity(10);
		sp.setImgURL("images/blackberry-passport.jpg");
		ds.add(sp);

		sp = new Product();
		sp.setId("PRO83");
		sp.setDescription("");
		sp.setPrice(52000);
		sp.setModel("Sony Xperia Z5");
		sp.setQuantity(10);
		sp.setImgURL("images/sony-xperia-z5.jpg");
		ds.add(sp);

		sp = new Product();
		sp.setId("PRO84");
		sp.setDescription("");
		sp.setPrice(83000);
		sp.setModel("HTC One M9");
		sp.setQuantity(10);
		sp.setImgURL("images/htc-one-m9.jpg");
		ds.add(sp);

		sp = new Product();
		sp.setId("PRO85");
		sp.setDescription("");
		sp.setPrice(71000);
		sp.setModel("Samsung Galaxy Note 5");
		sp.setQuantity(10);
		sp.setImgURL("images/samsung-galaxy-note5.jpg");
		ds.add(sp);

		sp = new Product();
		sp.setId("PRO86");
		sp.setDescription("");
		sp.setPrice(120000);
		sp.setModel("iPhone 7 Jet Black Plus");
		sp.setQuantity(10);
		sp.setImgURL("images/iphone-7-jet-black-plus.jpg");
		ds.add(sp);

	}
}
