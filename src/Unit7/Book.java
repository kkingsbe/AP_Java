package Unit7;

public class Book extends ReadingMaterial{
    private String title;
    private String author;
    public Book(int cost, int pages, int wordsPerPage, String mTitle, String mAuthor)
    {
        super.setCost(cost);
        super.setPages(pages);
        super.setWordsPerPage(wordsPerPage);
        title = mTitle;
        author = mAuthor;
    }

    public String getTitle()
    {
        return title;
    }
    public void setTitle(String mTitle)
    {
        title = mTitle;
    }
    public String getAuthor()
    {
        return author;
    }
    public void setAuthor(String mAuthor)
    {
        author = mAuthor;
    }
}
