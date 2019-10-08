package Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternCheck {
	 
	
	public static void main(String[] args) {
		
		String s1="This is Shiva is Prasad";
		int count=1;
		String[] s2=s1.split(" ");
		for(int i=0;i<s2.length;i++){
			for(int j=i+1;j<s2.length;j++){
			if(s2[i].equals(s2[j])){
				count++;
				s2[j]=" ";
			   }
			}
			if(s2[i]!=" ")
			System.out.println("--->>  "+s2[i]+"  -  "+count);
	        count = 1;
		}
		
		String st1="abcabc123abc";
		
		System.out.println("-------- > "+st1.compareTo("abcc3bc"));
		String s="abcdababbaABCD 12/12/2018 and 11/11/2018";
		int cnt=0;
		Pattern p = Pattern.compile("\\w");
		Matcher m=p.matcher(st1);
		while(m.find()){
		System.out.println("---- > "+m.group());
		cnt++;
		}
		System.out.println(cnt);
		
		char[] ch= new char[]{'h','e','l','l','o'};
		String str1=new String(ch);
		System.out.println("----- > "+str1);
		
		String strs1="this is shiva vallabhaneni prasad";
		String[] strs2=strs1.split(" ");
		String strs4="";
		System.out.println("--- > "+strs2.length);
		for(int i=0;i<strs2.length;i++){
			String str4=strs2[i];
			String strs3="";
			String f="";
			for(int j=1;j<str4.length();j++){
				char a=Character.toUpperCase(str4.charAt(0));
				strs3+=str4.charAt(j);
				 f=String.valueOf(a)+strs3;
			}
			strs4 = strs4 + f+" ";
		}
		System.out.println(strs4);
	}

}
