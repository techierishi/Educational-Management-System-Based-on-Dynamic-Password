package cn.edu.hustwb.util;

import java.util.Date;
import java.util.Random;

public class DynamicEncrypt {
/*
 * 1.序列号
 * 2.动态密码
 * 
 * */
	private String key;
	private String DynamicPassword;

	public String Encrypt(String dp){
//		System.out.println(dp.substring(0, 1));
//		System.out.println(dp.substring(1, 2));
		Date date = new Date();
		int a = Integer.parseInt(dp.substring(1, 2)) ;
		int b = Integer.parseInt(dp.substring(6, 7)) ;
		int c = Integer.parseInt(dp.substring(12, 13)) ;
		int d = Integer.parseInt(dp.substring(13, 14)) ;
		int h = date.getHours();			//获得时间
		int m = date.getMinutes();		//获得分钟
		return Dynamic(a, b, c, d, h, m);
	}
	
	public boolean ServerValid(String dp,String key){
		Date date = new Date();
		int a = Integer.parseInt(dp.substring(1, 2)) ;
		int b = Integer.parseInt(dp.substring(6, 7)) ;
		int c = Integer.parseInt(dp.substring(12, 13)) ;
		int d = Integer.parseInt(dp.substring(13, 14)) ;
		int h = date.getHours();			//获得时间
		int m = date.getMinutes();		//获得分钟
		if(Dynamic(a, b, c, d, h, m).equals(key)||Dynamic(a, b, c, d, h, m+1).equals(key)||Dynamic(a, b, c, d, h, m-1).equals(key)){
			return true;
		}
		
		return false;
	}
	private String Dynamic(int a, int b, int c, int d, int h, int m) {
		a+=(h%2+m%10+m*3);
		b+=m/2;
		c--;
		c*=a+b;
		d*=b+m;
		String dpkey = c+"";
		dpkey  += d+"";
		return dpkey;
	}
	
	
	public String CreateDynamicPassword(){				//创建随机序列号
		Random rnd = new Random();
		String a = "" ;
		for (int i =0;i<16;i++){
			int p = rnd.nextInt(10);
			if(i%4==0&&i!=0){
				a+="-";
			}
			a += p;
		}

		System.out.println(a);
		return a;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getDynamicPassword() {
		return DynamicPassword;
	}
	public void setDynamicPassword(String dynamicPassword) {
		DynamicPassword = dynamicPassword;
	}


}


