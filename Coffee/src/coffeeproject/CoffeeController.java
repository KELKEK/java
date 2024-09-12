package coffeeproject;

import java.util.List;
import java.util.Scanner;

//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.ButtonGroup;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JRadioButton;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//
////@SuppressWarnings("serial")
////윈도우 컴포넌트 상속
//
//class Work extends JFrame {
//	// 생성자
//	private int select;
//
//	public Work() {
//		setTitle("COFFEE PROJECT");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		Container contentPane = getContentPane();
//		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
//		final JButton button = new JButton("선택");
//		
//		final JTextField text = new JTextField("1", 10);
//		contentPane.add(button, BorderLayout.SOUTH);
//		contentPane.add(new JTextField(20), BorderLayout.CENTER);
//		
//		setSize(300, 200);
//		setVisible(true);
//		
//		 button.addActionListener(new ActionListener()){
//			 
//			 
//		 }
//		
//	}
//	
//}

public class CoffeeController {
	static Scanner sc = new Scanner(System.in);
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println((int)(Math.random() * 10));
		//new Work();
		int x = (int) (Math.random() * 10);
		int y = (int) (Math.random() * 10);
		boolean isStop = false;
		boolean isLoginCUS = false;
		CoffeeService coffeeService = new CoffeeService();
		CustomerService customerService = new CustomerService();
		CustomerDTO cu = new CustomerDTO();
		System.out.println("=============================");
		System.out.println("1. 개발자용         2, 소비자용");
		System.out.println("=============================");
		System.out.print("용도를 선택해주세요 >> ");
		// 개발자용, 소비자용
		int select = sc.nextInt();

		switch (select) {
		case 0 -> {
			break;
		}
		case 1 -> {
			while (!isStop) {
				int selectJob = menuDisplay2();
				switch (selectJob) {
				case 0 -> {
					isStop = true;
				}
				case 1 -> {// 커피회사 계정등록
					CoffeeBrandDTO coffeebrand = InsertDataCB();
					int result = coffeeService.coffeebrandInsert(coffeebrand);
					CoffeeView.print(result > 0 ? "입력성공" : "입력실패");
				}
				case 2 -> {// 커피회사 커피등록
					CoffeeDTO coffee = InsertDataC();
					int result = coffeeService.coffeeInsert(coffee);
					CoffeeView.print(result > 0 ? "입력성공" : "입력실패");
				}
				default -> {
					System.out.println("올바른 번호를 입력해주세요!");
				}
				}
			}
		}
		case 2 -> {
			while (!isStop) {
				int selectJob = menuDisplay();
				switch (selectJob) {
				case 0: {
					isStop = true;
					break;
				}
				case 1: {// 회원가입
					CustomerDTO cus = InsertData();
					int result = customerService.cusInsert(cus);
					CustomerView.print(result > 0 ? "입력성공" : "이미 존재하는 ID, 입력실패");
					if(result == 0) {
						break;
					}
					System.out.println("회원 첫 등록 시 커피의 선호도를 작성해주세요!");
					CustomerFavorDTO cusf = InsertDataF(cus.getCustomerid());
					int result2 = customerService.cusfavorInsert(cusf);
					CustomerView.print(result2 > 0 ? "커피선호도 입력성공" : "커피선호도 입력실패");
					System.out.println("차후에 수정을 원하시면 선호도 수정기능을 이용해주세요!!");
					break;
				}
				case 2: {// 로그인
					System.out.print("ID >> ");
					String id = sc.next();
					System.out.print("PW >> ");
					String pw = sc.next();
					cu = customerService.login(id, pw);
					if (cu.getNickname() != null) {
						System.out.println("===========로그인 성공================");
						isLoginCUS = true;
						cu.setDist_x(x);
						cu.setDist_y(y);
						// 현재 위치값 랜덤으로 지정해서 옮겨주기
						// 추천값이 제일 높은 커피 추천, islogin != 0이어야 수행할 수 있는 함수로 설정

						List<Object> cof = customerService.recommend(id, x, y);
						System.out.println(cu.getNickname() + "님! 오늘의 추천 커피입니다");
						System.out.println();
						CustomerView.print(cof);
						break;
					} else {
						System.out.println("로그인 실패, 혹은 커피 선호도를 등록하지 않았습니다.");
						break;
					}
				}
				case 3: {// 커피 선호도 수정
					System.out.print("고객님의 ID를 입력해주세요 >>");
					String id = sc.next();
					CustomerFavorDTO cusf = new CustomerFavorDTO();
					cu = customerService.login(id);
					if (isLoginCUS == true && cu.getCustomerid().equals(id)) {
						cusf = InsertDataF(id);
					} else {
						System.out.println("계정이 존재하지 않거나 로그아웃 상태입니다.");
						System.out.println("로그인 후에 수정할 수 있습니다.");
						break;
					}

					int result = customerService.cusfavorUpdate(cusf);
					CustomerView.print(result > 0 ? "수정성공" : "수정실패");
					break;
				}
				case 4: {// 커피집의 메뉴판을 보고싶을 때
					System.out.print("고객님의 ID를 입력해주세요 >> ");
					String id = sc.next();
					System.out.print("주문하고자하는 커피집을 입력해주세요 >> ");
					String brandname = sc.next();
					List<Object> menu = customerService.menu(id, brandname, x, y);
					CustomerView.print(menu, "메뉴판");
					break;
				}
				case 5: {// 로그아웃
					isLoginCUS = false;
					System.out.println("로그아웃에 성공하셨습니다!");
					break;
				}
				case 6: {//회원탈되
					System.out.print("삭제할 고객님의 ID를 입력해주세요 >> ");
					String id = sc.next();
					System.out.print("고객 확인을 위해 비밀번호를 입력해주세요 >> ");
					String pw = sc.next();
					int result1 = customerService.cusDelete(id, pw);
					int result2 = customerService.cusFavorDelete(id);
					CustomerView.print(result1 > 0 && result2 > 0 ? "탈퇴성공" : "탈퇴실패");
					break;
				}
				default: {
					System.out.println("올바른 번호를 입력해주세요!");
				}
				}
			}
		}
		}

