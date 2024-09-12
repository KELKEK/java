import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

public class Prob4 {

	public static void main(String[] args) {
		Product[] prodList = {
				new Product("NT450R5E-K24S",500000,"삼성전자"),
				new Product("15UD340-LX2CK",400000,"LG전자"),
				new Product("G2-K3T32AV",600000,"HP") };
		HashSet<Product> product_hs = makeHashSet(prodList, 500000);
		makeFile(product_hs);
		readFile();
		
	}

	
	private static HashSet<Product> makeHashSet(Product[] prodList, int price) {
		//구현하시오...return값 수정하기 
		 System.out.println("*특정 금액 이상의 상품 결과입니다.*************");
		 
		 HashSet<Product> set = new HashSet<Product>(); 
		 
		for(Product prod : prodList) {
			if(prod.getPrice() >= price) {
				 set.add(prod);
				 System.out.println(prod);
			}
		}
		return set;
	}


	private static void makeFile(HashSet resultList)  {
		//구현하시오.
		try {
			FileOutputStream fos = new FileOutputStream("aa.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		}catch (IOException e) {
			e.printStackTrace();
		}

		
		
	}
	private static void readFile()  {
		//구현하시오. 
		System.out.println("*readFile결과입니다.**************");
		try {
			FileInputStream fis = new FileInputStream("aa.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while(true) {
				Object obj = ois.readObject();
				if(obj == null) break;
				Product p = (Product)obj;
				System.out.println(p);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


class Product implements Serializable{
	private String model_name;
	private int price;
	private String company;
	
	
	public Product(String model_name, int price, String company) {
		super();
		this.model_name = model_name;
		this.price = price;
		this.company = company;
	}


	public String getModel_name() {
		return model_name;
	}


	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	@Override
	public String toString() {
		return "Product [model_name=" + model_name + ", price=" + price
				+ ", company=" + company + "]";
	}
	
	

}


//object output stream