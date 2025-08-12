package mylab.user.di.annot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {
	@Value("${userDiAnnotSqlRepo}")
	private String dbType;
    
    public UserRepository() {}
    
    public String getDbType() { return dbType; }
    public void setDbType(String dbType) { this.dbType = dbType; }
    
    public boolean saveUser(String userId, String name) {
        return true;
    }
    
    @Override
    public String toString() {
        return "UserRepository [dbType=" + dbType + "]";
    }
}
