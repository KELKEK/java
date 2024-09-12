import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Prob1 {
	public static void main(String[] args) {
		String[] array={"황남기85점","조성호89점","한인성88점","독고정진77점"};
		printMaxScore(array);
	}	
	private static void printMaxScore(String[] array){
		// 구현하세요.
		String regExp = "([ㄱ-ㅎ가-힣]+)([0-9]+)점";//괄호로 그룹화, 이거 다 붙여써야됨...
		String maxName = "";	
		int maxScore = -1;
		for(String data : array) {
			Pattern pattern = Pattern.compile(regExp);
			Matcher matcher = pattern.matcher(data);
			if(matcher.find()) {
				String name = matcher.group(1);
				String score = matcher.group(2);
				int iscore = Integer.parseInt(score);
				System.out.println(name + "===" + score);
				if(maxScore < iscore) {
					maxScore = iscore;
					maxName = name;
				}
			}
		}
		System.out.printf("최고점수는 %s님 %s점입니다.", maxName, maxScore);
	}
}


//tocharArray쓰면 문자열이 나뉘어짐
//digit인지 아닌지 확인하고 digit이 나오기 전까지 계속 돌려준다.



//정규표현식
//문자가 여러 개 숫자가 여러 개 빼기
//남은 '점'은 지우기