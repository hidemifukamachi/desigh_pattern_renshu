Singletonパターン
普通→たくさんのインスタンスが生成される

システム中に1個しか存在させたくない→1個だけ生成する。
→・指定したクラスのインスタンスが絶対に1個しか存在しないことを保証したい
 ・一個しかインスタンが存在しないことをプログラム上で表現したい

 →Singletonパターン
public class Singleton {
	private static Singleton singleton = new Singleton();
	private Singleton(){
		System.out.println("インスタンス生成");
	}
	public static Singleton getInstance(){
		return singleton;
	}
}

Main.java

public class Main {
	public static void main(String[] args) {
		System.out.println("start");
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
	
		if(obj1=obj2){
			System.out.println("同じインスタンス");
		}else{
			System.out.println("違うインスタンス");
		}
		System.out.println("終わり");
	}

}