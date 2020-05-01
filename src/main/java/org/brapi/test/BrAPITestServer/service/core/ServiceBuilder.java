package org.brapi.test.BrAPITestServer.service.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.swagger.model.WSMIMEDataTypes;
import io.swagger.model.core.Service;
import io.swagger.model.core.Service.MethodsEnum;
import io.swagger.model.core.Service.VersionsEnum;

public class ServiceBuilder extends ArrayList<Service>{
	private static final long serialVersionUID = 1L;
	private String path = "";
	private String base = "";
	private List<MethodsEnum> methods = new ArrayList<>();

	public ServiceBuilder setBase(String base) {
		this.path = base;
		this.base = base;
		this.methods.clear();
		return this;
	}
	public ServiceBuilder setPath(String newPath) {
		build();
		
		String[] pathParts = this.path.split("/");
		String oldPath = pathParts[pathParts.length - 1].replaceAll("\\{", "\\\\{").replaceAll("\\}", "\\\\}");
		this.path = this.path.replaceFirst(oldPath, newPath);
		this.methods.clear();
		return this;
	}
	public ServiceBuilder addPath(String path) {
		build();
		this.path = this.path + '/' + path;
		this.methods.clear();
		return this;
	}
	
	public ServiceBuilder PUT() {
		methods.add(MethodsEnum.PUT);
		return this;
	}
	
	public ServiceBuilder POST() {
		methods.add(MethodsEnum.POST);
		return this;
	}

	public ServiceBuilder GET() {
		methods.add(MethodsEnum.GET);
		return this;
	}

	public ServiceBuilder build() {
		this.add(buildService(path, methods));
		return this;
	}
	public ServiceBuilder withSearch() {
		build();
		this.add(buildService("search/" + base, Arrays.asList(MethodsEnum.POST)));
		this.add(buildService("search/" + base + "/{searchResultsDbId}", Arrays.asList(MethodsEnum.GET)));
		return this;
	}
	public Service buildService(String path, List<MethodsEnum> methods) {
		Service service = new Service();
		service.addDataTypesItem(WSMIMEDataTypes.APPLICATION_JSON);
		service.setMethods(methods);
		service.addVersionsItem(VersionsEnum._0);
		service.setService(path);
		return service;
	}
}
