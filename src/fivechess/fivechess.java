package fivechess;


import java.util.InputMismatchException;
import java.util.Scanner;
public class fivechess {
	String[][] panmian;
	boolean auto;
	boolean gameover;
	public void printqipan(int huihe){
		System.out.println("第"+huihe+"回合");
		System.out.println("  0 1 2 3 4 5 6 7 8 9");
		for(int i=0;i<=9;i++){
			System.out.print(i+" ");
			for(int j=0;j<=9;j++)
				System.out.print(this.panmian[i][j]+" ");
			System.out.println();
		}
	}
	public void autoxiaqi(String x,fivechess a,int huihe){
		int i=(int)(Math.random() * 10);                     //随机数
		int j=(int)(Math.random() * 10);
		if(a.panmian[i][j]=="·"){
			a.panmian[i][j]=x;
			a.printqipan(huihe);
			System.out.println();
		}
		else{
			this.autoxiaqi(x,a,huihe);
		}
	}
	public void xiaqi(String x,fivechess a,int huihe){
		Scanner sc = new Scanner(System.in);                 //键盘输入
		System.out.println(x+"棋下（空格隔开，例：2 2 回车）");
		try{
		 int i = sc.nextInt();
		 int j = sc.nextInt();
		 if(i<0||i>9||j<0||j>9){
			 System.out.println("下标越界!请输入0到9之间的数");
			 this.xiaqi(x,a,huihe);
		 }
	  	 else if(a.panmian[i][j]=="·"){
		 	 a.panmian[i][j]=x;
			 a.printqipan(huihe);
		 }
		 else{
			 System.out.println("这格已被占用");
			 this.xiaqi(x, a,huihe);
		 }
		}
		catch(InputMismatchException e){
			System.out.println("请输入正确格式");
			this.xiaqi(x,a,huihe);
		}
	}
	public boolean judgewin(){
		for(int i=0;i<=9;i++){
			for(int j=0;j<=5;j++){
				if(this.panmian[i][j]=="黑"||this.panmian[i][j]=="白"){
					if(this.panmian[i][j]==this.panmian[i][j+1]&&this.panmian[i][j+1]==this.panmian[i][j+2]&&this.panmian[i][j+2]==this.panmian[i][j+3]&&this.panmian[i][j+3]==this.panmian[i][j+4]){
						System.out.println(this.panmian[i][j]+"色胜利!");
						return true;
					}
				}
			}
		}
		for(int i=0;i<=5;i++){
			for(int j=0;j<=9;j++){
				if(this.panmian[i][j]=="黑"||this.panmian[i][j]=="白"){
					if(this.panmian[i][j]==this.panmian[i+1][j]&&this.panmian[i+1][j]==this.panmian[i+2][j]&&this.panmian[i+2][j]==this.panmian[i+3][j]&&this.panmian[i+3][j]==this.panmian[i+4][j]){
						System.out.println(this.panmian[i][j]+"色胜利!");
						return true;
					}
				}
			}
		}
		for(int i=0;i<=5;i++){
			for(int j=0;j<=5;j++){
				if(this.panmian[i][j]=="黑"||this.panmian[i][j]=="白"){
					if(this.panmian[i][j]==this.panmian[i+1][j+1]&&this.panmian[i+1][j+1]==this.panmian[i+2][j+2]&&this.panmian[i+2][j+2]==this.panmian[i+3][j+3]&&this.panmian[i+3][j+3]==this.panmian[i+4][j+4]){
						System.out.println(this.panmian[i][j]+"色胜利!");
						return true;
					}
				}
			}
		}
		for(int i=0;i<=5;i++){
			for(int j=4;j<=9;j++){
				if(this.panmian[i][j]=="黑"||this.panmian[i][j]=="白"){
					if(this.panmian[i][j]==this.panmian[i+1][j-1]&&this.panmian[i+1][j-1]==this.panmian[i+2][j-2]&&this.panmian[i+2][j-2]==this.panmian[i+3][j-3]&&this.panmian[i+3][j-3]==this.panmian[i+4][j-4]){
						System.out.println(this.panmian[i][j]+"色胜利!");
						return true;
					}
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		fivechess qipan=new fivechess();
		fivechess black=new fivechess();
		fivechess white=new fivechess();
		qipan.panmian=new String[][]{
			{"·","·","·","·","·","·","·","·","·","·"},
			{"·","·","·","·","·","·","·","·","·","·"},
			{"·","·","·","·","·","·","·","·","·","·"},
			{"·","·","·","·","·","·","·","·","·","·"},
			{"·","·","·","·","·","·","·","·","·","·"},
			{"·","·","·","·","·","·","·","·","·","·"},
			{"·","·","·","·","·","·","·","·","·","·"},
			{"·","·","·","·","·","·","·","·","·","·"},
			{"·","·","·","·","·","·","·","·","·","·"},
			{"·","·","·","·","·","·","·","·","·","·"}
		};		
		int huihe=0;
		qipan.printqipan(huihe);
		System.out.println("输入auto自动下棋，输入其他手动下棋");
		Scanner sc = new Scanner(System.in);
		String i = sc.nextLine();                           //判断自动
		String j="auto";
		if(i.equals(j)){
			for(;;){
				huihe++;
				black.autoxiaqi("黑",qipan,huihe);
				if(qipan.judgewin())
					break;
				huihe++;
				white.autoxiaqi("白",qipan,huihe);
				if(qipan.judgewin())
					break;
			}
		}
		else{
			for(;;){
				huihe++;
				black.xiaqi("黑",qipan,huihe);
				if(qipan.judgewin())
					break;
				huihe++;
				white.xiaqi("白",qipan,huihe);
				if(qipan.judgewin())
					break;
			}
		}
	}
}