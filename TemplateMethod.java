テンプレートメソッドパターン

テンプレートの機能を持つパターン
・スーパークラスの中にテンプレートを定義→スーパークラスだけでは最終的にどのような処理になるかわからない。
・わかるのは抽象メソッドをどのようによびだしているかだけ。
・抽象メソッドを実際に実装するのはサブクラス

スーパークラスで定義されていることがサブクラスでも利用できる
サブクラスに少しメソッドを書くだけで新しい機能が追加される
サブクラスでメソッドをオーバ−ライドすれば振る舞いを変更できる

AbstractDisplay.java

public abstract class AbstractDisplay {
	public abstract void open();	//サブクラスに実装を任せる抽象メソッド
	public abstract void print();	//サブクラスに実装を任せる抽象メソッド
	public abstract void close();	//サブクラスに実装を任せる抽象メソッド
	public final void display(){
		open();
		for(int i=0; i<5;i++){
			print(); 	//5回printを繰り返す
		}
		close();
	}
}

CharDisplay.java

public class CharDisplay extends abstract {
	private char ch;
	public CharDisplay(char ch){
		this.ch = ch;
	}
	public void open(){
		System.out.print("<<");
	}
	public void print(){
		System.out.print(ch){
		}
	}
	public void close(){
		System.out.println(">>")
	}
}



StringDisplay.java

public class StringDisplay extends AbstractDisplay {

	private　String string;
	private int width;
	public StringDisplay(String string){
		this.string = string;
		this.width = string.getBytes().length;
	}

	public void open(){
		printLine();
	}

	public void print(){
		System.out.println("|" +string+ "|");
	}
	public close(){
		printLine();
	}

	private void print printLine(){
		System.out.print("+");
		for(int i=0;i<width;i++){
			System.out.print("-");
		}
		System.out.println("+");
	}
}


Main.java
public class main {
	public static void main (String[] string){
		AbstractDisplay d1 = new CharDisplay('H');
		AbstractDisplay d2 = new StringDisplay("Hello,world");
		AbstractDisplay d3 = new StringDisplay("こんにちは！");

		d1.display();
		d2.display();
		d3.display();
	}
}
