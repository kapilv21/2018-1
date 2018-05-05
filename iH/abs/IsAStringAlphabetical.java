package abs;


public class IsAStringAlphabetical {
	public static void main(String[] args) {
		String str = "Beehive";
		char prev ='#';
		
		char[] car = str.toLowerCase().toCharArray();
		prev = car[0];
		for(int i=1; i< car.length; i++){
			if(car[i]<prev){
				System.out.println(i);
			}
			prev = car[i];
		}
	}
}
