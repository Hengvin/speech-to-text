package at.spengergasse.sst.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;

import static at.spengergasse.sst.foundation.AssertUtil.hasMaxText;
import static at.spengergasse.sst.foundation.EntityUtil.generateUUIDv4;

@Getter
@ToString(callSuper = true)
@Document(collection = "lecture")
public class Lecture extends BaseEntity<String> {

    private String studentId;
    private String teacher;
    private String subject;


    // ctor -----------------------------------------------------------------

    @PersistenceCreator
    @JsonCreator
    protected Lecture(String id) {
        super(id);
    }

    public Lecture(String studentId, String teacher, String subject) {
        super(generateUUIDv4());

        this.studentId = studentId;
        this.teacher = hasMaxText(teacher, 255, "teacher");
        this.subject = hasMaxText(subject, 255, "subject");
    }


}
