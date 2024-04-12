package at.spengergasse.sst.fixture;

import at.spengergasse.sst.domain.Audio;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

public class AudioFixture {
    private static final String ID= "audio-id";
    private static final Instant CREATED_AT = Instant.from(LocalDate.of(2024, 1, 1));
    private static final String FILEName ="schruttek.mp4";
    private static final String MIME_TYPE = "video/mp4";
    private static final long SIZE = 50000;
    private Duration DURATION = Duration.ofMinutes(60);

    public static Audio createAudioFixture() {
        return new Audio(ID,CREATED_AT,FILEName,MIME_TYPE,SIZE,Duration.ofMinutes(60) );
    }

}
