package myApp.boardApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/security")
public class SecurityController {
    @Autowired(required = true)
    private SecurityService securityService;

    @GetMapping("/create/token") //@PostMapping
    public Map<String, Object> createToken(@RequestParam(value = "subject") String subject){
        String token = securityService.createToken(subject, (2*1000*60L));
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", token);
        return map;
    }

    @GetMapping("/get/subject")
    public Map<String, Object> jetSubject(@RequestParam(value = "token") String token){
        String subject = securityService.getSubject(token);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", subject);
        return map;
    }
}
