package org.brapi.test.BrAPITestServer.service.germ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.LocationEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.ProgramEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.CrossEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.SeedLotContentMixtureEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.SeedLotEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.SeedLotTransactionEntity;
import org.brapi.test.BrAPITestServer.repository.germ.SeedLotRepository;
import org.brapi.test.BrAPITestServer.repository.germ.SeedLotTransactionRepository;
import org.brapi.test.BrAPITestServer.service.DateUtility;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.brapi.test.BrAPITestServer.service.UpdateUtility;
import org.brapi.test.BrAPITestServer.service.core.LocationService;
import org.brapi.test.BrAPITestServer.service.core.ProgramService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.germ.SeedLot;
import io.swagger.model.germ.SeedLotContentMixture;
import io.swagger.model.germ.SeedLotNewRequest;
import io.swagger.model.germ.SeedLotNewTransactionRequest;
import io.swagger.model.germ.SeedLotTransaction;

@Service
public class SeedLotService {

	private final SeedLotRepository seedLotRepository;
	private final SeedLotTransactionRepository seedLotTransactionRepository;
	private final GermplasmService germplasmService;
	private final CrossService crossService;
	private final LocationService locationService;
	private final ProgramService programService;

	public SeedLotService(SeedLotRepository seedLotRepository,
			SeedLotTransactionRepository seedLotTransactionRepository, GermplasmService germplasmService,
			CrossService crossService, LocationService locationService, ProgramService programService) {
		this.seedLotRepository = seedLotRepository;
		this.seedLotTransactionRepository = seedLotTransactionRepository;
		this.germplasmService = germplasmService;
		this.crossService = crossService;
		this.locationService = locationService;
		this.programService = programService;
	}

	public List<SeedLot> findSeedLots(String seedLotDbId, String germplasmDbId, String germplasmName, String crossDbId,
			String crossName, String commonCropName, String programDbId, String externalReferenceId,
			String externalReferenceID, String externalReferenceSource, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<SeedLotEntity> searchQuery = new SearchQueryBuilder<SeedLotEntity>(SeedLotEntity.class);

		if (seedLotDbId != null)
			searchQuery = searchQuery.appendSingle(seedLotDbId, "id");
		if (crossDbId != null || crossName != null || germplasmDbId != null || germplasmName != null) {
			searchQuery = searchQuery.join("contentMixture", "contentMixture")
					.appendSingle(crossDbId, "*contentMixture.cross.id")
					.appendSingle(crossName, "*contentMixture.cross.name")
					.appendSingle(germplasmDbId, "*contentMixture.germplasm.id")
					.appendSingle(germplasmName, "*contentMixture.germplasm.name");
		}
		if (commonCropName != null)
			searchQuery = searchQuery.appendSingle(commonCropName, "program.crop.crop_name");
		if (programDbId != null)
			searchQuery = searchQuery.appendSingle(programDbId, "program.id");
		if (externalReferenceID != null && externalReferenceSource != null)
			searchQuery = searchQuery.withExRefs(Arrays.asList(externalReferenceID),
					Arrays.asList(externalReferenceSource));

		Page<SeedLotEntity> page = seedLotRepository.findAllBySearch(searchQuery, pageReq);
		List<SeedLot> seedLots = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return seedLots;
	}

	public SeedLot getSeedLot(String seedLotDbId) throws BrAPIServerException {
		return convertFromEntity(getSeedLotEntity(seedLotDbId, HttpStatus.NOT_FOUND));
	}

	public SeedLotEntity getSeedLotEntity(String seedLotDbId) throws BrAPIServerException {
		return getSeedLotEntity(seedLotDbId, HttpStatus.BAD_REQUEST);
	}

	public SeedLotEntity getSeedLotEntity(String seedLotDbId, HttpStatus errorStatus) throws BrAPIServerException {
		SeedLotEntity seedLot = null;
		Optional<SeedLotEntity> entityOpt = seedLotRepository.findById(seedLotDbId);
		if (entityOpt.isPresent()) {
			seedLot = entityOpt.get();
		} else {
			throw new BrAPIServerDbIdNotFoundException("seed lot", seedLotDbId);
		}
		return seedLot;
	}

	public List<SeedLot> saveSeedLots(@Valid List<SeedLotNewRequest> body) throws BrAPIServerException {
		List<SeedLot> savedValues = new ArrayList<>();

		for (SeedLotNewRequest list : body) {
			SeedLotEntity entity = new SeedLotEntity();
			updateEntity(entity, list);
			SeedLotEntity savedEntity = seedLotRepository.save(entity);
			savedValues.add(convertFromEntity(savedEntity));
		}

		return savedValues;
	}