		System.out.println("================END================");
	}

	private static CoffeeDTO InsertDataC() {
		System.out.print("COFFEE_ID설정(4자리 수 입력) >> ");
		int coffee_id = sc.nextInt();
		System.out.print("COFFEE_BRANDID입력(이미 존재하는 ID여야 합니다) >> ");
		int coffee_brandid = sc.nextInt();
		System.out.print("COFFEE NAME 입력 >> ");
		String coffee_name = sc.next();
		System.out.print("PRICE >> ");
		int price = sc.nextInt();
		System.out.print("CAFFEINE >> ");
		int caffeine = sc.nextInt();
		System.out.print("SUGAR >> ");
		int sugar = sc.nextInt();
		System.out.print("QUALITY >> ");
		int quality = sc.nextInt();

		CoffeeDTO coffee = new CoffeeDTO();
		coffee.setCoffee_id(coffee_id);
		coffee.setCoffee_brandid(coffee_brandid);
		coffee.setCoffee_name(coffee_name);
		coffee.setPrice(price);
		coffee.setCaffeine(caffeine);
		coffee.setSugar(sugar);
		coffee.setQuality(quality);

		return coffee;
	}

	private static CoffeeBrandDTO InsertDataCB() {
		// TODO Auto-generated method stub
		System.out.print("COFFEE_BRANDID설정(4자리 수 입력) >> ");
		int coffee_brandid = sc.nextInt();
		System.out.print("BRANDNAME >> ");
		String coffee_brandname = sc.next();
		System.out.print("위치값 x >> ");
		int dist_x = sc.nextInt();
		System.out.print("위치값 y >> ");
		int dist_y = sc.nextInt();

		CoffeeBrandDTO coffeebrand = new CoffeeBrandDTO();
		coffeebrand.setCoffee_brandid(coffee_brandid);
		coffeebrand.setCoffee_brandname(coffee_brandname);
		coffeebrand.setDist_x(dist_x);
		coffeebrand.setDist_y(dist_y);
		return coffeebrand;
	}

	private static CustomerFavorDTO InsertDataF(String id) {
		// TODO Auto-generated method stub
		System.out.print("PRICE(0~9)>> ");
		int price = sc.nextInt();
		System.out.print("CAFFEINE(0~9)>> ");
		int caffeine = sc.nextInt();
		System.out.print("SUGAR(0~9)>> ");
		int sugar = sc.nextInt();
		System.out.print("QUALITY(0~9)>> ");
		int quality = sc.nextInt();
		System.out.print("DISTANCE(0~9)>> ");
		int distance = sc.nextInt();

		CustomerFavorDTO customer = new CustomerFavorDTO();
		customer.setCustomerid(id);
		customer.setPrice(price);
		customer.setCaffeine(caffeine);
		customer.setSugar(sugar);
		customer.setQuality(quality);
		customer.setDistance(distance);
		return customer;
	}

	private static CustomerDTO InsertData() {
		System.out.print("CUSTOMERID(String)>> ");
		String customerid = sc.next();
		System.out.print("NICKNAME(String)>> ");
		String nickname = sc.next();
		System.out.print("PASSWORD(String)>> ");
		String password = sc.next();

		CustomerDTO customer = new CustomerDTO();
		customer.setCustomerid(customerid);
		customer.setNickname(nickname);
		customer.setPword(password);
	
		return customer;
	}
	// 회원 가입 시에 받을 고객의 정보, 회원가입 후 로그인을 해야 정상적으로 이용할 수 있으며
	// 이 때는 아직 x, y좌표값을 입력받지 못한다.

	private static int menuDisplay() {
		// TODO Auto-generated method stub
		System.out.println("=================");
		System.out.println("1, 회원가입");
		System.out.println("2, 로그인");
		// 로그인 시 현재 위치를 받아오며, 그 위치정보를 customer의 dist값에 update한다.
		System.out.println("3, 커피 선호도 수정"); // 로그인이 선행되어야 한다, insert 구문
		// 3번 결과로 커피 선호도를 수정할 수 있다.
		System.out.println("4, 메뉴판");
		// 원하는 커피집을 이미 정했을 경우 그 커피집의 목록을 반환하여 고를 수 있게 한다.
		System.out.println("5, 로그아웃");
		System.out.println("6, 회원탈퇴");
		System.out.println("0, 작업종료");
		System.out.println("=================");
		System.out.print("작업 선택 >>");
		int job = sc.nextInt();

		return job;
	}

	private static int menuDisplay2() {
		// TODO Auto-generated method stub
		System.out.println("=================");
		System.out.println("1, 커피집 등록");
		System.out.println("2, 커피 추가");
		System.out.println("0, 작업 종료");
		System.out.println("=================");
		System.out.print("작업 선택 >> ");
		int job = sc.nextInt();
		return job;
	}

}