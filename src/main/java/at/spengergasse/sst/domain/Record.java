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
@Document(collection = "record")
public class Record extends BaseEntity<String> {
    private  String lectureId;
    private String title;
    private Audio audio;
    private String audioLang;
    private String transcript;
    private String transcriptLang;


    // ctor -----------------------------------------------------------------

    @PersistenceCreator
    @JsonCreator
    protected Record(String id) {
        super(id);
    }

    public Record(
        String lectureId, String title, Audio audio,
        String audioLang, String transcript, String transcriptLang
    ) {
        super(generateUUIDv4());

        this.lectureId = lectureId;
        this.title = hasMaxText(title, 255, "title");
        this.audio = audio;
        this.audioLang = hasMaxText(audioLang, 255, "audioLang");
        this.transcript = transcript;
        this.transcriptLang = hasMaxText(transcriptLang, 255, "transcriptLang");
    }
}
