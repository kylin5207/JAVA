package test;

import dao.ItemsDao;
import dao.impl.ItemsDaoImpl;
import domain.Items;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ItemsTest {
    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        ItemsDao dao = new ItemsDaoImpl();
        List<Items> list = dao.findAll();

        for (Items items : list) {
            System.out.println(items);
        }
    }
}
