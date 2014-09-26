package ua.pp.fland.web.bookkeeping.storage.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created with IntelliJ IDEA.
 * User: maxim
 * Date: 9/25/14
 * Time: 6:50 PM
 * To change this template use File | Settings | File Templates.
 */

@Document(collection = Record.COLLECTION_NAME)
public class Record {

    public static final String COLLECTION_NAME = "records";

    @Id
    private String id;

    private String decs;

    public Record() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDecs() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (decs != null ? !decs.equals(record.decs) : record.decs != null) return false;
        if (id != null ? !id.equals(record.id) : record.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (decs != null ? decs.hashCode() : 0);
        return result;
    }
}
