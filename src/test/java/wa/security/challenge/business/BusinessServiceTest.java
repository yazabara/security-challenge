package wa.security.challenge.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import wa.security.challenge.auth.UserAuthenticationManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class BusinessServiceTest {

    @Autowired
    private UserAuthenticationManager userAuthenticationManager;
    @Autowired
    private BusinessService businessService;

    @BeforeEach
    void setUp() {
        SecurityContextHolder.clearContext();
    }

    @Test
    @DisplayName("Test Spring @Autowired injection works")
    void injectionWorks() {
        assertNotNull(userAuthenticationManager);
        assertNotNull(businessService);
    }

    @Test
    @DisplayName("Success test with correct credentials")
    void success() {
        Authentication request = new UsernamePasswordAuthenticationToken("BlaBla", "BlaBla");
        Authentication result = userAuthenticationManager.authenticate(request);
        SecurityContextHolder.getContext().setAuthentication(result);
        businessService.someLogic();
    }

    @Test()
    @DisplayName("Failed test with not correct credentials")
    void failed() {
        assertThrows(BadCredentialsException.class, () -> {
            Authentication request = new UsernamePasswordAuthenticationToken("BlaBla", "BlaBla1");
            userAuthenticationManager.authenticate(request);
        });
    }

    @Test
    @DisplayName("Failed test without credentials")
    void failed2() {
        assertThrows(AuthenticationCredentialsNotFoundException.class, () -> businessService.someLogic());
    }
}