	public SeedLot updateSeedLot(String seedLotDbId, @Valid SeedLotNewRequest body) throws BrAPIServerException {
		SeedLotEntity savedEntity;
		Optional<SeedLotEntity> entityOpt = seedLotRepository.findById(seedLotDbId);
		if (entityOpt.isPresent()) {
			SeedLotEntity entity = entityOpt.get();
			updateEntity(entity, body);

			savedEntity = seedLotRepository.save(entity);
		} else {
			throw new BrAPIServerDbIdNotFoundException("seed lot", seedLotDbId);
		}

		return convertFromEntity(savedEntity);
	}

	public List<SeedLotTransaction> findSeedLotTransactions(String seedLotDbId, String transactionDbId,
			String transactionDirection, Metadata metadata) throws BrAPIServerException {
		SeedLot seedLot = getSeedLot(seedLotDbId);
		if (seedLot != null) {
			return findSeedLotTransactions(transactionDbId, seedLotDbId, null, null, null, null, null, null, null, null,
					null, metadata);
		}
		return null;
	}

	public List<SeedLotTransaction> findSeedLotTransactions(String transactionDbId, String seedLotDbId,
			String germplasmDbId, String germplasmName, String crossDbId, String crossName, String commonCropName,
			String programDbId, String externalReferenceId, String externalReferenceID, String externalReferenceSource,
			Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<SeedLotTransactionEntity> searchQuery = new SearchQueryBuilder<SeedLotTransactionEntity>(
				SeedLotTransactionEntity.class);

		if (transactionDbId != null)
			searchQuery = searchQuery.appendSingle(transactionDbId, "id");
		if (seedLotDbId != null)
			searchQuery = searchQuery.appendSingle(seedLotDbId, "toSeedLot.id");
		if (crossDbId != null || crossName != null || germplasmDbId != null || germplasmName != null) {
			searchQuery = searchQuery.join("toSeedLot.contentMixture", "contentMixture")
					.appendSingle(crossDbId, "*contentMixture.cross.id")
					.appendSingle(crossName, "*contentMixture.cross.name")
					.appendSingle(germplasmDbId, "*contentMixture.germplasm.id")
					.appendSingle(germplasmName, "*contentMixture.germplasm.name");
		}
		if (commonCropName != null)
			searchQuery = searchQuery.appendSingle(commonCropName, "toSeedLot.program.crop.crop_name");
		if (programDbId != null)
			searchQuery = searchQuery.appendSingle(programDbId, "toSeedLot.program.id");
		
		if (externalReferenceID != null && externalReferenceSource != null)
			searchQuery = searchQuery.withExRefs(Arrays.asList(externalReferenceID),
					Arrays.asList(externalReferenceSource));

		Page<SeedLotTransactionEntity> page = seedLotTransactionRepository.findAllBySearch(searchQuery, pageReq);
		List<SeedLotTransaction> transactions = page.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, page);
		return transactions;
	}

	public List<SeedLotTransaction> saveSeedLotTransactions(@Valid List<SeedLotNewTransactionRequest> body)
			throws BrAPIServerException {
		List<SeedLotTransaction> savedValues = new ArrayList<>();

		for (SeedLotNewTransactionRequest list : body) {
			SeedLotTransactionEntity entity = new SeedLotTransactionEntity();
			updateEntity(entity, list);
			SeedLotTransactionEntity savedEntity = seedLotTransactionRepository.save(entity);
			savedValues.add(convertFromEntity(savedEntity));
		}

		return savedValues;
	}

	private SeedLot convertFromEntity(SeedLotEntity entity) {
		SeedLot seedLot = new SeedLot();
		UpdateUtility.convertFromEntity(entity, seedLot);

		seedLot.setAmount(entity.getAmount());
		seedLot.setCreatedDate(DateUtility.toOffsetDateTime(entity.getCreatedDate()));
		seedLot.setLastUpdated(DateUtility.toOffsetDateTime(entity.getLastUpdated()));
		if (entity.getLocation() != null) {
			seedLot.setLocationDbId(entity.getLocation().getId());
			seedLot.setLocationName(entity.getLocation().getLocationName());
		}
		if (entity.getProgram() != null) {
			seedLot.setProgramDbId(entity.getProgram().getId());
			seedLot.setProgramName(entity.getProgram().getName());
		}
		seedLot.setSeedLotDbId(entity.getId());
		seedLot.setSeedLotDescription(entity.getDescription());
		seedLot.setSeedLotName(entity.getName());
		seedLot.setSourceCollection(entity.getSourceCollection());
		seedLot.setStorageLocation(entity.getStorageLocation());
		seedLot.setUnits(entity.getUnits());
		if (entity.getContentMixture() != null && !entity.getContentMixture().isEmpty()) {
			seedLot.setGermplasmDbId(entity.getContentMixture().get(0).getGermplasm().getId());
			seedLot.setContentMixture(entity.getContentMixture().stream().map(mixtureEntity -> {
				SeedLotContentMixture mixture = new SeedLotContentMixture();
				if (mixtureEntity.getCross() != null) {
					mixture.setCrossDbId(mixtureEntity.getCross().getId());
					mixture.setCrossName(mixtureEntity.getCross().getName());
				}
				if (mixtureEntity.getGermplasm() != null) {
					mixture.setGermplasmDbId(mixtureEntity.getGermplasm().getId());
					mixture.setGermplasmName(mixtureEntity.getGermplasm().getGermplasmName());
				}
				mixture.setMixturePercentage(mixtureEntity.getMixturePercentage());
				return mixture;
			}).collect(Collectors.toList()));
		}
		return seedLot;
	}

	private void updateEntity(SeedLotEntity entity, SeedLotNewRequest seedLot) throws BrAPIServerException {
		UpdateUtility.updateEntity(seedLot, entity);

		if (seedLot.getAmount() != null)
			entity.setAmount(seedLot.getAmount());
		if (seedLot.getCreatedDate() != null)
			entity.setCreatedDate(DateUtility.toDate(seedLot.getCreatedDate()));
		if (seedLot.getLastUpdated() != null)
			entity.setLastUpdated(DateUtility.toDate(seedLot.getLastUpdated()));
		if (seedLot.getLocationDbId() != null) {
			LocationEntity location = locationService.getLocationEntity(seedLot.getLocationDbId());
			entity.setLocation(location);
		}
		if (seedLot.getProgramDbId() != null) {
			ProgramEntity program = programService.getProgramEntity(seedLot.getProgramDbId());
			entity.setProgram(program);
		}
		if (seedLot.getSeedLotDescription() != null)
			entity.setDescription(seedLot.getSeedLotDescription());
		if (seedLot.getSeedLotName() != null)
			entity.setName(seedLot.getSeedLotName());
		if (seedLot.getSourceCollection() != null)
			entity.setSourceCollection(seedLot.getSourceCollection());
		if (seedLot.getStorageLocation() != null)
			entity.setStorageLocation(seedLot.getStorageLocation());
		if (seedLot.getUnits() != null)
			entity.setUnits(seedLot.getUnits());
		if (seedLot.getContentMixture() != null) {
			entity.setContentMixture(seedLot.getContentMixture().stream().map(mixture -> {
				SeedLotContentMixtureEntity mixtureEntity = new SeedLotContentMixtureEntity();
				try {
					if (mixture.getCrossDbId() != null) {
						CrossEntity cross = crossService.getCrossEntity(mixture.getCrossDbId(), false);
						mixtureEntity.setCross(cross);
					}
					if (mixture.getGermplasmDbId() != null) {
						GermplasmEntity germplasm;
						germplasm = germplasmService.getGermplasmEntity(mixture.getGermplasmDbId());

						mixtureEntity.setGermplasm(germplasm);
					}
					if (mixture.getMixturePercentage() != null) {
						mixtureEntity.setMixturePercentage(mixture.getMixturePercentage());
					}
					mixtureEntity.setSeedLot(entity);
				} catch (BrAPIServerException e) {
					e.printStackTrace();
				}
				return mixtureEntity;
			}).collect(Collectors.toList()));
		}
	}

	private SeedLotTransaction convertFromEntity(SeedLotTransactionEntity entity) {
		SeedLotTransaction transaction = new SeedLotTransaction();
		UpdateUtility.convertFromEntity(entity, transaction);
		transaction.setAmount(entity.getAmount());
		if (entity.getToSeedLot() != null)
			transaction.setToSeedLotDbId(entity.getToSeedLot().getId());
		if (entity.getFromSeedLot() != null)
			transaction.setFromSeedLotDbId(entity.getFromSeedLot().getId());
		transaction.setTransactionDbId(entity.getId());
		transaction.setTransactionDescription(entity.getDescription());
		transaction.setTransactionTimestamp(DateUtility.toOffsetDateTime(entity.getTimestamp()));
		transaction.setUnits(entity.getUnits());
		return transaction;
	}

	private void updateEntity(SeedLotTransactionEntity entity, SeedLotNewTransactionRequest seedLot)
			throws BrAPIServerException {
		UpdateUtility.updateEntity(seedLot, entity);

		if (seedLot.getAmount() != null)
			entity.setAmount(seedLot.getAmount());
		if (seedLot.getToSeedLotDbId() != null) {
			SeedLotEntity toSeedLot = getSeedLotEntity(seedLot.getToSeedLotDbId());
			entity.setToSeedLot(toSeedLot);
		}
		if (seedLot.getFromSeedLotDbId() != null) {
			SeedLotEntity fromSeedLot = getSeedLotEntity(seedLot.getFromSeedLotDbId());
			entity.setFromSeedLot(fromSeedLot);
		}
		if (seedLot.getTransactionDescription() != null)
			entity.setDescription(seedLot.getTransactionDescription());
		if (seedLot.getTransactionTimestamp() != null)
			entity.setTimestamp(DateUtility.toDate(seedLot.getTransactionTimestamp()));
		if (seedLot.getUnits() != null)
			entity.setUnits(seedLot.getUnits());

	}
}
