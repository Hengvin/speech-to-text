package at.spengergasse.sst.security;

import at.spengergasse.sst.security.password.PasswordEncoderConfig;
import at.spengergasse.sst.security.password.PasswordService;
import at.spengergasse.sst.security.password.PasswordService.EncodedPassword;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = {PasswordService.class})
@Import(PasswordEncoderConfig.class)
public class PasswordServiceTest {
  // Test Fixtures
  public static final String STRONG_PASSWORD = "schrutek is the best teacher ever!";
  public static final String WEAK_PASSWORD = "password";

  @Autowired PasswordService passwordService;

  @Test
  public void encode_shouldFail_whenProvidingWeakPasswords() {
    // When / Then
    assertThrows(IllegalArgumentException.class, () -> passwordService.encode(WEAK_PASSWORD));
  }

  @Test
  public void encode_shouldPass_whenProvidingStrongPasswords() {
    // When
    EncodedPassword encoded = passwordService.encode(STRONG_PASSWORD);

    // Then
    assertThat(encoded, is(notNullValue()));
  }

  @Test
  public void encode_shouldReturnHashes_whenProvidingStrongPasswords() {
    // When
    EncodedPassword password = passwordService.encode(STRONG_PASSWORD);

    // Then
    assertThat(password.getEncodedPassword(), is(not(equalTo(STRONG_PASSWORD))));
  }

  @Test
  public void encode_shouldProduceDifferentHashes_whenProvidingSamePasswords() {
    // Given
    String password = STRONG_PASSWORD;

    // When
    EncodedPassword firstEncodedPassword = passwordService.encode(password);
    EncodedPassword secondEncodedPassword = passwordService.encode(password);

    // Then
    assertThat(
        firstEncodedPassword.getEncodedPassword(),
        is(not(equalTo(secondEncodedPassword.getEncodedPassword()))));
  }
}
