package la.opentechlab.training.basicwebapp.restcontroller;

import la.opentechlab.training.basicwebapp.controller.AppController;
import la.opentechlab.training.basicwebapp.model.StudentModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class AppRestController {

    private Map<String, Integer> ageMap = new HashMap<>();
    private List<String> nameList = new ArrayList<>();

    private Set<String> nameSet = new HashSet<>();

    public AppRestController() {
        ageMap.put("mao", 15);
        ageMap.put("bank", 16);
        ageMap.put("james", 17);

        nameList.add("mao");
        nameList.add("mao");
        nameList.add("mao");
        nameList.add("mao");

        nameSet.add("mao");
        nameSet.add("mao");
        nameSet.add("mao");
        nameSet.add("mao");


    }

    @GetMapping("/api/v1/name")
    public String getName(){
        return "Mao";
    }
    @GetMapping("/api/v1/number")
    public Integer getNumber(){
        Integer integer = 1;
        int myInt = 1;

        return 1;
    }

    @PostMapping("/api/v1/map")
    public Map<String, Integer> getMap(@RequestParam String name){
        Map<String, Integer> result = new HashMap<>();
        result.put("result", this.ageMap.get(name));
        return result;
    }
    @GetMapping("/api/v1/nameList")
    public Map<String, Integer> getNameList(){
        Map<String, Integer> result = new HashMap<>();

        for (String x : ageMap.keySet()) {

            if(!x.equals("mao")){
                result.put(x, ageMap.get(x));
            }
        }

        return result;
    }
    @GetMapping("/api/v1/nameSet")
    public Map<String, Set<String>> getNameSet(){
        Map<String, Set<String>> result = new HashMap<>();
        result.put("result", this.nameSet);

        return result;
    }
}
