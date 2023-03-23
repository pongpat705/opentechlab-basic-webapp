package la.opentechlab.training.basicwebapp.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AppRestController {

    @GetMapping("/api/v1/name")
    public String getName(){
        return "Mao";
    }
    @GetMapping("/api/v1/number")
    public Integer getNumber(){
        return 1;
    }

    @PostMapping("/api/v1/map")
    public Map<String, String> getMap(){
        Map<String, String> result = new HashMap<>();
        result.put("name", "Mao");
        return result;
    }
}
