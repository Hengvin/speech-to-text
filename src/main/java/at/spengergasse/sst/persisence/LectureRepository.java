package at.spengergasse.sst.persisence;

import at.spengergasse.sst.domain.Lecture;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LectureRepository extends MongoRepository<Lecture, String>{
}
