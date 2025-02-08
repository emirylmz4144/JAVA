import java.sql.SQLException;

@FunctionalInterface
//Metot Delegasyonu için oluşturulmuştur
public interface FuncInterface
{
    public void Invoke() throws SQLException;
}
