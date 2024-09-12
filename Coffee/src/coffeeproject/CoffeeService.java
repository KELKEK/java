package coffeeproject;
public class CoffeeService {
	CoffeeDAO coffeeDAO = new CoffeeDAO();
	//1, 커피집 등록
	public int coffeebrandInsert(CoffeeBrandDTO coffeebrand) {
		return coffeeDAO.coffeebrandInsert(coffeebrand);
	}
	
	//2, 커피 등록
	public int coffeeInsert(CoffeeDTO coffee) {
		return coffeeDAO.coffeeInsert(coffee);
	}
	

}
