package ua.pp.fland.web.bookkeeping.storage.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.pp.fland.web.bookkeeping.spring.configs.DBTestConfig;
import ua.pp.fland.web.bookkeeping.storage.model.Record;

import java.util.Date;

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
    public void testCount() {
        Assert.assertEquals("Records count before test: ", 0, recordDAO.countAll());
        final long recordsCountToInsert = 47;
        for (int i = 0; i < recordsCountToInsert; i++) {
            Record expectedRecord = new Record();
            expectedRecord.setDescription("some desc " + new Date() + " count " + i);
            recordDAO.save(expectedRecord);
        }
        Assert.assertEquals("Records count after insert: ", recordsCountToInsert, recordDAO.countAll());
    }

    @Test
    public void testDeleteAll() {
        Assert.assertEquals("Records count before test: ", 0, recordDAO.countAll());
        final long recordsCountToInsert = 100;
        for (int i = 0; i < recordsCountToInsert; i++) {
            Record expectedRecord = new Record();
            expectedRecord.setDescription("some desc " + new Date() + " count " + i);
            recordDAO.save(expectedRecord);
        }
        Assert.assertEquals("Records count after insert: ", recordsCountToInsert, recordDAO.countAll());
        recordDAO.deleteAll();
        Assert.assertEquals("Records count after delete all: ", 0, recordDAO.countAll());
    }

    @Test
    public void testInsert() {
        Record expectedRecord = new Record();
        expectedRecord.setDescription("some desc " + new Date());

        recordDAO.save(expectedRecord);

        Record actualRecord = recordDAO.getById(expectedRecord.getId());

        Assert.assertEquals(expectedRecord, actualRecord);
        Assert.assertEquals("Records count: ", 1l, recordDAO.countAll());
    }

    @Test
    public void testSeveralInserts() {
        Record expectedRecord = new Record();
        expectedRecord.setDescription("some desc " + new Date());
        recordDAO.save(expectedRecord);
        Record actualRecord = recordDAO.getById(expectedRecord.getId());
        Assert.assertEquals(expectedRecord, actualRecord);
        Assert.assertEquals("Records count: ", 1l, recordDAO.countAll());

        for (int i = 1; i < 100; i++) {
            expectedRecord = new Record();
            expectedRecord.setDescription("some desc " + new Date() + " count " + i);
            recordDAO.save(expectedRecord);
            actualRecord = recordDAO.getById(expectedRecord.getId());
            Assert.assertEquals(expectedRecord, actualRecord);
            Assert.assertEquals("Records count: ", (i + 1), recordDAO.countAll());
        }
    }
}
