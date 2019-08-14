package practice;

public class Demo1 {
	static int i;
	int j;
	{
		j=0;
		i=12;
		System.out.println("non static");
		System.out.println(j+" "+i);
	}
	static
	{
		i=20;
		System.out.println("static");
	}
	Demo1()
	{
		i=34;
		j=38;
		System.out.println("constructor");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(i);
		Demo1 d=new Demo1();
		System.out.println(d.j);
		System.out.println(i);
		Integer i1=Integer.valueOf(i);
		System.out.println();
		System.out.println(i1.hashCode());
		String s=i1.toString();
		System.out.println(i1);
		int n=Integer.parseInt(s);
		System.out.println(n);
		n=i1.intValue();
		
	}

}
