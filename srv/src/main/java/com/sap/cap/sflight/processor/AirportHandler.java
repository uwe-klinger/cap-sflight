package com.sap.cap.sflight.processor;

import java.util.List;

import com.sap.cds.services.cds.CdsService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.After;
import com.sap.cds.services.handler.annotations.ServiceName;

import org.springframework.stereotype.Component;

import cds.gen.travelservice.Airport;
import cds.gen.travelservice.Airport_;
import cds.gen.travelservice.TravelService_;

@Component
@ServiceName(TravelService_.CDS_NAME)
public class AirportHandler implements EventHandler {
	
	@After(entity = Airport_.CDS_NAME, event = CdsService.EVENT_READ)
	public void modifyCode(List<Airport> airports) {
		airports.forEach(airport -> airport.setCity("stadt"));
	}
}
