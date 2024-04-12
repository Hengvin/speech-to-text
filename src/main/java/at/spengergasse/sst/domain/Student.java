package at.spengergasse.sst.domain;

import at.spengergasse.sst.foundation.AssertUtil;
import at.spengergasse.sst.security.password.PasswordService;
import at.spengergasse.sst.security.password.PasswordService.EncodedPassword;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.PersistenceCreator;

@Getter
@ToString(callSuper = true)
public class Student extends User {
    private String firstName;
    private String lastName;


    // ctor -----------------------------------------------------------------

    @PersistenceCreator
    @JsonCreator
    protected Student(String id) {
        super(id);
    }

    public Student (String firstName, String lastName, String email, EncodedPassword password, Role role) {
        super(email, password, role);
        this.firstName = AssertUtil.hasMaxText(firstName, 255, "firstName");
        this.lastName = AssertUtil.hasMaxText(lastName, 255, "lastname");
    }
}
