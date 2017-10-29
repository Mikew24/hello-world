import java.util.*;

public class algo {
	public static boolean isNumeric(String s) {
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");
	}

	public static int operatorpri(String a) {
		if (a.equals("+") || a.equals("-"))
			return 1;
		if (a.equals("*") || a.equals("/"))
			return 2;
		
		return 0;

	}
	public String algoo(String s){
		Stack<String> n = new Stack<>();
		Stack<Double> d = new Stack<>();
		Scanner s1 = new Scanner(System.in);
		String input;
		String temp = "";
		int ll = 0;
		int ss = 1;
		
		int length;
		ArrayList<String> inputss=new ArrayList();
		System.out.println("please type a equation");
		input = s1.nextLine();
		 for(int x= 0;x<input.length();x++){
			// System.out.println("x:"+x+"y:"+ss);
		
		 if(isNumeric(input.substring(x, ss))==true||input.substring(x,ss).equals(".")){
			 if(ss==input.length()&&temp.equals("")){
				 System.out.println("adding: "+input.substring(x,ss));
				 inputss.add(input.substring(x,ss));
			 }
			 temp=temp+input.substring(x,ss);
		 //System.out.println(x+" "+ ss);
		 }else{
		 // System.out.println(temp);
		 if(!(temp.equalsIgnoreCase(""))){
			 inputss.add(temp);
		 }
		 System.out.println("adding: "+temp);
	//	! inputrefined[ll]=temp;
		 ll++;
		 inputss.add(input.substring(x,ss));
		 System.out.println("adding: "+input.substring(x,ss));
		//! inputrefined[ll]=input.substring(x,ss);
		 //System.out.println(inputrefined[ll]+"jj");
		 ll++;
		 temp="";
		 }
		
		 ss++;
		
		 }
		 //inputss.remove(0);
		 String[] inputrefined =inputss.toArray(new String[0]);
		
		 
//		 for(int x = 0;x<inputrefined.length;x++){
//			 System.out.print(inputrefined[x]+"|");
//			
//		 }
		//inputrefined = input.split(" ");
		// System.out.println(inputrefined[0]);
		length = inputrefined.length;
		for (int x = 0; x < length; x++) {
			if (isNumeric(inputrefined[x]) == true) {
				System.out.println("Push: " + inputrefined[x]);
				d.push(Double.parseDouble(inputrefined[x]));
			} else if (inputrefined[x].equals("(")) {
				System.out.println("Push: " + inputrefined[x]);
				n.push(inputrefined[x]);
			} else if (inputrefined[x].equals(")") && !(n.peek() != ("("))) {
				double k;
				double l;
				double awn = 0;
				String m;
				System.out.println("Pop: " + n.peek());
				m = n.pop();
				System.out.println("Pop: " + d.peek());
				k = d.pop();
				System.out.println("Pop: " + d.peek());
				l = d.pop();
				if (m.equals("-"))
					awn = l - k;
				if (m.equals("*"))
					awn = l * k;
				if (m.equals("/"))
					awn = l / k;
				if (m.equals("+"))
					awn = l + k;
				System.out.println("Push: " + awn);
				d.push(awn);
				awn = 0;

				//System.out.println("Pop: " + d.peek());
				// ISSUE
				// d.pop();
				//new and and
			} else if (isNumeric(inputrefined[x]) == false&&(!(inputrefined[x].equals(")")))) {
				if (n.empty() == false) {
					String thisOp = inputrefined[x];
					if (operatorpri(thisOp) <= operatorpri(n.peek())) {
						System.out.println("Pop: " + d.peek());
						double o = d.pop();
						System.out.println("Pop: " + d.peek());
						double p = d.pop();
						double awn1 = 0;
						if (n.peek().equals("-"))
							awn1 = p - o;
						if (n.peek().equals("+"))
							awn1 = p + o;
						if (n.peek().equals("*"))
							awn1 = p * o;
						if (n.peek().equals("/"))
							awn1 = p / o;
						System.out.println("Pop: " + n.peek());
						n.pop();
						System.out.println("Push: " + awn1);
						d.push(awn1);
						System.out.println("Pushski: " + thisOp);
						n.push(thisOp);
					} else{
						System.out.println("Push: " + inputrefined[x]);
						n.push(inputrefined[x]);
					}
				} else{
					System.out.println("Pushss: " + inputrefined[x]);
					n.push(inputrefined[x]);
				}
			}
		}
		while (n.isEmpty() == false) {
			System.out.println("PopSKI: " + n.peek());
			String q = n.pop();
			double awn2 = 0;
			System.out.println("Pop: " + d.peek());
			double r = d.pop();
			System.out.println("Pop: " + d.peek());
			double t = d.pop();
			if (q.equals("-"))
				awn2 = t - r;
			if (q.equals("+"))
				awn2 = t + r;
			if (q.equals("*"))
				awn2 = t * r;
			if (q.equals("/"))
				awn2 = t / r;
			System.out.println("Pushy: " + awn2);
			d.push(awn2);
			//new
			if(n.isEmpty()==false){
				if(n.peek().equals("(")){
					n.pop();
					}
			}
		}
		System.out.println("Answer: " + d.peek());
	

		
		
		return d.peek()+"";
	}
	public static void main(String[] arrgs) {
		Stack<String> n = new Stack<>();
		Stack<Double> d = new Stack<>();
		Scanner s = new Scanner(System.in);
		String input;
		String temp = "";
		int ll = 0;
		int ss = 1;
		
		int length;
		ArrayList<String> inputss=new ArrayList();
		System.out.println("please type a equation");
		input = s.nextLine();
		 for(int x= 0;x<input.length();x++){
			// System.out.println("x:"+x+"y:"+ss);
			 System.out.println("this loop has run "+x+"times");
		 if(isNumeric(input.substring(x, ss))==true||input.substring(x,ss).equals(".")){
			 if(ss==input.length()&&temp.equals("")){
				 System.out.println("adding: "+input.substring(x,ss));
				 inputss.add(input.substring(x,ss));
			 }
			 temp=temp+input.substring(x,ss);
		 //System.out.println(x+" "+ ss);
		 }else{
		 // System.out.println(temp);
		 if(!(temp.equalsIgnoreCase(""))){
			 inputss.add(temp);
		 }
		 System.out.println("adding: "+temp);
	//	! inputrefined[ll]=temp;
		 ll++;
		 inputss.add(input.substring(x,ss));
		 System.out.println("adding: "+input.substring(x,ss));
		//! inputrefined[ll]=input.substring(x,ss);
		 //System.out.println(inputrefined[ll]+"jj");
		 ll++;
		 temp="";
		 }
		
		 ss++;
		 if(x==input.length()-1&&temp.length()>1)inputss.add(temp);
		 System.out.println("adding "+temp);
		 }
		 //inputss.remove(0);
		 String[] inputrefined =inputss.toArray(new String[0]);
		 System.out.println("size"+inputss.size());
		 
//		 for(int x = 0;x<inputrefined.length;x++){
//			 System.out.print(inputrefined[x]+"|");
//			
//		 }
		//inputrefined = input.split(" ");
		// System.out.println(inputrefined[0]);
		length = inputrefined.length;
		for (int x = 0; x < length; x++) {
			if (isNumeric(inputrefined[x]) == true) {
				System.out.println("Push: " + inputrefined[x]);
				d.push(Double.parseDouble(inputrefined[x]));
			} else if (inputrefined[x].equals("(")) {
				System.out.println("Push: " + inputrefined[x]);
				n.push(inputrefined[x]);
			} else if (inputrefined[x].equals(")") && !(n.peek() != ("("))) {
				double k;
				double l;
				double awn = 0;
				String m;
				System.out.println("Pop: " + n.peek());
				m = n.pop();
				System.out.println("Pop: " + d.peek());
				k = d.pop();
				System.out.println("Pop: " + d.peek());
				l = d.pop();
				if (m.equals("-"))
					awn = l - k;
				if (m.equals("*"))
					awn = l * k;
				if (m.equals("/"))
					awn = l / k;
				if (m.equals("+"))
					awn = l + k;
				System.out.println("Push: " + awn);
				d.push(awn);
				awn = 0;

				//System.out.println("Pop: " + d.peek());
				// ISSUE
				// d.pop();
				//new and and
			} else if (isNumeric(inputrefined[x]) == false&&(!(inputrefined[x].equals(")")))) {
				if (n.empty() == false) {
					String thisOp = inputrefined[x];
					if (operatorpri(thisOp) <= operatorpri(n.peek())) {
						System.out.println("Pop: " + d.peek());
						double o = d.pop();
						System.out.println("Pop: " + d.peek());
						double p = d.pop();
						double awn1 = 0;
						if (n.peek().equals("-"))
							awn1 = p - o;
						if (n.peek().equals("+"))
							awn1 = p + o;
						if (n.peek().equals("*"))
							awn1 = p * o;
						if (n.peek().equals("/"))
							awn1 = p / o;
						System.out.println("Pop: " + n.peek());
						n.pop();
						System.out.println("Push: " + awn1);
						d.push(awn1);
						System.out.println("Pushski: " + thisOp);
						n.push(thisOp);
					} else{
						System.out.println("Push: " + inputrefined[x]);
						n.push(inputrefined[x]);
					}
				} else{
					System.out.println("Pushss: " + inputrefined[x]);
					n.push(inputrefined[x]);
				}
			}
		}
		while (n.isEmpty() == false) {
			System.out.println("PopSKI: " + n.peek());
			String q = n.pop();
			double awn2 = 0;
			System.out.println("Pop: " + d.peek());
			double r = d.pop();
			System.out.println("Pop: " + d.peek());
			double t = d.pop();
			if (q.equals("-"))
				awn2 = t - r;
			if (q.equals("+"))
				awn2 = t + r;
			if (q.equals("*"))
				awn2 = t * r;
			if (q.equals("/"))
				awn2 = t / r;
			System.out.println("Pushy: " + awn2);
			d.push(awn2);
			//new
			if(n.isEmpty()==false){
				if(n.peek().equals("(")){
					n.pop();
					}
			}
		}
		System.out.println("Answer: " + d.peek());
	}

}
