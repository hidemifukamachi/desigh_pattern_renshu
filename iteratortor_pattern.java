javaデザインパターン

１.Iteratorパターン

for(int i = 0; i < arr.length; i ++){
	System.out.println(arr[i])
}

この変数iを抽象化し、一般化したものをiteratorパターンという


AggregateInterfaceー数え上げるものの集合体


Aggregate.java

  public interface Aggregate{
	public abstract Iterator iterator();
}


Iterator.java　interatorインターフェイス
public interface Iterator {
	public abstract boolean hasNext();
	public abstract Objet next();
}

hasnext() - 次の要素が存在するか確認
next() - Objectを返す

Book.java
public class Book{
	private String name;

	public Book(String name){
		this.name = name;
	}
	public Stromg getName(){
		return name;
	}
}

BookShelf.java

public class BoolShelf implements Aggregate{
	private Book[] book;
	private int last = 0;
	public BookShelf(int maxsize){
		this.books = new Book[maxsize];
	}
	public Book getBookAt(int index){
		return books[index];
	}
	public void appendBook (Book book){
		this.books[last] = book;
		last++;
	}
	public int getLength(){
		return last;
	}
	public iterarot(){
		return new BoolShelfIterator(this);
	}
}

BookShelfIerator.java - bookshelfをスキャンするクラス

public class BoolShelfIterator implements Iterator{
	private BookShelf BookShelf;
	private int index ;
	public BookShelfIterator(BookShelf bookShelf){
		this.bookshelf = bookshelf;
		this.index = 0;
	}

	public boolean hasNext(){
		if(index < bookShelf.getLength()){
			return true;
		}else{
			return false;
		}
	}
	public Object next(){
		Book book = bookShelf.getBookSt(index);
		index++;
		return book;
	}
}

main
public class Main{
	public static void main(String[] args) {
		BookShelf bookshelf = new BookShelf(4);
		bookshelf.appeendBook(new Book("オイラーの公式");		
		bookshelf.appeendBook(new Book("そろばんのしょ");
		bookshelf.appeendBook(new Book("フェルマーの最終定理");
		bookshelf.appeendBook(new Book("Javaデザインパターン");
		Iterator it = bookShelf.iterator();
		while (it.hasNext()){
			Book book = (Book)it.next;
			System.out.println(book.getName);
		}
	}
}






