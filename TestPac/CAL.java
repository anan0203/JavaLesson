/**
*Title: PersonJavaDoc<br>
*Description: 通过PersonJavaDoc类来说明Java中的文档注释<br>
*Copyright:(c) 2004 www.sun.com.cn<br>
*Company : sun java </br>
*@author anxiaojie
*@version 1.00
*/
package TestPac;

import java.util.Arrays;

import junit.framework.TestCase;

public class CAL extends TestCase {
	public static void main(String args[])
	{
		byte max=java.lang.Byte.MAX_VALUE;
		System.out.println("~max="+(~max));
		int score[]=new int[5];
		score[0]=1;
		int i;
		for(i=0;i<5;i++)
		{
			System.out.println("score["+i+"]="+score[i]);
			
		}
		System.out.println("数组的长度是"+score.length);
		//copy array
		int a1[]={1,2,3,4,5,6};
		int a2[]={9,8,7,6,5,4,3};
		System.arraycopy(a2, 1, a1, 0, 3);
		System.out.print("数组a1的内容是：");
		for(i=0;i<a1.length;i++)
		{
			System.out.print(a1[i]+",");
		}
		System.out.println();
		System.out.print("数组a2的内容是：");
		for(i=0;i<a2.length;i++)
		{
			System.out.print(a2[i]+",");
		}
		Arrays.sort(a1);
		System.out.print("排序后数据：");
		for(i=0;i<a1.length;i++)
		{
			System.out.print(a1[i]+",");
		}
		System.out.println();
		/*Test T=new Test();
		T.arrayTest();
		Test1 T1=new Test1("anan");
		Test1.setAge(-5);
		T1.talk();*/
		//array
		Test2 arrayT[]=new Test2[3];
		arrayT[0]=new Test2(12,"ann1");
		arrayT[1]=new Test2(13,"ann2");
		arrayT[2]=new Test2(14,"ann3");
		for(i=0;i<arrayT.length;i++)
		{
			arrayT[i].talk();
		}
		
		student S=new student();
		S.school="MGH";
		System.out.println(S.age+","+S.name+","+S.school);
		
		Inter I=new Inter();
		I.inFun2();
		
		try
		{
			int arr[]=new int[5];
			arr[7]=10;
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("数组超出范围");
			System.out.println("异常："+e);
		}
		finally
		{
			System.out.println("一定会执行的程序");
		}
	}
	

}

class Test {
	void arrayTest()
	{
		
		int i,j;
		int sum=0;
		int array1[][]={{12,13,14,15,16},{74,54,64,94,34}};
		for(i=0;i<array1.length;i++)
		{
			for(j=0;j<array1[i].length;j++)
			{
				System.out.print(array1[i][j]+",");
				sum+=array1[i][j];
			}
			System.out.println();
		}
		System.out.print(sum);
	}
}

class Test1{
	private static int age;
	String name;
	static{
		System.out.println("static message");
		}
	public  Test1(String na)
	{
		this.name=na;
	}
	 void talk()
	{
	System.out.print("AGE IS:"+age+name);
	}
	
	public static void setAge(int a)
	{
		if(a>0)
		{
			age=a;
		}
	}
}

class Test2{
	int age;
	String name;
	public Test2()
	{
		
	}
	public Test2(int age,String name)
	{
		this.age=age;
		this.name=name;
	}
	void talk()
	{
		System.out.println("my age is:"+age+",name is:"+name);		
	}
}

class student extends Test2{
	String school;
	public student()
	{
		super(25,"张三");
	}
}

abstract class abTest{
	int age;
	String name;
	abstract public String talk(int age,String name);
	
}
class abTester extends abTest{
	String school;
	public String talk(int age,String name)
	{
		return "my name and age is:"+age+name;
	}
}

interface inFace{
	final int age=15;
	final String name="Lily";
	abstract public String inFun();
	
	
}
interface inFace1{
	final int age1=15;
	final String name1="Lily";
	abstract public String inFun1();
	
	
}
interface inFace2 extends inFace,inFace1{
	final int age2=15;
	final String name2="Lily";
	abstract public String inFun2();
	
	
}
class Inter implements inFace2{
	 public String inFun()
	{
		return "";
	}
	 public String inFun1()
		{
		 return "";
		}
	 public String inFun2()
		{
		 return "";
		}
}