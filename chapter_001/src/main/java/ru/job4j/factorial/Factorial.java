package ru.job4j.factorial;
/**
*Factorial Class
*/
public class Factorial{
	
	public int calc(int n){
		int count =1;
		if(n>0){
		for(int i = 1; i <= n ; i++){
			count *= i;
		  }
		}
		return count;
	} 
}
