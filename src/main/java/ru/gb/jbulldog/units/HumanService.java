package ru.gb.jbulldog.units;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class HumanService {

    Logger log;

    public HumanService() {
        this.log = Logger.getLogger(HumanService.class.getName());
    }

    List<Human> getHumansByProfessionCode(final List<Human> humans, final int code){
        if(humans == null || humans.isEmpty()){
            log.fine("Empty humans list!");
            return new ArrayList<Human>();
        }

        boolean flag = false;
        for(final Human.Profession p: Human.Profession.values()){
            if (p.getCode() == code) {
                flag = true;
                break;
            }
        }
        if(!flag){
            log.severe("Non valid code");
            throw new IllegalStateException("Non valid code");
        }

        final List<Human> result = new ArrayList<Human>();
        for(final Human human: humans){
            if(human.getProfession().getCode() == code){
                result.add(human);
            }
        }
        log.fine(String.format("Find %s items.", result.size()));

        return result;
    }



}
