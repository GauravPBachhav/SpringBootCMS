package in.gw.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
//	INSERT INTO course(description, discounted_price, image_url, name, original_price, updated_on) VALUES ('This is core java course which covers interview preparation, case studies and 5 projects','1999','http://localhost:8080/uploads/corejava.jpg','Core Java','5999','3 months ago');
// this is query for the cources 
	
//	INSERT INTO course(description, discounted_price, image_url, name, original_price, updated_on) VALUES ('This course contains JDBC, Servlet, JSP with Frontend technologies + 1 projects','1999','http://localhost:8080/uploads/advancejava.jpg','Advance Java','7999','3 months ago');

//	INSERT INTO course(description, discounted_price, image_url, name, original_price, updated_on) VALUES ('This course contains Spring Modules i.e.Core, Database, WEB-MVC, security etc','2999','http://localhost:8080/uploads/spring.jpg','Advance Java','8999','1 months ago');

//	INSERT INTO course(description, discounted_price, image_url, name, original_price, updated_on) VALUES ('This course contains advance java + Spring + Spring Boot ','3999','http://localhost:8080/uploads/springboot.jpg','SpringBoot','9999','2 Days ago');
	
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private String originalPrice;
	
	@Column
	private String discountedPrice;
	
	@Column
	private String updatedOn;
	
	@Column
	private String imageUrl;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}
	public String getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(String discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
