package com.example.demo1spring.Controller;


import com.example.demo1spring.Model.Boss;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BossController {

    @GetMapping("/boss")
    public List<Boss> getAllBosses(){ // we have a used a list here as Get looks for a database
        // so we give it a small list that it can understand

        // This list will return hard coded data, whereas in the real world it would be live data
        // within a database
        List<Boss> bossList = new ArrayList<Boss>();
        bossList.add(new Boss(1, "Eric", 22));
        bossList.add(new Boss(1, "Ella", 21));
        bossList.add(new Boss(1, "Alpha", 49));
        bossList.add(new Boss(4, "Delta", 90));
        bossList.add(new Boss(5, "Charlie", 30));

        return bossList;
    }



    @GetMapping("boss1/{bossID}")
    public Boss getBosswithIDOld(@PathVariable Integer bossID){
        return new Boss(6, "MR.Bean", 44);
    }
    // localhost:8989/boss/1 would provide the details of boss with the ID of 1, which is "Eric"

    // However this particular example will  not do this as we have hardcoded the return value

    // In the real world there will be a database to pull the correct ID in match to the "Boss"

    public List<Boss> getBosswithID(int bossID){
        return getAllBosses().stream().filter(boss -> boss.getId() == bossID).collect(Collectors.toList());
    }
    // 1. The above will, first call getAllBosses()
    // 2. Then it will return a Stream through the objects in bossList (getAllBosses output is return bossList)
    // 3. Then with that Stream we will stream through boss objects again except this time using a filter that states
    // look for boss objects, then use the boss.getId() method on each boss object, if the ID returned is equal to
    // bossID that we have entered in the params
    // 4. Then we want to collect and store the True values into a new list and print that list. Basically if
    // the ID entered in params matches the objects id it will be put in the list and shown.

    @GetMapping("boss/{bossID}")
    public List<Boss> getBosswithID1(@PathVariable Integer bossID){
        return getBosswithID(bossID);} // URL entered number will be passed above to "@PathVariable Integer bossID"
    // then we are returning the getBosswithID method (our stream filter method) passing in the URL entered number
    // as the param.






    @PostMapping(path = "/boss/newBoss")
    public void addPerson(@RequestBody Boss boss){
        //again this will return hard coded but in the real world we would be using the database
        //which would be dynamically pulling what is available from there.
        System.out.println("Saving the Boss information to the Database");
    }




}
