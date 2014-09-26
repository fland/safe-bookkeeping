package ua.pp.fland.web.bookkeeping.storage.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.pp.fland.web.bookkeeping.spring.configs.DBTestConfig;
import ua.pp.fland.web.bookkeeping.storage.model.Record;

/**
 * Created with IntelliJ IDEA.
 * User: maxim
 * Date: 9/25/14
 * Time: 7:36 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBTestConfig.class)
public class RecordDAOTest {

    @Autowired
    private RecordDAO recordDAO;

    @Before
    public void dropRecordsTAble() {
        recordDAO.deleteAll();
    }

    @Test
    public void testInsert() {
        Record record = new Record();
        record.setDecs("some desc");

        recordDAO.save(record);
    }
}
