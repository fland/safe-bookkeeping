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

    private String description;

    public Record() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (description != null ? !description.equals(record.description) : record.description != null) return false;
        if (id != null ? !id.equals(record.id) : record.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
