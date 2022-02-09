import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;

public class MySQLAdsDao implements Ads{
    private Connection connection;

    public MySQLAdsDao(Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());
        this.connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );

    }
    // get a list of all the ads
    public List<Ad> all(){
        List<Ad> ads = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query = "SELECT * FROM ads";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(query);
            while(rs.next()){
                Ad newAd = new Ad(rs.getInt("id"), rs.getInt("user_id"),rs.getString("title"),rs.getString("description"));
                ads.add(newAd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ads;
    };
    // insert a new ad and return the new ad's id
    public Long insert(Ad ad){
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Long id = null;
        String insert_query = "INSERT INTO ads (user_id, title, description) VALUES('"+ad.getUserId()+"','"+ad.getTitle()+"','"+ad.getDescription()+"')";
        try {
            statement.executeUpdate(insert_query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()){
                id = rs.getLong(1);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    };


}
