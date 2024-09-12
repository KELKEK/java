package coffeeproject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class CoffeeBrandDTO {
	private int coffee_brandid;
	private String coffee_brandname;
	private int dist_x;
	private int dist_y;	
}
