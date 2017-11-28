package org.brapi.test.BrAPITestServer.service;

import java.util.Optional;

import org.brapi.test.BrAPITestServer.model.entity.SampleEntity;
import org.brapi.test.BrAPITestServer.model.rest.Sample;
import org.brapi.test.BrAPITestServer.model.rest.SampleDbIdWrapper;
import org.brapi.test.BrAPITestServer.model.rest.SampleDetail;
import org.brapi.test.BrAPITestServer.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService {
	private SampleRepository sampleRepository;

	@Autowired
	public SampleService(SampleRepository sampleRepository) {
		this.sampleRepository = sampleRepository;
	}

	public SampleDbIdWrapper saveSample(Sample sample) {
		SampleEntity entity = new SampleEntity();
		entity.setNotes(sample.getNotes());
		entity.setPlantId(sample.getPlantId());
		entity.setPlotId(sample.getPlotId());
		entity.setSampleDate(sample.getSampleDate());
		entity.setSampleType(sample.getSampleType());
		entity.setTakenBy(sample.getTakenBy());
		entity.setTissueType(sample.getTissueType());

		entity = sampleRepository.save(entity);

		SampleDbIdWrapper id = new SampleDbIdWrapper();
		id.setSampleId(entity.getId());
		return id;
	}

	public SampleDetail getSample(String sampleId) {

		Optional<SampleEntity> detailOptional = sampleRepository.findById(sampleId);
		SampleDetail sample = null;

		if (detailOptional.isPresent()) {
			sample = new SampleDetail();
			SampleEntity entity = detailOptional.get();
			// TODO need to find out where all this extra data comes from
			sample.setEntryNumber(0);
			sample.setGermplasmDbId(null);
			sample.setHarvestTimestamp(null);
			sample.setLocationDbId(null);
			sample.setLocationName(null);
			sample.setNotes(entity.getNotes());
			sample.setPlantId(entity.getPlantId());
			sample.setPlantingTimestamp(null);
			sample.setPlotId(entity.getPlotId());
			sample.setPlotNumber(0);
			sample.setSampleId(entity.getId());
			sample.setSampleTimestamp(entity.getSampleDate());
			sample.setSampleType(entity.getSampleType());
			sample.setSeason(null);
			sample.setStudyDbId(null);
			sample.setStudyName(null);
			sample.setTakenBy(entity.getTakenBy());
			sample.setTissueType(entity.getTissueType());
		}
		return sample;
	}

}
