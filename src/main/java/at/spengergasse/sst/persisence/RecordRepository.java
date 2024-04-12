package at.spengergasse.sst.persisence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import at.spengergasse.sst.domain.Record;

@Repository
public interface RecordRepository extends MongoRepository<Record, String> {
}
