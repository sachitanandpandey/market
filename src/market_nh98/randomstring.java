package market_nh98;



//String[] la ={"#softwaretesting","#qa","#agile","#testing","#qatesting","#agiletesting","#usertesting","#testautomation","#softwaredevelopment"};



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class randomstring {

	

	public static void main(String[] args) {
	    Random random = new Random();
//		List <String> list = new ArrayList<>(Arrays.asList("tom1","katreena1","tim1","nemu1","nama1","test1","test2","mytest","softwaredevelopment1"));
//		String rstring = list.get(random.nextInt(list.size()));
//		System.out.println("Random string is  " + rstring);
	    int rnum = random.nextInt(1000000);
	    System.out.println(rnum);
	    
	}

	

}
