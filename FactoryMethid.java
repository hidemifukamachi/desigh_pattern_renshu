Factory Method パターン

instanceを生成する工場をtemplateMethodパターンで構成したものがFactoryMethodパターン
インスタンスの作り方をスーパークラスで定めるが具体的なクラス名までは定めない
具体的な肉付けはすべてサブクラスの側で行う
これにより、インスタンス生成のための枠組みと実際のインスタンス生成をのクラスを分けて考えることができる。

Product.java

public abstract class Product {
	public abstract void use();
}


Factory.java
public abstract class Factory {
	public final Product createProduct(String owner){
		Product  p = createProduct(String owner);
		registerProduct(p);
		return p;
	}
	protected abstract Product createProduct(String owner);
	protected abstract void registerProduct(Product product);
}


public class IDCard extends Product {
	private String owner;
	IDCard(String owner) {
		System.out.println(owner + "のカード作成");
		this.owner = owner;
	}
	public void use(){
		System.out.println(owner +"のカードを使用する");
	}
	public String getOwner(){
		return owner;
	}
}

IDCardFactory.java

public class IDCardFactory extends Factory {
	private List owners = new ArrayList();
	protected Product createProduct(String owner){
		return new IDCard(owner);
	}
	protected void registerProduct(Product product){
		owners.add((IDCard)product.getOwner());
	}
	public List getOwner(){
		return owners;
	}
}

public class Main {
	public static void main (String[] args){
		Factory factory = new IDCardFactory();
		Product card1 = new factory.create("山田太郎");
		Priduct card2 = new factory.create("田中花子");
		card1.use();
		card2.use();
	}
}



