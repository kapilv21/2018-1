package abs;

public class ReplaceQuesMarkWith0And1 {
	public static void main(String[] args) {
		String str = "1?00?101";
		func(str);
	}

	static void func(String str) {
		if(str == null){
			return;
		}
		if(str.indexOf("?") == -1){
			System.out.println(str);
			return;
		}
		func(str.replaceFirst("?", "0"));
		func(str.replaceFirst("?", "1"));
	}

}
