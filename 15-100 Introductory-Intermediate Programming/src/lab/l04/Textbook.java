package lab.l04;

class Textbook {

  private String title;
  private String author;
  private int pages;
  private float price;
  private String comments;


  public class NegativePagesException extends Exception {
    public NegativePagesException(String message) {
      super (message);
    }
  }


  public class NegativePriceException extends Exception {
    public NegativePriceException(String message) {
      super (message);
    }
  }


  public Textbook (String title, String author, int pages) 
    throws NegativePagesException, NegativePriceException {

    if (price < 0)
      throw new NegativePriceException ("Attempt to construct book, " +
            title + " with a negative price, $" + price + ".");

    if (pages < 0)
      throw new NegativePagesException ("Attempt to construct book, " +
            title + " with a negative number of pages " + pages + ".");

    this.title = title;
    this.author=author;
    this.pages=pages;
    this.price=-1.00f;
    this.comments ="";
  }


  public Textbook (String title, String author, int pages, float price, 
                   String comments) 
                   throws NegativePagesException, NegativePriceException {

    if (price < 0)
      throw new NegativePagesException ("Attempt to construct book, " +
            title + " with a negative price, $" + price + ".");

    if (pages < 0)
      throw new NegativePagesException ("Attempt to construct book, " +
            title + " with a negative number of pages " + pages + ".");
    this.title = title;
    this.author=author;
    this.pages=pages;
    this.price=price;
    this.comments=comments;
  }


  public String getTitle() {
    return title;
  }


  public String getAuthor() {
    return author;
  }


  public int getPages() {
    return pages;
  }


  public float getPrice() {
    return price;
  }


  public String getComments() {
    return comments;
  }


  public String toString() {
    return title + "\n" +
           author + "\n" + 
           "$" + price + "\n" + 
           pages + " pages" + "\n";
  }


  public void setPrice(float price) {
    this.price = price;
  }


  public void addComment(String newComment) {
    this.comments = this.comments + newComment + "\n";
  }

}
