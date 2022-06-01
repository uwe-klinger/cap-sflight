package com.sap.cap.sflight.processor;

import java.util.List;

import com.sap.cds.services.cds.CdsService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.After;
import com.sap.cds.services.handler.annotations.ServiceName;

import org.springframework.stereotype.Component;

import cds.gen.travelservice.Travel;
import cds.gen.travelservice.TravelService_;
import cds.gen.travelservice.Travel_;

@Component
@ServiceName(TravelService_.CDS_NAME)
public class DemoHandler implements EventHandler {
	@After(entity = Travel_.CDS_NAME, event = CdsService.EVENT_READ)
	public void modify(List<Travel> travels) {
		//travels.forEach(travel -> travel.setDescription("I ❤️ ride my bicycle."));
	}
}
