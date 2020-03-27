package org.brapi.test.BrAPITestServer.utility;

import java.util.ArrayList;

import org.brapi.test.BrAPITestServer.model.entity.core.CoordinateEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.GeoJSONEntity;

import io.swagger.model.common.GeoJSON;
import io.swagger.model.common.GeoJSONGeometry;
import io.swagger.model.common.LinearRing;
import io.swagger.model.common.PointGeometry;
import io.swagger.model.common.Polygon;
import io.swagger.model.common.PolygonGeometry;
import io.swagger.model.common.Position;

public class GeoJSONUtility {
	public final static String POINT = "Point";
	public final static String POLYGON = "Polygon";

	public GeoJSONEntity convertToEntity(GeoJSON geojson) {
		GeoJSONEntity entity = new GeoJSONEntity();
		if (geojson.getGeometry() instanceof PointGeometry) {
			entity.setType(POINT);
			Position point = ((PointGeometry) geojson.getGeometry()).getCoordinates();
			CoordinateEntity pointEntity = convertToEntiy(point);
			entity.addCoordinate(pointEntity);
		} else if (geojson.getGeometry() instanceof PolygonGeometry) {
			entity.setType(POLYGON);
			// Only handles single polygons, most plots are rectangles
			Polygon polygon = ((PolygonGeometry) geojson.getGeometry()).getCoordinates();
			if (polygon.size() == 1) {
				LinearRing ring = polygon.get(0);
				for (Position point : ring) {
					CoordinateEntity pointEntity = convertToEntiy(point);
					entity.addCoordinate(pointEntity);
				}
			}
		}
		return entity;
	}

	private CoordinateEntity convertToEntiy(Position pointArray) {
		CoordinateEntity pointEntity = new CoordinateEntity();
		pointEntity.setLatitude(pointArray.get(0));
		pointEntity.setLongitude(pointArray.get(1));
		if (pointArray.size() >= 3) {
			pointEntity.setAltitude(pointArray.get(2));
		}

		return pointEntity;
	}

	public GeoJSON convertFromEntity(GeoJSONEntity entity) {
		GeoJSON geojson = null;
		if (entity != null) {
			geojson = new GeoJSON();
			if (POINT.equals(entity.getType())) {
				PointGeometry geometry = new PointGeometry();
				geometry.setCoordinates(convertFromEntity(entity.getCoordinates().get(0)));
				geojson.setGeometry(geometry);
			} else if (POLYGON.equals(entity.getType())) {
				LinearRing ring = new LinearRing();
				for (CoordinateEntity pointEntity : entity.getCoordinates()) {
					ring.add(convertFromEntity(pointEntity));
				}
				Polygon polygon = new Polygon();
				polygon.add(ring);
				PolygonGeometry geometry = new PolygonGeometry();
				geometry.setCoordinates(polygon);
				geojson.setGeometry(geometry);
			}
		}
		return geojson;
	}

	private Position convertFromEntity(CoordinateEntity entity) {
		Position point = new Position();
		point.add(entity.getLatitude());
		point.add(entity.getLongitude());
		if (entity.getAltitude() != null) {
			point.add(entity.getAltitude());
		}
		return point;
	}
}
