package abs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
public class ClassOFTimeAndCounter {
	public static void main(String[] args) throws ParseException {
		System.out.println(" time "+System.currentTimeMillis()/1000 );
		long timeMillis = System.currentTimeMillis();
		 
		String d = getDate(new Date(timeMillis));
		String d1 = getDate(new Date(timeMillis-1000)); // minus 1 second
		
		// within last one min but 8 secs apart
		String d2 = getDate(new Date(timeMillis-8000)); // minus 8 seconds
		String d3 = getDate(new Date(timeMillis-9000)); // minus 9 seconds 
		String d4 = getDate(new Date(timeMillis-10000));  // minus 10 seconds
		//hour before
		String d5 = getDate(new Date(timeMillis-3601*1000)); // minus 1 hour
		LinkedList<Long> ll = new LinkedList<>();
		ll.addLast(timeMillis);
		ll.addLast(timeMillis-1000);
		ll.addLast(timeMillis-8000);
		ll.addLast(timeMillis-9000);
		ll.addLast(timeMillis-10000);
		ll.addLast(timeMillis-3600*1000);
		
		 System.out.println(" original "+d);
		 System.out.println(" minus 1 sec:"+d1);
		 System.out.println(" minus 8 sec:"+d2);
		 System.out.println(" minus 9 sec:"+d3);
		 System.out.println(" minus 10 sec:"+d4);
		 System.out.println(" minus 1 hour:"+d5);
		 
		 queryLastSec(ll);
		 queryLastMin(ll);
		 queryLastHour(ll);
		 
		 // when a new entry comes insert as first and remove last entry if it is not valid
		 addNewEntry(timeMillis-1000, ll);
			
		
	}
	
	static void addNewEntry(Long l, LinkedList<Long> ll){
		long span = 3600*1000;
		System.out.println("last entry "+(ll.getLast()-ll.getFirst()) +" span "+span);
		while(ll.getFirst()-ll.getLast()>=span){
			System.out.println(" removed last");
			ll.removeLast();
		}
		System.out.println(" resized ll ");
		Iterator<Long> it = ll.iterator();
		while(it.hasNext()){
			Long t = it.next();
			System.out.println(" all Entries now "+getDate(new Date(t)));
		}
	}
	static void queryLastSec(LinkedList<Long> ll){
		System.out.println(" Last one Sec");
		Iterator<Long> it = ll.iterator();
		while(it.hasNext()){
			Long t = it.next();
			long currentTimeMillis = System.currentTimeMillis();
			if(currentTimeMillis - t > 1000){
				continue;
			}else{
				System.out.println(" in last sec "+getDate(new Date(t)));
			}
		}
		
	}
	static void queryLastMin(LinkedList<Long> ll){
		System.out.println(" Last one min");
		Iterator<Long> it = ll.iterator();
		while(it.hasNext()){
			Long t = it.next();
			long currentTimeMillis = System.currentTimeMillis();
			if(currentTimeMillis - t > 60*1000){
				continue;
			}else{
				System.out.println(" in last  "+getDate(new Date(t)));
			}
		}
	}
	static void queryLastHour(LinkedList<Long> ll){
		System.out.println(" Last one Hour");
		Iterator<Long> it = ll.iterator();
		while(it.hasNext()){
			Long t = it.next();
			long currentTimeMillis = System.currentTimeMillis();
			if(currentTimeMillis - t > 60*60*1000){
				continue;
			}else{
				System.out.println(" in last  "+getDate(new Date(t)));
			}
		}
	}
	static String getDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(date);
	}
	
}
