adapterパターン
すでに提供されているものが使えない→必要な形に変換してから使用する。
別名:wrapperパターン

adapterパターンは２種類存在する。
・クラスによるadapterパターン（継承）
・インスタンスによるadapterパターン（委譲）


Banner.java

public class Banner {
	private String string;
	public Banner(String string){
		this.string = string;
	}

	public void showWithParen() {
		System.out.println("("+ string +")");
	}

	public void showWithAster() {
		System.out.println("*"+ string +"*");
	}
}

Printインターフェイス
Print.java

public interface Print {
	public abstract void printWeak();
	public abstract void prontStrong();
}


PrintBanner.java-extendsで継承させる
public class PrintBanner extends Print{
	private Banner banner;
	public PrintBanner(String string){
		this.banner = new Banner(String)
	}
	public void printWeak)(){
		banner.showWithParen();
	}
	public void printStrong(){
		public banner.showWithAster();
	}
}


