package com.spinny.service;

import com.spinny.entity.Agent;
import com.spinny.entity.ScheduleVisit;
import com.spinny.entity.Zone;
import com.spinny.repository.AgentRepository;
import com.spinny.repository.ScheduleVisitRepository;
import com.spinny.repository.ZoneRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerCareService {

    private ScheduleVisitRepository scheduleVisitRepository;
    private ZoneRepository zoneRepository;


    public CustomerCareService(ScheduleVisitRepository scheduleVisitRepository, ZoneRepository zoneRepository) {
        this.scheduleVisitRepository = scheduleVisitRepository;
        this.zoneRepository = zoneRepository;
    }
    //find the scheduleVisit object based on scheduleVisitid & taking the scheduleVisit object getting the zone by calling the getAddress() method of scheduleVisit object & in zone object agent object is there inside, so using getAgent() getting agent from the zone table & then saving that scheduleVisit object
    //using same scheduleVisit id we're just setting the agent and saving the scheduleVisit object again by changing the agent_id column from null to agent_id value means agent object
    public String allocateAgent(long scheduleVisitId){
        ScheduleVisit scheduleVisit = scheduleVisitRepository.findById(scheduleVisitId).get();
        Zone zone  = findZone(scheduleVisit.getAddress());
        Agent agent = zone.getAgent();
        scheduleVisit.setAgent(agent);
        scheduleVisitRepository.save(scheduleVisit);
        return "allocated";
    }

    //using the address from scheduleVisit table finding the zone from zone table
    public Zone findZone(String address){
        return zoneRepository.findByArea(address);

    }
}
