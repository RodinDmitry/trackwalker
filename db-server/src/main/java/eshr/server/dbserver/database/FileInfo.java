package eshr.server.dbserver.database;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FileInfo {

    @Id
    @GeneratedValue
    public long id;

    public String name;

}
