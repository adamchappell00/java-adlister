import java.util.ArrayList;
import java.util.Arrays;

public class BeanTest {
    public static void main(String[] args) {
        Album mayday = new Album(1,"The Warning", "Mayday",2021, 5,  "Rock, Metal");
        Album makeYourself = new Album(2,"Incubus","Make Yourself",1999,10,"Alt Rock");
        Author douglas = new Author(1,"Douglas","Adams");
        Author mark = new Author(2,"Mark","Twain");
        Author kurt = new Author(3,"Kurt","Vonnegut");
        Quote deadlines = new Quote(1,"I love deadlines. I love the whooshing noise they make as they go by.", douglas);
        Quote panic = new Quote(2,"Don't Panic",douglas);
        Quote clothes = new Quote(3,"Clothes make the man. Naked people have little or no influence o society.", mark);
        Quote universe = new Quote(4,"The universe is a big place, perhaps the biggest.", kurt);
        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.addAll(Arrays.asList(deadlines, panic, clothes,universe));
        for(Quote quote : quotes){
            System.out.printf("\""+quote.getText()+"\" - "+quote.getAuthor().getFirstName()+" "+quote.getAuthor().getLastName()+"\n");
        };

    }
}
