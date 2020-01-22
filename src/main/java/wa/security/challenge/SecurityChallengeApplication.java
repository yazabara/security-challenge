package wa.security.challenge;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wa.security.challenge.auth.UserAuthenticationManager;
import wa.security.challenge.business.BusinessService;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class SecurityChallengeApplication implements CommandLineRunner {

    private final UserAuthenticationManager userAuthenticationManager;
    private final BusinessService businessService;

    public static void main(String[] args) {
        log.info("Starting the application");
        SpringApplication.run(SecurityChallengeApplication.class, args);
        log.info("application finished");
    }

    @Override
    public void run(String... args) {
        // authorization custom block
//        Authentication request = new UsernamePasswordAuthenticationToken("BlaBla", "BlaBla");
//        Authentication result = userAuthenticationManager.authenticate(request);
//        SecurityContextHolder.getContext().setAuthentication(result);
        // business logic
//        businessService.someLogic();
    }
}
