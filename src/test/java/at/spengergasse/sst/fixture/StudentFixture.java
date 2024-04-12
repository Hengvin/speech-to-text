package at.spengergasse.sst.fixture;

import at.spengergasse.sst.domain.Role;
import at.spengergasse.sst.domain.Student;
import at.spengergasse.sst.domain.User;
import at.spengergasse.sst.security.password.PasswordService;
import at.spengergasse.sst.security.password.PasswordService.EncodedPassword;

import static org.springframework.security.crypto.factory.PasswordEncoderFactories.createDelegatingPasswordEncoder;

public class StudentFixture {
  public static final String EMAIL = "hengvin@spengergasse.at";
  public static final String PASSWORD = "spengergasse";
  public static final String FIRST_NAME = "Hengvin";
  public static final String LAST_NAME = "Sheikhi";

  private static final PasswordService passwordService =
      new PasswordService(createDelegatingPasswordEncoder());

  private static final EncodedPassword encodedPassword = passwordService.encode(PASSWORD);

  public static User createStudent() {
      return new Student(FIRST_NAME, LAST_NAME, EMAIL, encodedPassword, Role.STUDENT);
  }
}
