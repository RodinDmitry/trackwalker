package eshr.server.dbserver.database;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileInfoRepository extends CrudRepository<FileInfo, Long> {

}
