package wa.security.challenge.business;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BusinessService {

    @Secured("ROLE_USER")
    public void someLogic() {
        log.info("Holy-Hoooouuu");
    }
}
