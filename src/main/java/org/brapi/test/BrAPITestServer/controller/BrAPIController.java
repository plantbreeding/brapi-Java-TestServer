package org.brapi.test.BrAPITestServer.controller;

import java.util.ArrayList;
import java.util.Date;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.exceptions.InvalidPagingException;
import org.brapi.test.BrAPITestServer.service.DateUtility;

import io.swagger.model.Metadata;
import io.swagger.model.MetadataPagination;

public class BrAPIController {
	protected Metadata generateMetaDataTemplate(Integer page, Integer pageSize) throws BrAPIServerException {
		validatePaging(page, pageSize);

		// defaults
		if (page == null) {
			page = 0;
		}
		if (pageSize == null) {
			pageSize = 1000;
		}

		Metadata metaData = generateEmptyMetadata();
		metaData.getPagination().setCurrentPage(page);
		metaData.getPagination().setPageSize(pageSize);
		return metaData;
	}

	protected AsyncMetadata generateAsynchMetaDataTemplate(Integer page, Integer pageSize) throws BrAPIServerException {
		AsyncMetadata metadata = new AsyncMetadata(generateMetaDataTemplate(page, pageSize));
		metadata.getAsynchStatus().setAsynchId("");
		metadata.getAsynchStatus().setEndTime(DateUtility.toDateString(new Date()));
		metadata.getAsynchStatus().setPercentComplete(100);
		metadata.getAsynchStatus().setStartTime(DateUtility.toDateString(new Date()));
		metadata.getAsynchStatus().setStatus(AsyncMetadataStatusEnum.FINISHED);
		return metadata;
	}

	private void validatePaging(Integer page, Integer pageSize) throws BrAPIServerException {
		boolean pageValid = (page == null) || (page >= 0);
		if (!pageValid)
			throw new InvalidPagingException("page");
		boolean pageSizeValid = (pageSize == null) || (pageSize >= 1);
		if (!pageSizeValid)
			throw new InvalidPagingException("pageSize");

	}

	protected Metadata generateEmptyMetadata() {
		Metadata metaData = new Metadata();
		metaData.setDatafiles(new ArrayList<>());
		metaData.setStatus(new ArrayList<>());
		metaData.setPagination(new MetadataPagination());
		metaData.getPagination().setCurrentPage(0);
		metaData.getPagination().setPageSize(0);
		metaData.getPagination().setTotalCount(0);
		metaData.getPagination().setTotalPages(0);
		return metaData;
	}

	protected class AsyncMetadata extends Metadata {
		private AsyncMetadataStatus asynchStatus;

		public AsyncMetadata(Metadata metaData) {
			this.setAsynchStatus(new AsyncMetadataStatus());
			this.setDatafiles(metaData.getDatafiles());
			this.setPagination(metaData.getPagination());
			this.setStatus(metaData.getStatus());
		}

		public AsyncMetadataStatus getAsynchStatus() {
			return asynchStatus;
		}

		public void setAsynchStatus(AsyncMetadataStatus asynchStatus) {
			this.asynchStatus = asynchStatus;
		}
	}

	protected class AsyncMetadataStatus {
		private String asynchId;
		private String endTime;
		private Integer percentComplete;
		private String startTime;
		private AsyncMetadataStatusEnum status;
		
		public String getAsynchId() {
			return asynchId;
		}
		public void setAsynchId(String asynchId) {
			this.asynchId = asynchId;
		}
		public String getEndTime() {
			return endTime;
		}
		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
		public Integer getPercentComplete() {
			return percentComplete;
		}
		public void setPercentComplete(Integer percentComplete) {
			this.percentComplete = percentComplete;
		}
		public String getStartTime() {
			return startTime;
		}
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		public AsyncMetadataStatusEnum getStatus() {
			return status;
		}
		public void setStatus(AsyncMetadataStatusEnum status) {
			this.status = status;
		}
		
	}

	protected enum AsyncMetadataStatusEnum {
		STARTED, PENDING, FINISHED, ERROR
	}

}
